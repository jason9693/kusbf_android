package com.kichang.anonimous.kusbf.Network;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.kichang.anonimous.kusbf.UI.Splash.SplashContract;
import com.kichang.anonimous.kusbf.Utils.BaseApplication;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yang-gichang on 2017. 12. 30..
 */

public class DataFetcher {
    String url;
    SplashContract.Presenter presenter;

    public DataFetcher(String url, SplashContract.Presenter presenter) {
        this.url = url;
        this.presenter = presenter;
    }

    public void execute(String id, String passwd) {

            RequestQueue queue= BaseApplication.getRequestQueue();
            StringRequest request=
                    new StringRequest(Request.Method.POST,
                            url,
                            response -> presenter.getResponse(response),
                            error -> {
                                presenter.onError();
                                Log.e("res error",error.toString());
                            }
                    ) {
                        @Override
                        public Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("id",id);
                        params.put("passwd",passwd);
                        Log.d("id, passwd:",id + " " + passwd);
                        Log.d("req body:",params.toString());
                        return params;
                        }

                        @Override
                        public String getBodyContentType() {
                            return "application/x-www-form-urlencoded; charset=utf-8";
                        }

                    };
            Log.d("req1",request.toString());
            request.setRetryPolicy(new DefaultRetryPolicy(
                    30000,
                    0,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
            queue.add(request);
    }
}
