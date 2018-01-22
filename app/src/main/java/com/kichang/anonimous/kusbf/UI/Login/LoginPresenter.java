package com.kichang.anonimous.kusbf.UI.Login;
import com.kichang.anonimous.kusbf.Model.Login.AccountInfo;
import com.kichang.anonimous.kusbf.Network.LoginFetcher;

import io.realm.Realm;

public class LoginPresenter implements LoginContract.Presenter{
    private LoginContract.View view;
    private Realm mRealm = Realm.getDefaultInstance();
    private boolean flagFooter=false;

    LoginPresenter(LoginContract.View view){
        this.view=view;
    }

    @Override
    public void loginExecute(String url, String id, String passwd) {
        LoginFetcher fetcher = new LoginFetcher(this);
        fetcher.execute(url,id,passwd);
    }

    @Override
    public void onResult(int result,AccountInfo info) {
        switch(result) {
            case ERROR:
                view.toastFailed();
                break;
            case SUCCEED:
                mRealm.executeTransaction(realm -> mRealm.copyToRealmOrUpdate(info));
                view.toastSucceed();
                view.openSplash();
                break;
        }
    }


}
