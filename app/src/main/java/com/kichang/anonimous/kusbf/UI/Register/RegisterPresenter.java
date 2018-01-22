package com.kichang.anonimous.kusbf.UI.Register;

import android.util.Log;

import com.kichang.anonimous.kusbf.Model.Register.RegisterInfo;
import com.kichang.anonimous.kusbf.Network.RegFetcher;

public class RegisterPresenter implements RegisterContract.Presenter{
    private String tmpId;
    private RegisterContract.View view;
    private RegFetcher regFetcher;
    RegisterPresenter(RegisterContract.View view) {
        regFetcher = new RegFetcher(this);
        this.view = view;
    }

    @Override
    public void shoutSubmitted() {
        view.finishView();
    }

    @Override
    public void checkAccount(String url, String id, String passwd) {
        if(!id.equals(tmpId)) {
            tmpId = id;
            view.changeValidation(RegisterContract.View.LOADING);
            regFetcher.executeCheck(url,id, passwd);
            Log.d("onPresenter:","is fetching...");

        }
    }

    @Override
    public void submit(String url, RegisterInfo info) {
        if("".equals(info.getBirth())) return;
        regFetcher.executeSubmit(url,info.getId(),info.getPasswd(),info.getUniv());
    }

    @Override
    public void onError(int CASE) {
        switch(CASE) {
            case CASE_NOT_SUBMITTED:
                view.showNotSubmitted();
                return;

            case CASE_NOT_REGISTED:
                view.openWelihilly();
                break;

            case CASE_WRONG_ACCOUT:
                view.showInvalid();
                break;

        }
        tmpId="";
        view.changeValidation(RegisterContract.View.NOT_LOADING);
    }

    @Override
    public void valid() {
        view.changeValidation(RegisterContract.View.LOADED);
    }
}
