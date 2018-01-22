package com.kichang.anonimous.kusbf.Model.Register;

import com.kichang.anonimous.kusbf.UI.Register.RegisterContract;

/**
 * Created by yang-gichang on 2017. 12. 28..
 */

public class RegisterInfo implements RegisterContract.Model{
    private String id,passwd,univ="kusbf",birth;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getUniv() {
        return univ;
    }

    public void setUniv(String univ) {
        this.univ = univ;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }
}
