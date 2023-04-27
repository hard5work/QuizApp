package com.anish.app.quizapp.data.repository;

import com.anish.app.quizapp.data.api.ApiService;
import com.anish.app.quizapp.data.api.Constants;
import com.anish.app.quizapp.data.model.QuestionModel;

import java.util.ArrayList;

import javax.inject.Inject;

import dagger.hilt.android.scopes.ActivityScoped;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;


public class ApiRepository {
    @Inject
    public ApiService apiService;

    @Inject
    public ApiRepository(ApiService apiService) {
        this.apiService = apiService;
    }


    public Observable<ArrayList<QuestionModel>> getQuestionList() {
        return apiService.getQuestions(Constants.API_KEY).subscribeOn(Schedulers.io());
    }
}
