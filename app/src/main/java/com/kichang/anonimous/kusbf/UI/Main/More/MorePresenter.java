package com.kichang.anonimous.kusbf.UI.Main.More;

import static com.kichang.anonimous.kusbf.UI.Main.More.MoreContract.mYKC;

/**
 * Created by yang on 2017-07-01.
 */

public class MorePresenter implements MoreContract.Presenter{
    MoreContract.View v;
   public MorePresenter(MoreContract.View view){
       this.v=view;
   }

    @Override
    public void sendEmail(int name) {
        String address;
        if(name==mYKC){
            address="ykcha9@gmail.com";
        }else{
            address="gydect48@gmail.com";
        }

        v.openEmailIntent(address);
    }

    @Override
    public void doEasterEgg(int name) {
        String eName="이름: ";
        String eArea="주 서식지: ";
        String eHak="학번: ";
        String eAge="나이: ";
        String eNick="닉: ";
        if(name==mYKC){
            eName=eName.concat("양기창\n");
            eArea=eArea.concat("정보관\n");
            eHak=eHak.concat("16학번\n");
            eNick=eNick.concat("코딩하다 죽은 귀신");
            eAge=eAge.concat("22세\n");
        }else{
            eName=eName.concat("김태인\n");
            eArea=eArea.concat("\n");
            eHak=eHak.concat("14학번\n");
            eNick=eNick.concat("null");
            eAge=eAge.concat("23세\n");
        }

        v.openToast(eName+eHak+eAge+eArea+eNick);
    }
}
