package com.kichang.anonimous.kusbf.UI.Main;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.kichang.anonimous.kusbf.Model.Login.AccountInfo;

import io.realm.Realm;

public class MainPresenter implements MainContract.Presenter {
    MainContract.View view;
    private Realm mRealm=Realm.getDefaultInstance();
    MainPresenter(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void logout() {
        mRealm.executeTransactionAsync(realm -> {
            AccountInfo info = realm.where(AccountInfo.class).findFirst();
            if(info.isValid()) {
                Log.d("login data:",info.getId());
                info.deleteFromRealm();
            }
        }, () -> view.openSplash(),
                Throwable::printStackTrace);
    }

    @Override
    public String[] resSplit(String res) {
        String[] resArray = new String[3];
        Gson gson = new Gson();
        JsonObject obj = gson.fromJson(res,JsonObject.class);
        resArray[0] = obj.get("main_info").toString();
        resArray[1] = obj.get("kusbf").toString();


        return resArray;
    }
}
