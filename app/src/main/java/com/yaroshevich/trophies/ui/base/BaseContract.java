package com.yaroshevich.trophies.ui.base;

public interface BaseContract {

    interface BasePresenter<View>{
        void attach(View view);
        void detach();
    }
}
