package com.anish.app.quizapp.ui.quiz;

import android.util.Log;
import android.view.View;

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
import com.anish.app.quizapp.utils.layout.ButtonComponent;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

@AndroidEntryPoint
public class QuizFragment extends BaseFragment<FragmentQuizBinding> {
    private FragmentQuizBinding mViewDataBinding;

    private ButtonComponent buttonComponent;
    @Inject
    AppDatabase appDatabase;

    private QuizVM quizVM;
    private String TAG = "QuizFragment";

    @Override
    public int getLayoutId() {
        return R.layout.fragment_quiz;
    }

    @Override
    protected void initView(View mRootView, ViewDataBinding mViewDataBinding) {
        this.mViewDataBinding = (FragmentQuizBinding) mViewDataBinding;

        quizVM = new ViewModelProvider(this).get(QuizVM.class);

        buttonComponent = new ButtonComponent(this.mViewDataBinding.submit);
        buttonComponent.setText("SUBMIT");
        buttonComponent.onClicked(v -> {
            Navigation.findNavController(v).navigate(R.id.action_quizFragment_to_resultFragment);
        });
        questionObserver();
        getDataFromRoom();
    }

    private void questionObserver() {
        quizVM.getData().observe(this, arrayListResource -> {
            switch (arrayListResource.getStatus()) {
                case ERROR:
                    break;
                case SUCCESS:
                    for (QuestionModel data : arrayListResource.getData()) {
                        try {
                            appDatabase.questionDao().insert(data);
                        } catch (Exception e) {
                            Log.e(TAG, "CATCH EXCEPTION WHILE INSERTING DATA " + e.getMessage());
                        }
                    }
                    break;
                case LOADING:
                    break;
            }

        });

    }

    private void getDataFromRoom() {
        List<QuestionModel> entities = appDatabase.questionDao().getQuestions();
        for (QuestionModel data : entities) {

            Log.e(TAG, "data from DB " + data);

        }
    }
}
