package com.yaroshevich.trophies.room.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.yaroshevich.trophies.room.entity.Trophy;
import com.yaroshevich.trophies.room.entity.TrophyPicture;
import com.yaroshevich.trophies.room.entity.composite.IsCatсh;
import com.yaroshevich.trophies.room.entity.composite.TrophyWithImages;

import java.util.List;

@Dao
public abstract class TrophyDao {

    @Query("SELECT * FROM trophy")
    public abstract List<Trophy> getAll();

    @Query("SELECT * FROM trophy WHERE place_id = :id")
    public abstract List<Trophy> getAll(int id);

    @Query("SELECT * FROM trophy WHERE _id = :name")
    public abstract Trophy getById(int name);

    @Query("SELECT _id, is_find FROM trophy")
    public abstract List<IsCatсh> getCatch();

    @Transaction
    @Query("SELECT * from trophy")
    public abstract List<TrophyWithImages> getTrophyWithPhoto();

    @Transaction
    @Query("SELECT * from trophy WHERE _id = :name")
    public abstract TrophyWithImages getTrophyWithPhoto(int name);


    @Transaction
    public void update(TrophyWithImages images) {
        update(images.findFish);
        for (TrophyPicture tag : images.stringList) {
            insert(tag);
        }
    }

    @Insert
    public abstract void insert(Trophy fishInfo);

    @Update
    public abstract void update(Trophy fishInfo);

    @Insert
    public abstract void insert(TrophyPicture fishInfo);

    @Delete
    public abstract void delete(Trophy fishInfo);
}
