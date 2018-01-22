package com.kichang.anonimous.kusbf.UI.Main.KusbfInfo;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * Created by yang-gichang on 2017. 12. 29..
 */

public class KusbfInfoPresenter implements KusbfInfoContract.Presenter {
    KusbfInfoContract.View v;

    public KusbfInfoPresenter(KusbfInfoContract.View v) {
        this.v = v;
    }

    @Override
    public String refineKusbfJson(String res,String key) {
        Gson gson = new Gson();
        JsonObject obj = gson.fromJson(res,JsonObject.class);
        return obj.get(key).toString();
    }
}
