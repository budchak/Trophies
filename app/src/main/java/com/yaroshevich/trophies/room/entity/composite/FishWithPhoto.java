package com.yaroshevich.trophies.room.entity.composite;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.yaroshevich.trophies.room.entity.FindFish;
import com.yaroshevich.trophies.room.entity.TrophyPicture;

import java.util.List;

public class FishWithPhoto {

    @Embedded
    public FindFish findFish;

    @Relation(parentColumn = "_id", entityColumn = "id_trophy")
    public List<TrophyPicture> stringList;
}
