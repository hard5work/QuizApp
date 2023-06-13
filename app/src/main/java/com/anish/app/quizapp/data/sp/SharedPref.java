package com.anish.app.quizapp.data.sp;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;


public class SharedPref implements SharedPreferencesWrapper {

    SharedPreferences sharedPreferences;


    public SharedPref(Context context) {
        this.sharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
    }

    @Override
    public void setUsername(String value) {
        SharedPreferences.Editor editor = this.sharedPreferences.edit();
        editor.putString("username", value);
        editor.apply();
    }

    @Override
    public String getUsername() {
        return this.sharedPreferences.getString("username", "");
    }
}
