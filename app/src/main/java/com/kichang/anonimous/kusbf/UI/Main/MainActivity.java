package com.kichang.anonimous.kusbf.UI.Main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.kichang.anonimous.kusbf.Model.CustomComponent.MainViewPager;
import com.kichang.anonimous.kusbf.R;
import com.kichang.anonimous.kusbf.UI.Login.LoginActivity;
import com.kichang.anonimous.kusbf.UI.Main.MainInfo.MainInfoFragment;
import com.kichang.anonimous.kusbf.UI.Main.More.MoreFragment;
import com.kichang.anonimous.kusbf.UI.Main.KusbfInfo.KusbfInfoFragment;

public class MainActivity extends AppCompatActivity implements MainContract.View {
    String[] resArray;
    private TextView mTextMessage;
    private Fragment fragment;
    private MainViewPager viewPager;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_notice:
                    viewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_student_union:
                    viewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_more:
                    viewPager.setCurrentItem(2);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btnLogout;
        btnLogout = (Button) findViewById(R.id.logOut);
        MainContract.Presenter presenter = new MainPresenter(this);

        viewPager=(MainViewPager)findViewById(R.id.content);
        viewPager.setAdapter(new PAdapter(getSupportFragmentManager()));
        viewPager.setPagingEnabled(false);

       // mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        resArray = presenter.resSplit(getIntent().getStringExtra("res"));
        btnLogout.setOnClickListener(v -> presenter.logout());
    }

    @Override
    public void openSplash() {
        Log.d("onClick","restart");
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
        finish();
    }

    class PAdapter extends FragmentPagerAdapter {
        public PAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    Fragment fragment_main = new MainInfoFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("res",resArray[0]);
                    Log.d("res",resArray[0]);
                    fragment_main.setArguments(bundle);
                    return fragment_main;
                case 1:
                    Fragment fragment_kusbf = new KusbfInfoFragment();
                    Bundle bundle1 = new Bundle();
                    bundle1.putString("res",resArray[1]);
                    Log.d("res",resArray[1]);
                    fragment_kusbf.setArguments(bundle1);
                    return fragment_kusbf;
                case 2:
                    return new MoreFragment();
                default:
                    return null;
            }

        }



        @Override
        public int getCount() {
            return 3;
        }


    }
}
