package com.anish.app.quizapp.data.api;


import com.anish.app.quizapp.data.model.QuestionModel;

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;

public interface ApiService {
    @GET(Constants.GET_QUESTIONS)
    Observable<ArrayList<QuestionModel>> getQuestions(@Header("X-Api-Key") String Authorization);
}
