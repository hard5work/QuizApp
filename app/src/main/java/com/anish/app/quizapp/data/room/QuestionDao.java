package com.anish.app.quizapp.data.room;

import android.database.Observable;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.anish.app.quizapp.data.model.QuestionModel;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface QuestionDao {
    @Query("Select * FROM questionModel")
    List<QuestionModel> getQuestions();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(QuestionModel... user);
}
