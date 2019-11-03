package com.yaroshevich.trophies.room.entity.composite;

import androidx.room.Relation;

import com.yaroshevich.trophies.room.entity.TrophyPicture;

public class FishCatch {
    public String name;
    public String weight;
    public String date;

    @Relation(parentColumn = "_id", entityColumn = "id_trophy")
    public TrophyPicture stringList;
}
