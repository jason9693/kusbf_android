package com.kichang.anonimous.kusbf.Utils;

import android.app.Application;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import io.realm.Realm;
import io.realm.RealmConfiguration;


public class BaseApplication extends Application{
    private static String[] univList = new String[] {
            "건국대학교",
            "경기대학교",
            "경희대학교",
            "고려대학교",
            "국민대학교",
            "단국대학교",
            "덕성여자대학교",
            "동덕여자대학교",
            "명지대학교",
            "서울대학교",
            "성균관대학교",
            "성신여자대학교",
            "세종대학교",
            "숙명여자대학교",
            "숭실대학교",
            "아주대학교",
            "연세대학교",
            "용인대학교",
            "이화여자대학교",
            "인하대학교",
            "중앙대학교",
            "KAIST",
            "한국외국어대학교",
            "한국항공대학교",
            "한양대학교",
            "홍익대학교"
    };

    private static RequestQueue requestQueue;

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RealmConfiguration realmConfig = new RealmConfiguration.Builder()
                .schemaVersion(1)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfig);
        connectInitializer();
    }
    private void connectInitializer(){
        Log.d("in BaseApplication","init");
        requestQueue= Volley.newRequestQueue(this.getApplicationContext());
    }

    public static RequestQueue getRequestQueue(){
        //Log.d("in BaseApplication","init");
        return requestQueue;
    }
}
