package com.yaroshevich.trophies.model;

import com.yaroshevich.trophies.model.interfaces.model.Place;

public class PlaceImpl implements Place {

    private String name;

    public PlaceImpl(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
