package com.kichang.anonimous.kusbf.Model.Login;

import com.google.gson.Gson;
import com.kichang.anonimous.kusbf.UI.Login.LoginContract;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;


public class AccountInfo extends RealmObject implements LoginContract.Model {
    @PrimaryKey
    private String id;
    private String passwd;

    public AccountInfo(String id, String passwd) {
        this.id = id;
        this.passwd = passwd;
    }

    public AccountInfo() {
    }

    public String getId() {
        return id;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public static AccountInfo fromJson(String res) {
        Gson gson = new Gson();
        AccountInfo accountInfo = gson.fromJson(res,AccountInfo.class);
        return accountInfo;
    }


}
