package com.kichang.anonimous.kusbf.UI.Main.More;

/**
 * Created by yang on 2017-06-30.
 */

public interface MoreContract {
    int mYKC=0;
    int mTIK=1;
    interface View{
        void openToast(String message);
        void openEmailIntent(String address);
    }
    interface Presenter{
        void sendEmail(int name);
        void doEasterEgg(int name);
    }
}
