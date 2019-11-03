package com.yaroshevich.trophies.ui.trophyInfo.interfaces;

import com.yaroshevich.trophies.ui.base.BaseContract;

public interface TrophyInfoContract  {

    interface View{

    }

    interface Presenter extends BaseContract.BasePresenter<View> {
        void onBind(int id, TrophyInfoContent content);
        int getItemCount();
    }
}
