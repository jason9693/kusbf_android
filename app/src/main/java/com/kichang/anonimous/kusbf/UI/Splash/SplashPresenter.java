package com.kichang.anonimous.kusbf.UI.Splash;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;

import com.kichang.anonimous.kusbf.Model.Login.AccountInfo;
import com.kichang.anonimous.kusbf.Network.DataFetcher;

import io.realm.Realm;



public class SplashPresenter implements SplashContract.Presenter{
    private DataFetcher fetcher;
    private SplashContract.View view;
    private SplashContract.Presenter presenter = this;
    private Handler handler;
    private Realm mRealm = Realm.getDefaultInstance();
    SplashPresenter(SplashContract.View view){
        this.view=view;
    }

    class time extends Thread{
        @Override
        public void run() {
            super.run();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {

            }
            handler.sendEmptyMessage(0);
        }
    }


    @Override
    public void seizeTime() {
        time t=new time();
        t.start();
    }

    @SuppressLint("HandlerLeak")
    @Override
    public void loginCheck(String url) {
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                if(!mRealm.isEmpty()) {
                    view.showLoading();
                    AccountInfo info =  mRealm.where(AccountInfo.class).findFirst();
                    fetcher = new DataFetcher(url,presenter);
                    fetcher.execute(info.getId(),info.getPasswd());
                } else {
                    view.openLogin();
                }
            }


        };

        seizeTime();
    }

    @Override
    public void getResponse(String res) {
        view.updateCondition(res);
    }

    @Override
    public void onError() {
        view.showError();
    }

    /*@Override
    public void checkPermission() {
        Activity context = view.getContext();
        if (ContextCompat.checkSelfPermission(context,
                Manifest.permission.)
                != PackageManager.PERMISSION_GRANTED) {
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(context,
                    Manifest.permission.READ_CONTACTS)) {

                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(context,
                        new String[]{
                                Manifest.permission.READ_EXTERNAL_STORAGE,
                                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                Manifest.permission.INTERNET,
                        },
                        SplashContract.REQUEST_CODE
                );

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }
    }*/


}
