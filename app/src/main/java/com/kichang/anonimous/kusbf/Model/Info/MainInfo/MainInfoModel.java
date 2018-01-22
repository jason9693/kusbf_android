package com.kichang.anonimous.kusbf.Model.Info.MainInfo;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.kichang.anonimous.kusbf.UI.Main.MainInfo.MainInfoContract;

/**
 * Created by yang-gichang on 2017. 12. 28..
 */

public class MainInfoModel implements MainInfoContract.Model {

    MainInfoContract.Presenter presenter;
    public MainInfoModel(MainInfoContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public String[] storeData(String res) {

        Gson gson = new Gson();
        JsonObject object = gson.fromJson(res,JsonObject.class);
        String[] r= new String[]{
                object.get("info").toString(),
                object.get("my_rank").toString(),
                object.get("out").toString(),
                object.get("iin").toString()
        };


        return r;
    }
}
