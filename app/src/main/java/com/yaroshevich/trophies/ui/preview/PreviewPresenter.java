package com.yaroshevich.trophies.ui.preview;

import android.media.Image;
import android.util.Log;

import com.yaroshevich.trophies.App;
import com.yaroshevich.trophies.Repository.PreviewRepository;
import com.yaroshevich.trophies.model.interfaces.model.Preview;
import com.yaroshevich.trophies.navigation.AppNavigator;
import com.yaroshevich.trophies.ui.base.BindItem;
import com.yaroshevich.trophies.ui.preview.interfaces.PreviewContract;
import com.yaroshevich.trophies.ui.preview.interfaces.PreviewRVPresenter;

import java.util.List;

public class PreviewPresenter implements PreviewContract.Presenter, PreviewRVPresenter {

    private PreviewContract.View view;

    private PreviewRepository repository;

    private List<Preview> previewList;

    int id;

    public PreviewPresenter() {
        repository = App.getComponent().getPreviewRepository();
        previewList = repository.getAllByRiver(id);
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void attach(PreviewContract.View view) {
        this.view = view;
    }

    @Override
    public void detach() {
        view = null;
    }


    // Adapter presenter metods

    @Override
    public int getItemCount() {
        return previewList.size();
    }

    @Override
    public void saveImage(Image image) {

    }

    @Override
    public void onCreateView(int id) {
        this.id = id;
        previewList = repository.getAllByRiver(id);
    }

    @Override
    public void onBindView(int id, BindItem<Preview> bindItem) {
        bindItem.bind(previewList.get(id));
    }

    @Override
    public void onItemCLick(int id) {
        Log.e("PP", " " + id    + " " + previewList.get(id).getId());
        if (previewList.get(id).isEmpty()) {
            AppNavigator.getInstance(null).navigateToEmptyDetailScreen(previewList.get(id).getId());
        } else {
            AppNavigator.getInstance(null).navigateToDetailScreen(previewList.get(id).getId());
        }
    }


}
