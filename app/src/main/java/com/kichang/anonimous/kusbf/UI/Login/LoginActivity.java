package com.kichang.anonimous.kusbf.UI.Login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kichang.anonimous.kusbf.R;
import com.kichang.anonimous.kusbf.UI.Register.RegisterActivity;
import com.kichang.anonimous.kusbf.UI.Splash.SplashActivity;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {
    LoginContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        presenter = new LoginPresenter(this);
        Button regist = (Button)findViewById(R.id.buttonReg);
        Button login = (Button) findViewById(R.id.buttonLogin);
        EditText id = (EditText) findViewById(R.id.id);
        EditText passwd = (EditText) findViewById(R.id.passwd);
        final String[] tmpId = {""};
        final String[] tmpPwd = { "" };
        regist.setOnClickListener(view -> openRegister());
        login.setOnClickListener(view ->
                {
                    if(!id.getText().toString().equals(tmpId[0])
                            || !passwd.getText().toString().equals(tmpPwd[0]) ) {
                        presenter.loginExecute(
                                getString(R.string.base_url) + getString(R.string.logn_valid_check),
                                id.getText().toString(),
                                passwd.getText().toString()
                        );
                        tmpId[0] = id.getText().toString();
                        tmpPwd[0] = passwd.getText().toString();
                    }
                }
        );

    }

    @Override
    public void openRegister() {
        Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
        startActivity(intent);
    }

    @Override
    public void openSplash() {
        Intent intent = new Intent(getApplicationContext(), SplashActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void toastFailed() {
        Toast.makeText(getApplicationContext(),
                "id,비밀번호를 다시 입력하시거나\n등록후 사용하세요.",Toast.LENGTH_LONG).show();
    }

    @Override
    public void toastSucceed() {
        Toast.makeText(getApplicationContext(),
                "로그인 성공",Toast.LENGTH_LONG).show();
    }
}
