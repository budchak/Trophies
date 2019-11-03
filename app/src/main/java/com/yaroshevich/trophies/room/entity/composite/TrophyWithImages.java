package com.yaroshevich.trophies.room.entity.composite;

import androidx.room.Embedded;
import androidx.room.Relation;


import com.yaroshevich.trophies.room.entity.Trophy;
import com.yaroshevich.trophies.room.entity.TrophyPicture;

import java.util.ArrayList;
import java.util.List;

public class TrophyWithImages  {

    @Embedded
    public Trophy findFish;

    @Relation(parentColumn = "_id", entityColumn = "id_trophy")
    public List<TrophyPicture> stringList;


    public TrophyWithImages() {
        findFish = new Trophy();
        stringList = new ArrayList<>();
    }
}
