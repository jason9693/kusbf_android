package com.kichang.anonimous.kusbf.UI.Main.MainInfo;

import com.kichang.anonimous.kusbf.Model.Info.MainInfo.MainInfoModel;
import com.kichang.anonimous.kusbf.Model.Info.MyInfo;
import com.kichang.anonimous.kusbf.Model.Info.MyKrank;
import com.kichang.anonimous.kusbf.Model.Info.MySeasonRank;
import com.kichang.anonimous.kusbf.Model.Info.MySrank;

import static com.kichang.anonimous.kusbf.UI.Main.MainInfo.MainInfoContract.IN;
import static com.kichang.anonimous.kusbf.UI.Main.MainInfo.MainInfoContract.MY_INFO;
import static com.kichang.anonimous.kusbf.UI.Main.MainInfo.MainInfoContract.MY_RANK;
import static com.kichang.anonimous.kusbf.UI.Main.MainInfo.MainInfoContract.OUT;

/**
 * Created by yang-gichang on 2017. 6. 28..
 */

public class MainInfoPresenter implements MainInfoContract.Presenter{
    MainInfoContract.View v;
    MyInfo myInfo;
    MyKrank krank;
    MySeasonRank seasonRank;
    MySrank srank;
    public MainInfoPresenter(MainInfoContract.View v){
        this.v=v;

    }
    @Override
    public void updateResponse(String res) {
        initLoad(res);
    }


    public void initLoad(String res) {
        MainInfoContract.Model model = new MainInfoModel(this);
        String[] responses = model.storeData(res);

        myInfo = MyInfo.fromJson(responses[MY_INFO]);
        v.updateMyInfo(myInfo);
        krank = MyKrank.fromJson(responses[OUT]);
        v.updateMyKrank(krank);
        srank = MySrank.fromJson(responses[IN]);
        v.updateMySrank(srank);
        seasonRank = MySeasonRank.fromJson(responses[MY_RANK]);
        v.updateMySeasonRank(seasonRank);
        //fetcher.initFetch(position,v);
    }


}
