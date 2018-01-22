package com.kichang.anonimous.kusbf.UI.Main.KusbfInfo;

/**
 * Created by yang-gichang on 2017. 6. 30..
 */

public interface KusbfInfoContract {
    interface View{
        void updateKusbfScore(String res);
    }
    interface Presenter{
        String refineKusbfJson(String res, String key);
    }
}
