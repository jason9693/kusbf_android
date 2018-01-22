package com.kichang.anonimous.kusbf.UI.Main.More;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kichang.anonimous.kusbf.R;

import static android.content.Intent.ACTION_SENDTO;

public class MoreFragment extends Fragment implements MoreContract.View{
    ImageView mailTIK1;
    ImageView mailTIK2;
    ImageView mailYKC;
    TextView nameTIK;
    TextView nameYKC;
    MoreContract.Presenter mPresenter;
    public MoreFragment() {
        // Required empty public constructor
    }

    public static MoreFragment newInstance(String param1, String param2) {
        MoreFragment fragment = new MoreFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mPresenter=new MorePresenter(this);

        View v=inflater.inflate(R.layout.fragment_more, container, false);


        return v;
    }


    @Override
    public void openToast(String message) {
        Toast.makeText(getActivity().getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void openEmailIntent(String address) {
        Intent intent=new Intent(ACTION_SENDTO, Uri.parse("mailto:" + address));
        startActivity(intent);
    }
}
