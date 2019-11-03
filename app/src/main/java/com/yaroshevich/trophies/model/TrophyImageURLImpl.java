package com.yaroshevich.trophies.model;

import com.yaroshevich.trophies.model.interfaces.model.TrophyImagesURL;

import java.util.ArrayList;
import java.util.List;

public class TrophyImageURLImpl implements TrophyImagesURL {

    List<TrophyImage> url;

    public TrophyImageURLImpl(List<TrophyImage> url) {
        this.url = url;
    }

    public TrophyImageURLImpl() {
        url = new ArrayList<>();
    }

    @Override
    public TrophyImage getUrl(int id) {
        return url.get(id);
    }

    @Override
    public List<TrophyImage> getAll() {
        return url;
    }
}
