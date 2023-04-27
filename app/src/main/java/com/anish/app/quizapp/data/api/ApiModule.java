package com.anish.app.quizapp.data.api;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttp;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class ApiModule {
    @Provides
    @Singleton
    public static String provideBaseUser() {
        return Constants.BASE_URL;
    }
/*
    @Provides
    @Singleton
    String provideConnectionTimeout() {
        return NETWORK_TIMEOUT;
    }*/

    @Provides
    @Singleton
    public static Gson provideGson() {
        return new GsonBuilder().setLenient().create();
    }

    @Provides
    @Singleton
    public static OkHttpClient provideOkHttpClient() {
//        if(BuildConfig.Debug){
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        Interceptor requestInterceptor = new Interceptor() {
            @NonNull
            @Override
            public Response intercept(@NonNull Chain chain) throws IOException {
                HttpUrl url = chain.request()
                        .url()
                        .newBuilder()
                        .build();

                Request request = chain.request()
                        .newBuilder()
                        .url(url)
                        .build();
                return chain.proceed(request);
            }
        };
        return new OkHttpClient
                .Builder()
                .addInterceptor(requestInterceptor)
                .addInterceptor(loggingInterceptor)
                .build();


//        } else {
     /*   new OkHttpClient
                .Builder()
                .build();*/
//        }
    }


    @Provides
    @Singleton
    public static ApiService provideRetrofit(String baseUrl, Gson gson, OkHttpClient client) {
        return new Retrofit.Builder().baseUrl(baseUrl).client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class);

    }
}
