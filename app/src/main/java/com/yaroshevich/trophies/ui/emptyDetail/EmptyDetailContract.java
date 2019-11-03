package com.yaroshevich.trophies.ui.emptyDetail;

import com.yaroshevich.trophies.ui.base.BaseContract;

public interface EmptyDetailContract {

    interface View{

    }

    interface Presenter extends BaseContract.BasePresenter<View>{
        void onFloatingButtonCLick();
        void onInfoClick();
    }
}
