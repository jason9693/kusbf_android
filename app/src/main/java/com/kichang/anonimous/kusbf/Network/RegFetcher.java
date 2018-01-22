package com.kichang.anonimous.kusbf.Network;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.kichang.anonimous.kusbf.UI.Register.RegisterContract;
import com.kichang.anonimous.kusbf.Utils.BaseApplication;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yang-gichang on 2017. 12. 31..
 */

public class RegFetcher {
    RegisterContract.Presenter presenter;

    public RegFetcher(RegisterContract.Presenter presenter) {
        this.presenter = presenter;
    }

    public void executeSubmit(String url,String id, String passwd, String univ) {

        RequestQueue queue= BaseApplication.getRequestQueue();
        StringRequest request=
                new StringRequest(Request.Method.POST,
                        url,
                        response -> {
                            Gson gson = new Gson();
                            JsonObject object = gson.fromJson(response, JsonObject.class);
                            if(object.get("result").equals("0"))
                                presenter.onError(RegisterContract.Presenter.CASE_NOT_SUBMITTED);
                            else {
                                presenter.shoutSubmitted();

                                Log.d("submit response", object.toString());
                            }
                        },
                        error -> {
                            presenter.onError(presenter.CASE_NOT_SUBMITTED);
                            Log.e("res error","crashed");
                        }

                ) {
                    @Override
                    public Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("id",id);
                        params.put("passwd",passwd);
                        params.put("univ",univ);
                        Log.d("onSubmitFetcher",params.toString());
                        return params;
                    }

                    @Override
                    public String getBodyContentType() {
                        return "application/x-www-form-urlencoded; charset=utf-8";
                    }
                };
        Log.d("req1",request.toString());
        request.setRetryPolicy(
                new DefaultRetryPolicy(10000,0,1.0f)
        );
        queue.add(request);
    }

    public void executeCheck(String url,String id, String passwd) {

        RequestQueue queue= BaseApplication.getRequestQueue();
        StringRequest request=
                new StringRequest(Request.Method.POST,
                        url,
                        response -> {
                            Gson gson = new Gson();
                            JsonObject obj = gson.fromJson(response, JsonObject.class);
                            String result = obj.get("result").toString();
                            if ("-1".equals(result))
                                presenter.onError(presenter.CASE_WRONG_ACCOUT);
                            else if("0".equals(result))
                                presenter.onError(presenter.CASE_NOT_REGISTED);
                            else if("1".equals(result))
                                presenter.valid();
                            Log.d("regCheckResult:",obj.get("result").toString());


                        },
                        error -> {
                            presenter.onError(presenter.CASE_NOT_REGISTED);
                            Log.e("res error","crashed");
                        }
                ) {
                    @Override
                    public Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("id",id);
                        params.put("passwd",passwd);
                        Log.d("id, passwd:",id + " " + passwd);
                        return params;
                    }

                    @Override
                    public String getBodyContentType() {
                        return "application/x-www-form-urlencoded";
                    }
                };
        Log.d("req2",request.toString());
        request.setRetryPolicy(
                new DefaultRetryPolicy(10000,0,1.0f)
        );
        queue.add(request);
    }
}
