package com.yaroshevich.trophies.room.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class RiverFish {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    public int id;

    @ColumnInfo(name = "fish_id")
    public String fishId;

    @ColumnInfo(name = "river_id")
    public String riverId;
}
