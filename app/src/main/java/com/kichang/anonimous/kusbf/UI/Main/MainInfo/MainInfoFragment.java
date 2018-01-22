package com.kichang.anonimous.kusbf.UI.Main.MainInfo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.kichang.anonimous.kusbf.Model.Info.MyInfo;
import com.kichang.anonimous.kusbf.Model.Info.MyKrank;
import com.kichang.anonimous.kusbf.Model.Info.MySeasonRank;
import com.kichang.anonimous.kusbf.Model.Info.MySrank;
import com.kichang.anonimous.kusbf.R;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * create an instance of this fragment.
 */
public class MainInfoFragment extends Fragment implements MainInfoContract.View{
    MainInfoContract.View view=this;
    MainInfoContract.Presenter presenter;
    View v;
    String res;
    public MainInfoFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("fragment response","nbmf");

        view=this;
        presenter=new MainInfoPresenter(this);
        // Inflate the layout for this fragment
        v=inflater.inflate(R.layout.fragment_main_info, container, false);

        res = getArguments().getString("res");
        presenter.updateResponse(res);

        return v;
    }

    @Override
    public void setPresenter() {
        this.presenter=new MainInfoPresenter(this);
    }

    @Override
    public void updateMyInfo(MyInfo info) {
        CircleImageView imageView = v.findViewById(R.id.profileImage);
        Glide.with(v).load(info.getPhotoLink()).into(imageView);
        TextView myname = v.findViewById(R.id.name);
        myname.setText(info.getMyName());
        TextView myuniv = v.findViewById(R.id.univ);
        myuniv.setText(info.getMyUniv());
        TextView lboard = v.findViewById(R.id.lastDate);
        lboard.setText(info.getLboard());
        TextView fboard = v.findViewById(R.id.firstDate);
        fboard.setText(info.getFboard());
        TextView score = v.findViewById(R.id.totalScore);
        score.setText(String.valueOf(info.getMyScore())+"점");
    }

    @Override
    public void updateMyKrank(MyKrank rank) {
        TextView krank = v.findViewById(R.id.krank);
        krank.setText(String.valueOf(rank.getMyRank()));
        TextView lowerName = v.findViewById(R.id.lowerKName);
        lowerName.setText(rank.getLowerName());
        TextView upperName = v.findViewById(R.id.upperKName);
        upperName.setText(rank.getUpperName());
        TextView upperUniv = v.findViewById(R.id.upper_univ);
        upperUniv.setText(rank.getUpperUniv());
        TextView lowerUniv = v.findViewById(R.id.lower_univ);
        lowerUniv.setText(rank.getLowerUniv());
        TextView lowerScore = v.findViewById(R.id.lower_kusbf_score);
        lowerScore.setText("-"+rank.getDownScore());
        TextView upperScore = v.findViewById(R.id.upper_kusbf_score);
        upperScore.setText("+"+rank.getUpScore());

    }

    @Override
    public void updateMySeasonRank(MySeasonRank rank) {
        TextView whole = v.findViewById(R.id.wholeRank);
        whole.setText(String.valueOf(rank.getAll())+"%");
        TextView sexual = v.findViewById(R.id.sexualRank);
        sexual.setText(String.valueOf(rank.getSexual())+"%");
        TextView byAge = v.findViewById(R.id.agialRank);
        byAge.setText(String.valueOf(rank.getAgial())+"%");
    }

    @Override
    public void updateMySrank(MySrank rank) {
        TextView srank = v.findViewById(R.id.srank);
        srank.setText(String.valueOf(rank.getMyRank()));
        TextView lowerName = v.findViewById(R.id.srank_lower_name);
        lowerName.setText(rank.getLowerName());
        TextView upperName = v.findViewById(R.id.srank_upper_name);
        upperName.setText(rank.getUpperName());
        TextView upperScore = v.findViewById(R.id.upper_univ_score);
        upperScore.setText("+"+rank.getUpScore());
        TextView lowerScore = v.findViewById(R.id.lower_univ_score);
        lowerScore.setText("-"+rank.getDownScore());
    }




}
