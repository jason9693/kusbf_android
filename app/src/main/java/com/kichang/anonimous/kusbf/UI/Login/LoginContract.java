package com.kichang.anonimous.kusbf.UI.Login;

import com.kichang.anonimous.kusbf.Model.Login.AccountInfo;

/**
 * Created by yang-gichang on 2017. 6. 28..
 */

public interface LoginContract {
    interface View{
        void openRegister();
        void openSplash();
        void toastFailed();
        void toastSucceed();
    }
    interface Presenter{
        final int ERROR = 0;
        final int SUCCEED = 1;
       void loginExecute(String url, String id,String passwd);
       void onResult(int result, AccountInfo info);
    }
    interface Model{
    }
}
