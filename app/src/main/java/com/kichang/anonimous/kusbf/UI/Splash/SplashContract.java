package com.kichang.anonimous.kusbf.UI.Splash;

public interface SplashContract{

    int REQUEST_CODE = 1;

    interface View{
        void updateCondition(String res);
        void showLoading();
        void openLogin();
        void showError();
        //Activity getContext();
        //void showPermissionNeed();
        //void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults);
    }
    interface Presenter{

        void seizeTime();
        void loginCheck(String url);
        void getResponse(String res);
        void onError();
        //void checkPermission();
    }
}
