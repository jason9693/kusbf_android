package com.kichang.anonimous.kusbf.Network;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.kichang.anonimous.kusbf.Model.Login.AccountInfo;
import com.kichang.anonimous.kusbf.UI.Login.LoginContract;
import com.kichang.anonimous.kusbf.Utils.BaseApplication;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yang-gichang on 2018. 1. 1..
 */

public class LoginFetcher {

    private LoginContract.Presenter presenter;
    public LoginFetcher(LoginContract.Presenter presenter) {
        this.presenter = presenter;
    }

    public void execute(String url, String id, String passwd) {

        AccountInfo info = new AccountInfo(id,passwd);
        RequestQueue queue= BaseApplication.getRequestQueue();
        StringRequest request=
                new StringRequest(Request.Method.POST,
                        url,
                        response -> {
                            Gson gson = new Gson();
                            JsonObject obj = gson.fromJson(response, JsonObject.class);
                            if(obj.get("result").toString().equals("1"))
                                presenter.onResult(presenter.SUCCEED, info);
                            else presenter.onResult(presenter.ERROR, info) ;
                        },
                        error -> {
                            presenter.onResult(presenter.ERROR,info);
                            Log.e("res error","crashed");
                        }
                ) {
                    @Override
                    public Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("id",id);
                        params.put("passwd",passwd);
                        return params;
                    }

                    @Override
                    public String getBodyContentType() {
                        return "application/x-www-form-urlencoded; charset=utf-8";
                    }
                };
        Log.d("req2",request.toString());
        request.setRetryPolicy(
                new DefaultRetryPolicy(10000,0,1.0f)
        );
        queue.add(request);
    }
}
