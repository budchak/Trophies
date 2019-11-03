package com.yaroshevich.trophies.room.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.yaroshevich.trophies.room.entity.RiverFish;

import java.util.List;


@Dao
public interface RiverFishDao {

    @Query("SELECT * FROM riverfish")
    List<RiverFish> getAll();

    @Query("SELECT * FROM RiverFish WHERE _id = :name")
    RiverFish getById(String name);

    @Insert
    void insert(RiverFish fishInfo);

    @Update
    void update(RiverFish fishInfo);

    @Delete
    void delete(RiverFish fishInfo);
}
