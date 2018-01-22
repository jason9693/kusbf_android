package com.kichang.anonimous.kusbf.Adapter.Top10;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.kichang.anonimous.kusbf.R;

public class Top10Adapter extends RecyclerView.Adapter<Top10Holder>
    implements Top10AdapterContract.View, Top10AdapterContract.Presenter{
    private String[] nameList;
    private String[] univList;
    public Top10Adapter(String res) {
        getList(res);
    }

    @Override
    public Top10Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_kusbf_personal_card, parent,false);

        Top10Holder holder = new Top10Holder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(Top10Holder holder, int position) {
        holder.rank.setText(String.valueOf(position+1)+"위");
        holder.name.setText(nameList[position]);
        holder.univ.setText(univList[position]);
    }

    @Override
    public int getItemCount() {
        return nameList.length;
    }

    @Override
    public String[] getList(String res) {
        Gson gson = new Gson();
        JsonObject Res = gson.fromJson(res, JsonObject.class);
        String names = Res.get("names").toString();
        String univs = Res.get("froms").toString();
        nameList=gson.fromJson(names,String[].class);
        univList=gson.fromJson(univs,String[].class);
        return new String[0];
    }
}
