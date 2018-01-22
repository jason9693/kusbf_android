package com.kichang.anonimous.kusbf.UI.Main.MainInfo;

import com.kichang.anonimous.kusbf.Model.Info.MyInfo;
import com.kichang.anonimous.kusbf.Model.Info.MyKrank;
import com.kichang.anonimous.kusbf.Model.Info.MySeasonRank;
import com.kichang.anonimous.kusbf.Model.Info.MySrank;

/**
 * Created by yang-gichang on 2017. 6. 27..
 */

public interface MainInfoContract {
    static int MY_INFO=0;
    static int MY_RANK=1;
    static int OUT=2;
    static int IN=3;
    interface View{
        void setPresenter();
        void updateMyInfo(MyInfo info);
        void updateMyKrank(MyKrank rank);
        void updateMySeasonRank(MySeasonRank rank);
        void updateMySrank(MySrank rank);
    }
    interface Presenter{

        void updateResponse(String res);
    }
    interface Model {
        String[] storeData(String res);
    }
}
