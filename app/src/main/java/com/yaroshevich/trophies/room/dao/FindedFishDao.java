package com.yaroshevich.trophies.room.dao;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.yaroshevich.trophies.room.entity.composite.FishWithPhoto;
import com.yaroshevich.trophies.room.entity.FindFish;

import java.util.List;

@Dao
public interface FindedFishDao {

    @Query("SELECT * FROM find_fish ")
    List<FindFish> getAll();

    @Query("SELECT * FROM find_fish WHERE id_fish = :name")
    FindFish getById(int name);

    @Insert
    void insert(FindFish fishInfo);

    @Update
    void update(FindFish fishInfo);

    @Delete
    void delete(FindFish fishInfo);

    @Transaction
    @Query("SELECT * from find_fish")
    List<FishWithPhoto> getDepartmentsWithEmployees();
}
