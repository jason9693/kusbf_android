package com.kichang.anonimous.kusbf.UI.Main.KusbfInfo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kichang.anonimous.kusbf.Adapter.Top10.Top10Adapter;
import com.kichang.anonimous.kusbf.Adapter.UnivSort.UnivSortAdapter;
import com.kichang.anonimous.kusbf.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * <p>
 * to handle interaction events.
 * Use the {@link KusbfInfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class KusbfInfoFragment extends Fragment implements KusbfInfoContract.View{
    View v;
    String res;
    KusbfInfoContract.Presenter presenter;
    public KusbfInfoFragment() {

    }

    public static KusbfInfoFragment newInstance(String param1, String param2) {
        KusbfInfoFragment fragment = new KusbfInfoFragment();
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

        presenter = new KusbfInfoPresenter(this);
        res = getArguments().getString("res");
        v = inflater.inflate(R.layout.fragment_kusbf_info, container, false);
        RecyclerView recyclerView =
                bindRViewInstance(R.id.recyclerview_per, v
                        ,new Top10Adapter(presenter.refineKusbfJson(res,"top10")));
        RecyclerView recyclerView_univ =
                bindRViewInstance(R.id.recyclerview_univ, v
                        ,new UnivSortAdapter(presenter.refineKusbfJson(res,"univ_rank")));
        updateKusbfScore(presenter.refineKusbfJson(res,"total_score"));
        return v;
    }

    private RecyclerView bindRViewInstance(int id, View v,RecyclerView.Adapter adapter) {
        RecyclerView recyclerView = (RecyclerView) v.findViewById(id);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager manager =
                new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(manager);

        return recyclerView;
    }


    @Override
    public void updateKusbfScore(String res) {
        TextView totalKusbf = v.findViewById(R.id.kusbfScore);
        totalKusbf.setText(res);
    }
}
