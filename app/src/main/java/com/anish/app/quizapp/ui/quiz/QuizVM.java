package com.anish.app.quizapp.ui.quiz;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.anish.app.quizapp.data.model.QuestionModel;
import com.anish.app.quizapp.data.repository.ApiRepository;
import com.anish.app.quizapp.data.room.AppDatabase;
import com.anish.app.quizapp.utils.NetworkHelper;
import com.anish.app.quizapp.utils.enums.Resource;

import java.util.ArrayList;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

@HiltViewModel
public class QuizVM extends ViewModel {

    @Inject
    AppDatabase appDatabase;
    private String TAG = "QuizVM";
    public ApiRepository apiRepository;
    public NetworkHelper networkHelper;
    private MutableLiveData<Resource<ArrayList<QuestionModel>>> models = new MutableLiveData<>();
    public LiveData<Resource<ArrayList<QuestionModel>>> _data;
    private MutableLiveData<Resource<ArrayList<QuestionModel>>> offline = new MutableLiveData<>();
    public LiveData<Resource<ArrayList<QuestionModel>>> _getOfflinedata;

    public LiveData<Resource<ArrayList<QuestionModel>>> getData() {
        if (_data == null) {
            _data = models;
        }
        return _data;
    }

    @Inject
    public QuizVM(ApiRepository apiRepository, NetworkHelper helper) {
        this.apiRepository = apiRepository;
        this.networkHelper = helper;
        getQuestions();
    }

    private void getQuestions() {

        models.postValue(Resource.loading(null));
        if (networkHelper.isNetworkConnected()) {
            apiRepository.getQuestionList().subscribe(new Observer<ArrayList<QuestionModel>>() {
                @Override
                public void onSubscribe(Disposable d) {
                    Log.e(TAG, "onSubscrible");
                }

                @Override
                public void onNext(ArrayList<QuestionModel> value) {

                    Log.e(TAG, "on Next onSubscrible " + value.size());
                    models.postValue(Resource.success(value));
                }

                @Override
                public void onError(Throwable e) {
                    Log.e(TAG, "on Error " + e.getMessage());
                    models.postValue(Resource.error(e.getMessage(), null));

                }

                @Override
                public void onComplete() {
                    Log.e(TAG, "onCompleted");

                }
            });
        } else {
            models.postValue(Resource.error("No Internet connection", null));
        }

    }
    void setOfflineData(ArrayList<QuestionModel> model) {
        for (QuestionModel data : model) {
            try {
                appDatabase.questionDao().insert(data);
            } catch (Exception e) {
                Log.e(TAG, "CATCH EXCEPTION WHILE INSERTING DATA " + e.getMessage());
            }
        }


    }
}
