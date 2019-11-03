package com.yaroshevich.trophies.ui.newTrophy.interfaces;

import android.net.Uri;

import com.yaroshevich.trophies.model.interfaces.model.Trophy;
import com.yaroshevich.trophies.ui.base.BaseContract;
import com.yaroshevich.trophies.ui.newTrophy.NewTrophyCLickEvent;

public interface NewTrophyContract {

    interface View{

        void getImage();

        void showMessage(String message);

        void setTitleImage(Uri titleImage);

        void getTitleImage();

        void update(Trophy trophy);
    }

    interface Presenter extends BaseContract.BasePresenter<View> {

        void onTitleImageTake(Uri uri);

        void onClickEvent(NewTrophyCLickEvent cLickEvent);

        void onTitleViewClick();

        void loadTrophy(int id);

        void onImageTake(Uri uri);
    }
}
