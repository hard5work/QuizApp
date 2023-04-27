package com.anish.app.quizapp.data.model;


import com.google.gson.annotations.SerializedName;

public class Tags {
    private String name;

    @SerializedName("name")
    public String getName() { return name; }
    @SerializedName("name")
    public void setName(String value) { this.name = value; }

    @Override
    public String toString() {
        return "Tags{" +
                "name='" + name + '\'' +
                '}';
    }
}