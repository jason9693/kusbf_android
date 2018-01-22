package com.kichang.anonimous.kusbf.UI.Register;

import com.kichang.anonimous.kusbf.Model.Register.RegisterInfo;

/**
 * Created by yang-gichang on 2017. 12. 27..
 */

public interface RegisterContract {

    interface View{
        int NOT_LOADING = 0;
        int LOADING = 1;
        int LOADED = 2;
        void changeValidation(int loadFlag);
        void setSubmitVisible(boolean isVisible);
        void showNotSubmitted();
        void finishView();
        void openWelihilly();
        void showInvalid();
    }
    interface Presenter{
        final int CASE_NOT_REGISTED = 0;
        final int CASE_WRONG_ACCOUT = -1;
        final int CASE_NOT_SUBMITTED = -2;
        void shoutSubmitted();
        void checkAccount(String url, String id,String passwd);
        void submit(String url, RegisterInfo info);
        void onError(int CASE);
        void valid();


    }
    interface Model{

    }
}
