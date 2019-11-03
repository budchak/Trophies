package com.yaroshevich.trophies.room.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "find_fish")
public class FindFish {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    public int id;

    @ColumnInfo(name = "id_fish")
    public int fishID;

    @ColumnInfo(name = "river_id")
    public int riverId;

    public int weight;

    public String date;


}
