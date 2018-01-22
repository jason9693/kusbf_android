package com.kichang.anonimous.kusbf.Adapter.UnivSort;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.kichang.anonimous.kusbf.R;

public class UnivSortAdapter extends RecyclerView.Adapter<UnivSortHolder>
        implements UnivSortAdapterContract.Presenter, UnivSortAdapterContract.View {
    String[] univs;
    String[] scores;

    public UnivSortAdapter(String res) {
        getList(res);
    }

    @Override
    public String[] getList(String res) {
        Gson gson = new Gson();
        JsonObject obj = gson.fromJson(res, JsonObject.class);
        univs = gson.fromJson(
                obj.get("names").toString(),String[].class
        );
        scores = gson.fromJson(
                obj.get("scores").toString(),String[].class
        );
        return new String[0];
    }

    @Override
    public UnivSortHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_kusbf_univ_card,parent,false);
        UnivSortHolder holder = new UnivSortHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(UnivSortHolder holder, int position) {
        holder.rank.setText(String.valueOf(position+1)+"위");
        holder.score.setText(scores[position]+"점");
        holder.univ.setText(univs[position]);
    }

    @Override
    public int getItemCount() {
        return univs.length;
    }
}
