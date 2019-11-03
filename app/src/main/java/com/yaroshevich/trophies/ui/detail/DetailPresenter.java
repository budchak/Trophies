package com.yaroshevich.trophies.ui.detail;

import com.yaroshevich.trophies.Repository.Repository;

public class DetailPresenter implements DetailContract.presenter {

    private DetailContract.View view;
    private Repository repository;




    @Override
    public void onTungleButtonClick() {

    }

    @Override
    public void onInfoButtonClick() {

    }

    @Override
    public void attach(DetailContract.View view) {
        this.view = view;
    }

    @Override
    public void detach() {
        view = null;
    }
}
