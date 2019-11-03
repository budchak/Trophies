package com.yaroshevich.trophies.room;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.yaroshevich.trophies.room.dao.FindedFishDao;
import com.yaroshevich.trophies.room.dao.FishDao;
import com.yaroshevich.trophies.room.dao.FishPictureDao;
import com.yaroshevich.trophies.room.dao.PreviewDao;
import com.yaroshevich.trophies.room.dao.RiverDao;
import com.yaroshevich.trophies.room.dao.RiverFishDao;
import com.yaroshevich.trophies.room.dao.TrophyDao;
import com.yaroshevich.trophies.room.entity.FindFish;
import com.yaroshevich.trophies.room.entity.Fish;
import com.yaroshevich.trophies.room.entity.Trophy;
import com.yaroshevich.trophies.room.entity.TrophyPicture;
import com.yaroshevich.trophies.room.entity.Preview;
import com.yaroshevich.trophies.room.entity.River;
import com.yaroshevich.trophies.room.entity.RiverFish;


@Database(entities = {Fish.class, River.class, RiverFish.class
        , FindFish.class, Preview.class, TrophyPicture.class, Trophy.class}, version = 1, exportSchema = false)
public abstract class FishInfoDatabase extends RoomDatabase {
    public abstract FishDao fishDao();
    public abstract RiverDao riverDao();
    public abstract RiverFishDao riverFishDao();
    public abstract FindedFishDao findedFishDao();
    public abstract PreviewDao previewDao();
    public abstract FishPictureDao fishPictureDao();
    public abstract TrophyDao TrophyDao();
}