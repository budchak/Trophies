package com.yaroshevich.trophies.room.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "trophy_image")
public class TrophyPicture {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    public int id;

    public String src;


    @ColumnInfo(name = "id_trophy")
    public int trophyId;

    @ColumnInfo(name = "is_title")
    public int isTitle;
}
