package com.yaroshevich.trophies.ui.newTrophy.interfaces;

import android.media.Image;

public interface NewTrophyRViewPresenter {

    int getItemCount();

    void saveImage(Image image);

    void onCreateView(int id);

    void onBindView(int id, BindItem bindItem);

    void onItemCLick(BindItem item);
}
