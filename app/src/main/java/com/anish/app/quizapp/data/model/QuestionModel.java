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
    @SerializedName("multiple_correct_answers")
    private String multipleCorrectAnswers;
    @SerializedName("correct_answers")
    @Embedded
    private CorrectAnswers correctAnswers;
    @SerializedName("correct_answer")
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

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Answers getAnswers() {
        return answers;
    }

    public void setAnswers(Answers answers) {
        this.answers = answers;
    }

    public String getMultipleCorrectAnswers() {
        return multipleCorrectAnswers;
    }

    public void setMultipleCorrectAnswers(String multipleCorrectAnswers) {
        this.multipleCorrectAnswers = multipleCorrectAnswers;
    }

    public CorrectAnswers getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(CorrectAnswers correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public ArrayList<Tags> getTags() {
        return tags;
    }

    public void setTags(ArrayList<Tags> tags) {
        this.tags = tags;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
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

    public static class Answers implements Serializable {
        @SerializedName("answer_a")
        private String answerA;
        @SerializedName("answer_b")
        private String answerB;
        @SerializedName("answer_c")
        private String answerC;
        @SerializedName("answer_d")
        private String answerD;
        @SerializedName("answer_e")
        private String answerE;
        @SerializedName("answer_f")
        private String answerF;

        public String getAnswerA() {
            return answerA;
        }

        public void setAnswerA(String answerA) {
            this.answerA = answerA;
        }

        public String getAnswerB() {
            return answerB;
        }

        public void setAnswerB(String answerB) {
            this.answerB = answerB;
        }

        public String getAnswerC() {
            return answerC;
        }

        public void setAnswerC(String answerC) {
            this.answerC = answerC;
        }

        public String getAnswerD() {
            return answerD;
        }

        public void setAnswerD(String answerD) {
            this.answerD = answerD;
        }

        public String getAnswerE() {
            return answerE;
        }

        public void setAnswerE(String answerE) {
            this.answerE = answerE;
        }

        public String getAnswerF() {
            return answerF;
        }

        public void setAnswerF(String answerF) {
            this.answerF = answerF;
        }

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


    public static class CorrectAnswers implements Serializable {
        @SerializedName("answer_a_correct")
        private String answerACorrect;
        @SerializedName("answer_b_correct")
        private String answerBCorrect;
        @SerializedName("answer_c_correct")
        private String answerCCorrect;
        @SerializedName("answer_d_correct")
        private String answerDCorrect;
        @SerializedName("answer_e_correct")
        private String answerECorrect;
        @SerializedName("answer_f_correct")
        private String answerFCorrect;

        public String getAnswerACorrect() {
            return answerACorrect;
        }

        public void setAnswerACorrect(String answerACorrect) {
            this.answerACorrect = answerACorrect;
        }

        public String getAnswerBCorrect() {
            return answerBCorrect;
        }

        public void setAnswerBCorrect(String answerBCorrect) {
            this.answerBCorrect = answerBCorrect;
        }

        public String getAnswerCCorrect() {
            return answerCCorrect;
        }

        public void setAnswerCCorrect(String answerCCorrect) {
            this.answerCCorrect = answerCCorrect;
        }

        public String getAnswerDCorrect() {
            return answerDCorrect;
        }

        public void setAnswerDCorrect(String answerDCorrect) {
            this.answerDCorrect = answerDCorrect;
        }

        public String getAnswerECorrect() {
            return answerECorrect;
        }

        public void setAnswerECorrect(String answerECorrect) {
            this.answerECorrect = answerECorrect;
        }

        public String getAnswerFCorrect() {
            return answerFCorrect;
        }

        public void setAnswerFCorrect(String answerFCorrect) {
            this.answerFCorrect = answerFCorrect;
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

    @Entity(tableName = "Tags")
    public static class Tags {
        private String name;

        @SerializedName("name")
        public String getName() {
            return name;
        }

        @SerializedName("name")
        public void setName(String value) {
            this.name = value;
        }

        @Override
        public String toString() {
            return "Tags{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }


}
