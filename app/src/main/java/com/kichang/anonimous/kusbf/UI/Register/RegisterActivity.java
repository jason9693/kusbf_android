package com.kichang.anonimous.kusbf.UI.Register;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.kichang.anonimous.kusbf.Model.Register.RegisterInfo;
import com.kichang.anonimous.kusbf.R;

public class RegisterActivity extends AppCompatActivity implements RegisterContract.View{
    TextView validText;
    EditText id, passwd, birth;
    Button valid, submit;
    RegisterInfo info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        RegisterContract.Presenter presenter = new RegisterPresenter(this);
        id = findViewById(R.id.id);
        passwd = findViewById(R.id.passwd);
        valid = findViewById(R.id.validation);
        validText = (TextView)findViewById(R.id.validiationTxt);
        submit = (Button) findViewById(R.id.submit);
        birth = findViewById(R.id.birth);
        info = new RegisterInfo();
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        valid.setOnClickListener(
                v -> presenter.checkAccount(
                        getString(R.string.base_url) + getString(R.string.register_login_check),
                        id.getText().toString(),
                        passwd.getText().toString()
                )
        );

        submit.setOnClickListener(v -> {
            info.setId(id.getText().toString());
            info.setPasswd(passwd.getText().toString());
            info.setBirth(birth.getText().toString());
            Toast.makeText(this,"등록중...\n잠시만 기다려주십시오.",Toast.LENGTH_SHORT).show();
            presenter.submit(
                    getString(R.string.base_url)+getString(R.string.register_submit)
                    ,info
            );
        });

        ArrayAdapter<CharSequence> univAdapter =
                ArrayAdapter.createFromResource(
                        this,
                        R.array.univ_array,
                        R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(univAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                info.setUniv(adapterView.getItemAtPosition(i).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @SuppressLint("ResourceAsColor")
    @Override
    public void changeValidation(int loadFlag) {
        switch(loadFlag) {
            case NOT_LOADING:
                validText.setText(R.string.register_non_valid);
                validText.setTextColor(getColor(R.color.colorNoneValid));
                break;
            case LOADING:
                validText.setText(R.string.register_validating);
                validText.setTextColor(getColor(R.color.colorvaliding));
                break;
            case LOADED:
                validText.setText(R.string.register_valid);
                validText.setTextColor(getColor(R.color.colorValid));
                submit.setVisibility(View.VISIBLE);
                break;
        }
    }

    @Override
    public void setSubmitVisible(boolean isVisible) {
        if (isVisible) submit.setVisibility(View.VISIBLE);
        else submit.setVisibility(View.GONE);
    }

    @Override
    public void showNotSubmitted() {
        Toast.makeText(this,"등록실패, 알수없는 오류",Toast.LENGTH_LONG).show();
    }

    @Override
    public void finishView() {
        Toast.makeText(RegisterActivity.this, "등록 완료",Toast.LENGTH_LONG).show();
        finish();
    }

    @Override
    public void openWelihilly() {
        Intent intent =
                new Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://www.wellihillipark.com/sub3/member/login.html")
                );
        Toast.makeText(
                this,
                "홈페이지에서 시즌권 연동을 먼저 해 주십시오.\n" +
                        " 방법 : 로그인 -> 시즌권 정보조회 -> 17/18시즌 클릭",
                Toast.LENGTH_LONG
        ).show();
        startActivity(intent);
    }

    @Override
    public void showInvalid() {
        Toast.makeText(this, "올바른 계정 정보를 입력하십시오." ,Toast.LENGTH_LONG).show();
    }
}
