package com.kichang.anonimous.kusbf.Model.Info;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/**
 * Created by yang-gichang on 2017. 12. 28..
 */

public class MyInfo {
    @SerializedName("my_score")
    int myScore;
    String  fboard;
    String  lboard;

    @SerializedName("my_univ")
    String  myUniv;

    @SerializedName("my_name")
    String  myName;
    @SerializedName("photo")
    String  photoLink;

    public static MyInfo fromJson(String res) {
        Gson gson = new Gson();
        MyInfo info = gson.fromJson(res,MyInfo.class);
        return info;
    }
    public int getMyScore() {
        return myScore;
    }

    public void setMyScore(int myScore) {
        this.myScore = myScore;
    }

    public String getFboard() {
        return fboard;
    }

    public void setFboard(String fboard) {
        this.fboard = fboard;
    }

    public String getLboard() {
        return lboard;
    }

    public void setLboard(String lboard) {
        this.lboard = lboard;
    }

    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }

    public String getPhotoLink() {
        return photoLink;
    }

    public void setPhotoLink(String photoLink) {
        this.photoLink = photoLink;
    }

    public String getMyUniv() {
        return myUniv;
    }

    public void setMyUniv(String myUniv) {
        this.myUniv = myUniv;
    }
}
