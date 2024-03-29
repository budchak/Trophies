package com.yaroshevich.trophies.ui.newTrophy;

import android.net.Uri;
import android.util.Log;

import com.yaroshevich.trophies.App;
import com.yaroshevich.trophies.Repository.TrophyRepository;
import com.yaroshevich.trophies.model.ObservableTrophy;
import com.yaroshevich.trophies.model.interfaces.model.Trophy;
import com.yaroshevich.trophies.navigation.AppNavigator;
import com.yaroshevich.trophies.ui.newTrophy.interfaces.BindItem;
import com.yaroshevich.trophies.ui.newTrophy.interfaces.RecyclerViewContract;
import com.yaroshevich.trophies.util.ImageLoader;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.inject.Inject;

public class NewTrophyPresenter implements com.yaroshevich.trophies.ui.newTrophy.interfaces.NewTrophyContract.Presenter, RecyclerViewContract.Presenter {

    @Inject
    com.yaroshevich.trophies.ui.newTrophy.interfaces.NewTrophyContract.View view;

    BindItem item;
    int id;

    private AppNavigator navigator;

    private Trophy trophyEntity;

    @Inject
    public ImageLoader imageLoader;

    @Inject
    public TrophyRepository repository;

    @Inject
    public ObservableTrophy trophy;

    private Observer observer = new Observer() {
        @Override
        public void update(Observable o, Object arg) {
            view.update(trophy);
            Log.e("NEW_TROPHY_PRESENTER", "UPDate");
        }
    };

    @Inject
    public NewTrophyPresenter(com.yaroshevich.trophies.ui.newTrophy.interfaces.NewTrophyContract.View view
            , TrophyRepository repository
            , ImageLoader imageLoader
            , ObservableTrophy trophy) {

        this.view = view;
        this.repository = repository;
        this.imageLoader = imageLoader;
        this.trophy = trophy;
        navigator = AppNavigator.getInstance(null);
        trophy.addObserver(observer);
    }


    public void saveTrophy() {

        if (trophy.getPreviewSrc() == null) {
            view.showMessage("загрузите изображение");
            return;
        }

        if (trophy.getSrc().size() == 0) {
            view.showMessage("загрузите 1 изображение");
            return;
        }

        String fileName = imageLoader.createFileName(100, trophy.getName());
        imageLoader.saveFile(trophy.getPreviewSrc(), fileName);
        trophy.setPreviewImage(fileName);

        List<String> srcList = trophy.getSrc();
        Log.e("NTP", Integer.toString(srcList.size()));
        int i = 1;
        for (String s :
                srcList) {
            String f = imageLoader.createFileName(i, trophy.getName());
            imageLoader.saveFile(s, f);
            srcList.set(i - 1, f);
            i++;
        }
        Log.e("NTP", Integer.toString(srcList.size()));
        trophy.setSrc(srcList);
        trophy.setId(id);

        repository.update(trophy);
        AppNavigator.getInstance(null).navigateToPreviewScreen(trophy.getPlaceId());
        Log.e("Save database", "sukasses");
    }

    @Override
    public void attach(com.yaroshevich.trophies.ui.newTrophy.interfaces.NewTrophyContract.View view) {
        this.view = view;
    }

    @Override
    public void detach() {
        view = null;
    }

    @Override
    public int getItemCount() {
        return trophy.getSrc().size();
    }

    @Override
    public void onCreateView(int id) {

    }

    @Override
    public void onBindView(int id, BindItem bindItem) {
        item = bindItem;
        bindItem.setPosition(id);
    }

    @Override
    public void onImageTake(Uri uri) {
        item.setImage(uri);
        trophy.getSrc().add(App.getComponent().getImageLoader().getStringFromUri(App.getComponent().getContext(), uri));
    }

    @Override
    public void onTitleImageTake(Uri uri) {
        trophy.setPreviewImage(App.getComponent().getImageLoader().getStringFromUri(App.getComponent().getContext(), uri));
        view.setTitleImage(trophy.getPreviewSrc());

    }

    @Override
    public void onTitleViewClick() {
        view.getTitleImage();
    }

    @Override
    public void loadTrophy(int id) {
        this.id = id;
        trophyEntity = repository.getById(id);

        if (trophy.getName() == null) {
            trophy.copyTrophy(trophyEntity);
            Log.e("TRophy", "copy trophy");
        }
        view.update(trophy);
    }

    @Override
    public void onItemCLick(BindItem item) {
        this.item = item;
        if (item.getItemType() == 0) {
            trophy.setPreviewImage(trophy.getSrc().get(item.getCurrentPosition()));
            view.setTitleImage(trophy.getPreviewSrc());
            return;
        } else {
            view.getImage();
        }

    }

    @Override
    public void onClickEvent(NewTrophyCLickEvent cLickEvent) {
        switch (cLickEvent) {
            case APPLY_CLICK:
                saveTrophy();
                break;
            case DATE_CLICK:
                navigator.navigateDateDialog();
                break;
            case PLACE_CLICK:
                navigator.navigatePlaceDialog();
                break;
            case TITLE_CLICK:
                view.getTitleImage();
                break;
            case WEIGHT_CLICK:
                navigator.navigateWeightDialog();
                break;
        }
    }

}
