package com.kichang.anonimous.kusbf.Adapter.Top10;

/**
 * Created by yang-gichang on 2017. 12. 29..
 */

public interface Top10AdapterContract {
    interface View{

    }
    interface Presenter{
        String[] getList(String res);
    }
}
