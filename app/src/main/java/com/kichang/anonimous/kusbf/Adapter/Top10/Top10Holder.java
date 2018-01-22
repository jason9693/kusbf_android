package com.kichang.anonimous.kusbf.Adapter.Top10;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.kichang.anonimous.kusbf.R;

/**
 * Created by yang-gichang on 2017. 12. 29..
 */

public class Top10Holder extends RecyclerView.ViewHolder{
    TextView rank;
    TextView name;
    TextView univ;
    Top10Holder(View itemView) {
        super(itemView);
        rank = itemView.findViewById(R.id.rank);
        name = itemView.findViewById(R.id.name);
        univ = itemView.findViewById(R.id.univ);

    }
}
