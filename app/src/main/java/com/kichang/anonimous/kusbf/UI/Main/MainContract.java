package com.kichang.anonimous.kusbf.UI.Main;

/**
 * Created by yang-gichang on 2017. 6. 27..
 */

public interface MainContract {
    interface View{
        void openSplash();
    }
    interface Presenter{
        void logout();
        String[] resSplit(String res);
    }
}
