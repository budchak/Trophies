package com.yaroshevich.trophies.room.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Trophy {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    public int id;

    public String name;

    public String weight;

    public String date;

    @ColumnInfo(name = "preview_src")
    public String previewSrc;

    @ColumnInfo(name = "is_find")
    public int isFind;

    @ColumnInfo(name = "info_id")
    public int infoId;

    @ColumnInfo(name = "place_id")
    public int placeId;
}
