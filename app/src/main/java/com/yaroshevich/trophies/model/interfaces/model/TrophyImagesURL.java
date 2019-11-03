package com.yaroshevich.trophies.model.interfaces.model;

import com.yaroshevich.trophies.model.TrophyImage;

import java.util.List;

public interface TrophyImagesURL {

    TrophyImage getUrl(int id);
    List<TrophyImage> getAll();
}
