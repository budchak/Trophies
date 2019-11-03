package com.yaroshevich.trophies.ui.emptyDetail;

import com.yaroshevich.trophies.navigation.AppNavigator;

public class EmptyDetailPresenter implements EmptyDetailContract.Presenter {

    EmptyDetailContract.View view;
    private int curentTrophyId;

    public EmptyDetailPresenter(int currentTrophyId) {
        this.curentTrophyId = currentTrophyId;
    }

    @Override
    public void onFloatingButtonCLick() {
        AppNavigator.getInstance(null).navigateToNewTrophyScreen(curentTrophyId);
    }

    @Override
    public void onInfoClick() {
        AppNavigator.getInstance(null).navigateToFishInfoScreen();
    }

    @Override
    public void attach(EmptyDetailContract.View view) {
        this.view = view;
    }

    @Override
    public void detach() {
        view = null;
    }
}
