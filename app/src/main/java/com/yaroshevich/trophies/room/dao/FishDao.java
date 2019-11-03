package com.yaroshevich.trophies.room.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.yaroshevich.trophies.room.entity.Fish;

import java.util.List;

@Dao
public interface FishDao {

    @Query("SELECT * FROM fish_info")
    List<Fish> getAll();

    @Query("SELECT * FROM fish_info WHERE _id = :name")
    Fish getById(int name);

    @Insert
    void insert(Fish fishInfo);

    @Update
    void update(Fish fishInfo);

    @Delete
    void delete(Fish fishInfo);
}
