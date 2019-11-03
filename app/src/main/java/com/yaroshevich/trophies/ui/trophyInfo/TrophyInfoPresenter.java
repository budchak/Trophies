package com.yaroshevich.trophies.ui.trophyInfo;

import com.yaroshevich.trophies.ui.trophyInfo.interfaces.TrophyInfoContent;
import com.yaroshevich.trophies.ui.trophyInfo.interfaces.TrophyInfoContract;

public class TrophyInfoPresenter implements TrophyInfoContract.Presenter {

    TrophyInfoContract.View view;



    @Override
    public void onBind(int id, TrophyInfoContent content) {
        content.setInfo("images/белоглазка.jpg");
        content.setTitle("1/1");
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    @Override
    public void attach(TrophyInfoContract.View view) {
        this.view = view;
    }

    @Override
    public void detach() {
        view = null;
    }
}
