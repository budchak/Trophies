package com.yaroshevich.trophies.ui.preview.interfaces;

import com.yaroshevich.trophies.model.interfaces.model.Preview;
import com.yaroshevich.trophies.ui.base.BaseContract;

import java.util.List;

public interface PreviewContract {

    interface View{
        void showPreview(List<Preview> preview);
    }

    interface Presenter extends BaseContract.BasePresenter<View> {
        void onCreate();
        void onDestroy();
    }
}
