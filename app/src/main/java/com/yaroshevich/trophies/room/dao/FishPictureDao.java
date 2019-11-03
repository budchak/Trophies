package com.yaroshevich.trophies.room.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.yaroshevich.trophies.room.entity.TrophyPicture;

import java.util.List;

@Dao
public interface FishPictureDao {

    @Query("SELECT * FROM trophy_image")
    List<TrophyPicture> getAll();

    @Query("SELECT * FROM trophy_image WHERE _id = :id")
    TrophyPicture getById(int id);

    @Insert
    void insert(TrophyPicture fishInfo);

    @Update
    void update(TrophyPicture fishInfo);

    @Delete
    void delete(TrophyPicture fishInfo);
}
