package com.anish.app.quizapp.data.model;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CorrectAnswers implements Serializable {
    private String answerACorrect;
    private String answerBCorrect;
    private String answerCCorrect;
    private String answerDCorrect;
    private String answerECorrect;
    private String answerFCorrect;

    @SerializedName("answer_a_correct")
    public String getAnswerACorrect() {
        return answerACorrect;
    }

    @SerializedName("answer_a_correct")
    public void setAnswerACorrect(String value) {
        this.answerACorrect = value;
    }

    @SerializedName("answer_b_correct")
    public String getAnswerBCorrect() {
        return answerBCorrect;
    }

    @SerializedName("answer_b_correct")
    public void setAnswerBCorrect(String value) {
        this.answerBCorrect = value;
    }

    @SerializedName("answer_c_correct")
    public String getAnswerCCorrect() {
        return answerCCorrect;
    }

    @SerializedName("answer_c_correct")
    public void setAnswerCCorrect(String value) {
        this.answerCCorrect = value;
    }

    @SerializedName("answer_d_correct")
    public String getAnswerDCorrect() {
        return answerDCorrect;
    }

    @SerializedName("answer_d_correct")
    public void setAnswerDCorrect(String value) {
        this.answerDCorrect = value;
    }

    @SerializedName("answer_e_correct")
    public String getAnswerECorrect() {
        return answerECorrect;
    }

    @SerializedName("answer_e_correct")
    public void setAnswerECorrect(String value) {
        this.answerECorrect = value;
    }

    @SerializedName("answer_f_correct")
    public String getAnswerFCorrect() {
        return answerFCorrect;
    }

    @SerializedName("answer_f_correct")
    public void setAnswerFCorrect(String value) {
        this.answerFCorrect = value;
    }

    @Override
    public String toString() {
        return "CorrectAnswers{" +
                "answerACorrect='" + answerACorrect + '\'' +
                ", answerBCorrect='" + answerBCorrect + '\'' +
                ", answerCCorrect='" + answerCCorrect + '\'' +
                ", answerDCorrect='" + answerDCorrect + '\'' +
                ", answerECorrect='" + answerECorrect + '\'' +
                ", answerFCorrect='" + answerFCorrect + '\'' +
                '}';
    }
}

