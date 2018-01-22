package com.kichang.anonimous.kusbf.UI.Splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.kichang.anonimous.kusbf.R;
import com.kichang.anonimous.kusbf.UI.Login.LoginActivity;
import com.kichang.anonimous.kusbf.UI.Main.MainActivity;

import static android.view.View.VISIBLE;

public class SplashActivity extends AppCompatActivity implements SplashContract.View{
    SplashContract.Presenter pre;
    TextView loadingtext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        pre= new SplashPresenter(this);
        loadingtext = findViewById(R.id.loadFeedback);
        //pre.checkPermission();

        pre.loginCheck(getString(R.string.base_url)
                +getString(R.string.splash_get_info));
    }

    @Override
    public void updateCondition(String res) {
        Intent StartIntent=new Intent(this, MainActivity.class);
        StartIntent.putExtra("res",res);
        startActivity(StartIntent);
        finish();

    }

    @Override
    public void showLoading() {
        Toast.makeText(this, "등록후 최초 접속시\n약 10-20초정도 소요됩니다.",Toast.LENGTH_SHORT)
                .show();
        loadingtext.setVisibility(VISIBLE);
    }

    @Override
    public void openLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void showError() {
        Toast.makeText(this,"접속 오류가 발생했습니다.",Toast.LENGTH_LONG).show();
    }

   /* @Override
    public Activity getContext() {
        return this;
    }

    @Override
    public void showPermissionNeed() {
        Toast.makeText(this,"권한을 설정해 주세요.",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String permissions[],
                                           @NonNull int[] grantResults) {
        switch (requestCode) {
            case SplashContract.REQUEST_CODE: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED
                        && grantResults[1] == PackageManager.PERMISSION_GRANTED
                        && grantResults[2] == PackageManager.PERMISSION_GRANTED
                        ) {
                    pre.loginCheck(getString(R.string.base_url)
                            +getString(R.string.splash_get_info));
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                } else {
                    finish();
                }
            }

        }
    }*/
}
