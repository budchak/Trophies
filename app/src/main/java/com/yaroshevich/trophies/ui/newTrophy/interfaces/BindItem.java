package com.yaroshevich.trophies.ui.newTrophy.interfaces;

import android.net.Uri;
import android.widget.ImageView;

public interface BindItem {
    int getItemType();
    void setPosition(int position);
    int getCurrentPosition();
    void setImage(Uri uri);
}
