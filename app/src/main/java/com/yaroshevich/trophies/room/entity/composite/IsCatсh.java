package com.yaroshevich.trophies.room.entity.composite;

import androidx.room.ColumnInfo;

public class IsCatсh {

    @ColumnInfo(name = "_id")
    public int id;
    @ColumnInfo(name = "is_find")
    public int isCatch;

}
