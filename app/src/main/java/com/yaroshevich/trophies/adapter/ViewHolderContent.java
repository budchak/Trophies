package com.yaroshevich.trophies.adapter;

import com.yaroshevich.trophies.model.interfaces.model.Preview;

public interface ViewHolderContent {

    void setEmptyHolder(Preview detail);
    void setHolder(Preview detail);
    void showLoadScreen();
    void hideLoadScreen();

}
