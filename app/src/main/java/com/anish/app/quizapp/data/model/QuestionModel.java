package com.anish.app.quizapp.data.model;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

@Entity(tableName = "QuestionModel")
public class QuestionModel implements Serializable {
    @PrimaryKey
    private int id;


    private String question;
    private String description;
    @Embedded
    private Answers answers;
    private String multipleCorrectAnswers;
    @Embedded
    private CorrectAnswers correctAnswers;
    private String correctAnswer;
    private String explanation;
    private String tip;
    @TypeConverters({ListConverter.class})
    private ArrayList<Tags> tags;
    private String category;
    private String difficulty;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @SerializedName("question")
    public String getQuestion() {
        return question;
    }

    @SerializedName("question")
    public void setQuestion(String value) {
        this.question = value;
    }

    @SerializedName("description")
    public String getDescription() {
        return description;
    }

    @SerializedName("description")
    public void setDescription(String value) {
        this.description = value;
    }

    @SerializedName("answers")
    public Answers getAnswers() {
        return answers;
    }

    @SerializedName("answers")
    public void setAnswers(Answers value) {
        this.answers = value;
    }

    @SerializedName("multiple_correct_answers")
    public String getMultipleCorrectAnswers() {
        return multipleCorrectAnswers;
    }

    @SerializedName("multiple_correct_answers")
    public void setMultipleCorrectAnswers(String value) {
        this.multipleCorrectAnswers = value;
    }

    @SerializedName("correct_answers")
    public CorrectAnswers getCorrectAnswers() {
        return correctAnswers;
    }

    @SerializedName("correct_answers")
    public void setCorrectAnswers(CorrectAnswers value) {
        this.correctAnswers = value;
    }

    @SerializedName("correct_answer")
    public String getCorrectAnswer() {
        return correctAnswer;
    }

    @SerializedName("correct_answer")
    public void setCorrectAnswer(String value) {
        this.correctAnswer = value;
    }

    @SerializedName("explanation")
    public String getExplanation() {
        return explanation;
    }

    @SerializedName("explanation")
    public void setExplanation(String value) {
        this.explanation = value;
    }

    @SerializedName("tip")
    public String getTip() {
        return tip;
    }

    @SerializedName("tip")
    public void setTip(String value) {
        this.tip = value;
    }

    @SerializedName("tags")
    public ArrayList<Tags> getTags() {
        return tags;
    }

    @SerializedName("tags")
    public void setTags(ArrayList<Tags> value) {
        this.tags = value;
    }

    @SerializedName("category")
    public String getCategory() {
        return category;
    }

    @SerializedName("category")
    public void setCategory(String value) {
        this.category = value;
    }

    @SerializedName("difficulty")
    public String getDifficulty() {
        return difficulty;
    }

    @SerializedName("difficulty")
    public void setDifficulty(String value) {
        this.difficulty = value;
    }

    @Override
    public String toString() {
        return "QuestionModel{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", description='" + description + '\'' +
                ", answers=" + answers +
                ", multipleCorrectAnswers='" + multipleCorrectAnswers + '\'' +
                ", correctAnswers=" + correctAnswers +
                ", correctAnswer='" + correctAnswer + '\'' +
                ", explanation='" + explanation + '\'' +
                ", tip='" + tip + '\'' +
                ", tags=" + tags +
                ", category='" + category + '\'' +
                ", difficulty='" + difficulty + '\'' +
                '}';
    }
}
