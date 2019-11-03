package com.yaroshevich.trophies.room.entity;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Preview {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    public int id;


    @ColumnInfo(name = "fish_id")
    public int fishID;

    @ColumnInfo(name = "is_find")
    public int isFind;

    public String src;
}
