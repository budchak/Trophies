package com.yaroshevich.trophies.room.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.yaroshevich.trophies.room.entity.Fish;
import com.yaroshevich.trophies.room.entity.Preview;

import java.util.List;

@Dao
public interface PreviewDao {

    @Query("SELECT * FROM preview")
    List<Preview> getAll();

    @Query("SELECT * FROM preview WHERE _id = :id")
    Preview getById(int id);

    @Insert
    void insert(Preview fishInfo);

    @Update
    void update(Preview fishInfo);

    @Delete
    void delete(Preview fishInfo);
}
