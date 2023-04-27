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
    public static ArrayList<Tags> fromString(String value) {
        Type listType = new TypeToken<ArrayList<Tags>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String toString(ArrayList<Tags> value) {
        Gson gson = new Gson();
        return gson.toJson(value);
    }
}
