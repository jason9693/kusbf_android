package com.kichang.anonimous.kusbf.Model.Info;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/**
 * Created by yang-gichang on 2017. 12. 28..
 */

public class MyKrank {
    @SerializedName("outrank")
    int myRank;
    @SerializedName("outus")
    int upScore;
    @SerializedName("outds")
    int downScore;
    @SerializedName("outun")
    String upperName;
    @SerializedName("outusn")
    String upperUniv;
    @SerializedName("outdn")
    String lowerName;
    @SerializedName("outdsn")
    String lowerUniv;

    public static MyKrank fromJson(String res) {
        Gson gson = new Gson();
        MyKrank info = gson.fromJson(res,MyKrank.class);
        return info;
    }
    public int getMyRank() {
        return myRank;
    }

    public void setMyRank(int myRank) {
        this.myRank = myRank;
    }

    public int getUpScore() {
        return upScore;
    }

    public void setUpScore(int upScore) {
        this.upScore = upScore;
    }

    public int getDownScore() {
        return downScore;
    }

    public void setDownScore(int downScore) {
        this.downScore = downScore;
    }

    public String getUpperName() {
        return upperName;
    }

    public void setUpperName(String upperName) {
        this.upperName = upperName;
    }

    public String getUpperUniv() {
        return upperUniv;
    }

    public void setUpperUniv(String upperUniv) {
        this.upperUniv = upperUniv;
    }

    public String getLowerName() {
        return lowerName;
    }

    public void setLowerName(String lowerName) {
        this.lowerName = lowerName;
    }

    public String getLowerUniv() {
        return lowerUniv;
    }

    public void setLowerUniv(String lowerUniv) {
        this.lowerUniv = lowerUniv;
    }
}
