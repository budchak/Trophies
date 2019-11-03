package com.yaroshevich.trophies.ui.preview.interfaces;

import android.media.Image;

import com.yaroshevich.trophies.model.interfaces.model.Preview;
import com.yaroshevich.trophies.ui.base.BindItem;


public interface PreviewRVPresenter {

        int getItemCount();

        void saveImage(Image image);

        void onCreateView(int id);

        void onBindView(int id, BindItem<Preview> bindItem);

        void onItemCLick(int id);
}