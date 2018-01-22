package com.kichang.anonimous.kusbf.Model.Info;

import com.google.gson.Gson;

/**
 * Created by yang-gichang on 2017. 12. 28..
 */

public class MySeasonRank {
    double all,sexual, agial;

    public static MySeasonRank fromJson(String res) {
        Gson gson = new Gson();
        MySeasonRank info = gson.fromJson(res,MySeasonRank.class);
        return info;
    }
    public double getAll() {
        return all;
    }

    public void setAll(double all) {
        this.all = all;
    }

    public double getAgial() {
        return agial;
    }

    public void setAgial(double agial) {
        this.agial = agial;
    }

    public double getSexual() {
        return sexual;
    }

    public void setSexual(double sexual) {
        this.sexual = sexual;
    }
}
