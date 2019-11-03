package com.yaroshevich.trophies.model;

import com.yaroshevich.trophies.model.interfaces.model.Fish;

import java.io.File;

public class FishInfo implements Fish {

    private int id;
    private String name;
    private String image;
    private String description;


    public FishInfo(int id, String name, String image, String description) { 
        this.id = id;
        this.name = name;
        this.image = image;
        this.description = description;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getImage() {
        return image;
    }

    @Override
    public String getDesription() {
        return null;
    }
}
