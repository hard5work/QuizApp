package com.anish.app.quizapp.data.model;

import android.nfc.Tag;

import androidx.room.ProvidedTypeConverter;
import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
@ProvidedTypeConverter
public class ListConverter {
    @TypeConverter
    public static ArrayList<QuestionModel.Tags> fromString(String value) {
        Type listType = new TypeToken<ArrayList<QuestionModel.Tags>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String toString(ArrayList<QuestionModel.Tags> value) {
        Gson gson = new Gson();
        return gson.toJson(value);
    }
}
