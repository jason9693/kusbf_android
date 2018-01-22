package com.kichang.anonimous.kusbf.Adapter.UnivSort;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.kichang.anonimous.kusbf.R;

/**
 * Created by yang-gichang on 2017. 12. 29..
 */

public class UnivSortHolder extends RecyclerView.ViewHolder{
    TextView rank;
    TextView univ;
    TextView score;


    public UnivSortHolder(View itemView) {
        super(itemView);
        rank = itemView.findViewById(R.id.rank);
        univ = itemView.findViewById(R.id.univ);
        score = itemView.findViewById(R.id.score);
    }
}
