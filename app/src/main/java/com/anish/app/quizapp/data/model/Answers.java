package com.anish.app.quizapp.data.model;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Answers implements Serializable {
    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;
    private String answerE;
    private String answerF;

    @SerializedName("answer_a")
    public String getAnswerA() { return answerA; }
    @SerializedName("answer_a")
    public void setAnswerA(String value) { this.answerA = value; }

    @SerializedName("answer_b")
    public String getAnswerB() { return answerB; }
    @SerializedName("answer_b")
    public void setAnswerB(String value) { this.answerB = value; }

    @SerializedName("answer_c")
    public String getAnswerC() { return answerC; }
    @SerializedName("answer_c")
    public void setAnswerC(String value) { this.answerC = value; }

    @SerializedName("answer_d")
    public String getAnswerD() { return answerD; }
    @SerializedName("answer_d")
    public void setAnswerD(String value) { this.answerD = value; }

    @SerializedName("answer_e")
    public String getAnswerE() { return answerE; }
    @SerializedName("answer_e")
    public void setAnswerE(String value) { this.answerE = value; }

    @SerializedName("answer_f")
    public String getAnswerF() { return answerF; }
    @SerializedName("answer_f")
    public void setAnswerF(String value) { this.answerF = value; }

    @Override
    public String toString() {
        return "Answers{" +
                "answerA='" + answerA + '\'' +
                ", answerB='" + answerB + '\'' +
                ", answerC='" + answerC + '\'' +
                ", answerD='" + answerD + '\'' +
                ", answerE='" + answerE + '\'' +
                ", answerF='" + answerF + '\'' +
                '}';
    }
}

