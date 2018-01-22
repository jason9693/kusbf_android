package com.kichang.anonimous.kusbf.Model.Info;


import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class MySrank {
    @SerializedName("inrank")
    int myRank;
    @SerializedName("inus")
    int upScore;
    @SerializedName("inds")
    int downScore;
    @SerializedName("inun")
    String upperName;
    @SerializedName("indn")
    String lowerName;

    public int getMyRank() {
        return myRank;
    }
    public static MySrank fromJson(String res) {
        Gson gson = new Gson();
        MySrank info = gson.fromJson(res,MySrank.class);
        return info;
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

    public String getLowerName() {
        return lowerName;
    }

    public void setLowerName(String lowerName) {
        this.lowerName = lowerName;
    }
}
