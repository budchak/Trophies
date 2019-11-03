package com.yaroshevich.trophies.room.entity.composite;

import androidx.room.ColumnInfo;

import com.yaroshevich.trophies.model.interfaces.model.PlaceTrophy;

public class PreviewPlace implements PlaceTrophy {

    @ColumnInfo(name = "_id")
    public int id;

    public String name;

    public String description;

    public int f;

    public int all;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSrc() {
        return description;
    }

    @Override
    public int getValueFound() {
        return f;
    }

    @Override
    public int getValueAll() {
        return all;
    }
}
