package com.anish.app.quizapp.ui.quiz;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.anish.app.quizapp.R;
import com.anish.app.quizapp.data.model.QuestionModel;
import com.anish.app.quizapp.data.room.AppDatabase;
import com.anish.app.quizapp.data.room.QuestionDao;
import com.anish.app.quizapp.databinding.FragmentQuizBinding;
import com.anish.app.quizapp.databinding.FragmentQuizBinding;
import com.anish.app.quizapp.ui.base.BaseFragment;
import com.anish.app.quizapp.utils.enums.Resource;
import com.anish.app.quizapp.utils.enums.Status;
import com.anish.app.quizapp.utils.layout.AnswerComponent;
import com.anish.app.quizapp.utils.layout.ButtonComponent;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

@AndroidEntryPoint
public class QuizFragment extends BaseFragment<FragmentQuizBinding> {
    private FragmentQuizBinding mViewDataBinding;

    private ButtonComponent buttonComponent;
    private AnswerComponent answerA;
    private AnswerComponent answerB;
    private AnswerComponent answerC;
    private AnswerComponent answerD;
    private AnswerComponent answerE;
    private AnswerComponent answerF;
    long timerDuration = 120000;
    private CountDownTimer timer;
    private String selectedAnswer = "";
    @Inject
    AppDatabase appDatabase;
    private List<QuestionModel> myQuestionList = new ArrayList<>();

    private QuestionModel currentModel;
    Random rand = new Random();
    private int maxQuestion = 9;
    private int countQuestion = 0;
    private int totalPoints = 0;

    private int randNumber = 0;
    private QuizVM quizVM;

    private boolean ansA = false;
    private boolean ansB = false;
    private boolean ansC = false;
    private boolean ansD = false;
    private boolean ansE = false;
    private boolean ansF = false;
    private String TAG = "QuizFragment";

    private InterstitialAd mInterstitialAd;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_quiz;
    }

    @Override
    protected void initView(View mRootView, ViewDataBinding mViewDataBinding) {
        this.mViewDataBinding = (FragmentQuizBinding) mViewDataBinding;

        quizVM = new ViewModelProvider(this).get(QuizVM.class);

        AdRequest adRequest = new AdRequest.Builder().build();
        InterstitialAd.load(requireContext(), requireContext().getResources().getString(R.string.ad_id_interstitial_live), adRequest, new InterstitialAdLoadCallback() {
            @Override
            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                super.onAdLoaded(interstitialAd);
                mInterstitialAd = interstitialAd;
                Log.e(TAG, "adv is now loaded");
            }

            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                super.onAdFailedToLoad(loadAdError);
                mInterstitialAd = null;
                Log.e(TAG,"adv load failed -> " + loadAdError.getMessage());
            }
        });


        initialsViews();
        onAnswerClicked();
        onSubmit();

        questionObserver();
        getDataFromRoom();

        ((FragmentQuizBinding) mViewDataBinding).questions.setText(getQuestionData());
        ((FragmentQuizBinding) mViewDataBinding).progressBar.setMax(100);
        timer = new CountDownTimer(timerDuration, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                // calculate the remaining time in minutes and seconds
                int second = (int) millisUntilFinished / 1000;
                double percents = (second * 100) / 120;
                int percent = (int) percents;
                // update the TextView with the remaining time
                ((FragmentQuizBinding) mViewDataBinding).progressPoint.setText(String.valueOf(second));
                ((FragmentQuizBinding) mViewDataBinding).progressBar.setProgress(percent);

            }

            @Override
            public void onFinish() {
                navigateNextPage(mViewDataBinding.getRoot());


            }
        }.start();
    }

    private void showFullScreenAd(){

        mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
            @Override
            public void onAdClicked() {
                super.onAdClicked();
            }

            @Override
            public void onAdDismissedFullScreenContent() {
                super.onAdDismissedFullScreenContent();
                mInterstitialAd = null;
                navigateNextPage(mViewDataBinding.getRoot());
            }

            @Override
            public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                super.onAdFailedToShowFullScreenContent(adError);
                mInterstitialAd = null;
                navigateNextPage(mViewDataBinding.getRoot());
            }

            @Override
            public void onAdImpression() {
                super.onAdImpression();
            }

            @Override
            public void onAdShowedFullScreenContent() {
                super.onAdShowedFullScreenContent();
            }
        });
    }
    private void onSubmit() {
        buttonComponent.onClicked(v -> {
            if (!selectedAnswer.isEmpty()) {
                if (!isMultiple()) {
                    if (isAnswerACorrect()) {
                        totalPoints += 10;
                    } else if (isAnswerBCorrect()) {
                        totalPoints += 10;
                    } else if (isAnswerCCorrect()) {
                        totalPoints += 10;
                    } else if (isAnswerDCorrect()) {
                        totalPoints += 10;
                    } else if (isAnswerECorrect()) {
                        totalPoints += 10;
                    } else if (isAnswerFCorrect()) {
                        totalPoints += 10;
                    }

                } else {
                    if (isAnswerACorrect() || isAnswerBCorrect() || isAnswerCCorrect() || isAnswerDCorrect()
                            || isAnswerECorrect() || isAnswerFCorrect()) {
                        totalPoints += 10;
                    }

                }
                mViewDataBinding.scores.setText(String.valueOf(totalPoints));
                if (countQuestion >= maxQuestion) {
                    if (mInterstitialAd != null) {
                        mInterstitialAd.show(requireActivity());
                        showFullScreenAd();
                    } else
                        navigateNextPage(v);
                } else {
                    getRandomNumber();
                    countQuestion++;
                    mViewDataBinding.questions.setText(getQuestionData());
                }

            } else {
                Toast.makeText(requireContext(), "Please answer and submit", Toast.LENGTH_LONG).show();
            }

        });
    }

    private void navigateNextPage(View v) {
        hideDialog();
        timer.cancel();
        Bundle bundle = new Bundle();
        bundle.putInt("myArgument", totalPoints);
        Navigation.findNavController(v).navigate(R.id.action_quizFragment_to_resultFragment, bundle);
        totalPoints = 0;
    }

    private void initialsViews() {
        buttonComponent = new ButtonComponent(this.mViewDataBinding.submit);
        answerA = new AnswerComponent(this.mViewDataBinding.answerA);
        answerB = new AnswerComponent(this.mViewDataBinding.answerB);
        answerC = new AnswerComponent(this.mViewDataBinding.answerC);
        answerD = new AnswerComponent(this.mViewDataBinding.answerD);
        answerE = new AnswerComponent(this.mViewDataBinding.answerE);
        answerF = new AnswerComponent(this.mViewDataBinding.answerF);
        buttonComponent.setText("SUBMIT");
    }

    private void questionObserver() {
        quizVM.getData().observe(this, arrayListResource -> {
            switch (arrayListResource.getStatus()) {
                case ERROR:
                    hideDialog();
                    getDataFromRoom();
                    if (myQuestionList.size() > 0)
                        getRandomNumber();
                    else {
                        timer.cancel();
                        Toast.makeText(requireContext(), "Sorry, Data not available please connect to internet", Toast.LENGTH_LONG).show();
                    }
                    break;
                case SUCCESS:
                    hideDialog();
                    myQuestionList.clear();
                    quizVM.setOfflineData(arrayListResource.getData());
                    getDataFromRoom();
                    getRandomNumber();

                    break;
                case LOADING:
                    showDialog();
                    break;
            }

        });

    }

    private String getQuestionData() {
        return getString(R.string.my_string, countQuestion + 1);
    }

    private void getDataFromRoom() {
        List<QuestionModel> entities = appDatabase.questionDao().getQuestions();
        myQuestionList.addAll(entities);
    }

    private void getRandomNumber() {
        selectedAnswer = "";
        randNumber = rand.nextInt((myQuestionList.size() - 2) + 1);
        mViewDataBinding.setQuestionModel(myQuestionList.get(randNumber));
        viewAnswers(myQuestionList.get(randNumber));
        unSelectAll();
        hideDialog();
    }

    private void viewAnswers(QuestionModel model) {
        currentModel = model;
        if (model.getAnswers() == null) {
            getRandomNumber();
            return;
        }
        setVisibleItems(model.getAnswers().getAnswerA(), mViewDataBinding.answerA.getRoot());
        setVisibleItems(model.getAnswers().getAnswerB(), mViewDataBinding.answerB.getRoot());
        setVisibleItems(model.getAnswers().getAnswerC(), mViewDataBinding.answerC.getRoot());
        setVisibleItems(model.getAnswers().getAnswerD(), mViewDataBinding.answerD.getRoot());
        setVisibleItems(model.getAnswers().getAnswerE(), mViewDataBinding.answerE.getRoot());
        setVisibleItems(model.getAnswers().getAnswerF(), mViewDataBinding.answerF.getRoot());

    }

    private void setVisibleItems(String ans, View view) {
        if (ans == null) {
            view.setVisibility(View.GONE);
        } else {
            view.setVisibility(View.VISIBLE);
        }
    }

    private void onAnswerClicked() {
        answerA.onClicked(v -> {
            ansA = isMultipleSelection(answerA, "answer_a", ansA);
        });
        answerB.onClicked(v -> {
            ansB = isMultipleSelection(answerB, "answer_b", ansB);
        });
        answerC.onClicked(v -> {
            ansC = isMultipleSelection(answerC, "answer_c", ansC);
        });
        answerD.onClicked(v -> {
            ansD = isMultipleSelection(answerD, "answer_d", ansD);
        });
        answerE.onClicked(v -> {
            ansE = isMultipleSelection(answerE, "answer_e", ansE);
        });
        answerF.onClicked(v -> {
            ansF = isMultipleSelection(answerF, "answer_f", ansF);
        });


    }

    private void setSelection(AnswerComponent ans) {
        ans.onSelect(requireContext());
    }

    private void unSelectAll() {
        answerA.unSelect(requireContext());
        answerB.unSelect(requireContext());
        answerC.unSelect(requireContext());
        answerD.unSelect(requireContext());
        answerE.unSelect(requireContext());
        answerF.unSelect(requireContext());
        ansA = false;
        ansB = false;
        ansC = false;
        ansD = false;
        ansE = false;
        ansF = false;
    }

    private boolean isMultipleSelection(AnswerComponent view, String answer, boolean ans) {
        boolean vals;
        if (currentModel.getMultipleCorrectAnswers().equals("false")) {
            selectedAnswer = answer;
            unSelectAll();
            setSelection(view);
            vals = true;
        } else {

            selectedAnswer = answer;
            if (ans) {
                view.unSelect(requireContext());
            } else {
                view.onSelect(requireContext());
            }
            vals = !ans;
        }
        return vals;
    }

    private boolean isMultiple() {
        return currentModel.getMultipleCorrectAnswers().equals("true");
    }


    private boolean isAnswerACorrect() {
        return currentModel.getCorrectAnswers().getAnswerACorrect().equals("true") && ansA;
    }

    private boolean isAnswerBCorrect() {
        return currentModel.getCorrectAnswers().getAnswerBCorrect().equals("true") && ansB;
    }

    private boolean isAnswerCCorrect() {
        return currentModel.getCorrectAnswers().getAnswerCCorrect().equals("true") && ansC;
    }

    private boolean isAnswerDCorrect() {
        return currentModel.getCorrectAnswers().getAnswerDCorrect().equals("true") && ansD;
    }

    private boolean isAnswerECorrect() {
        return currentModel.getCorrectAnswers().getAnswerECorrect().equals("true") && ansE;

    }

    private boolean isAnswerFCorrect() {
        return currentModel.getCorrectAnswers().getAnswerFCorrect().equals("true") && ansF;
    }

}
