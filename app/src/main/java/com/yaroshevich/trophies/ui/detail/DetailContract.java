package com.yaroshevich.trophies.ui.detail;

import com.yaroshevich.trophies.model.interfaces.model.Detail;
import com.yaroshevich.trophies.ui.base.BaseContract;

public interface DetailContract {

    interface View{
        void showDetail(Detail detail);
    }

    interface presenter extends BaseContract.BasePresenter<View> {
        void onTungleButtonClick();
        void onInfoButtonClick();
    }

}
