package com.anish.app.quizapp.data.sp;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPref{
    private SharedPreferences sharedPreferences;

    public SharedPref(Context context) {
        sharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
    }

    public String getUsername() {
        return sharedPreferences.getString("username", "");
    }


    public void setUsername(String username) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", username);
        editor.commit();
    }

}
