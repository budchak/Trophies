package com.yaroshevich.trophies.room.dao;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.yaroshevich.trophies.room.entity.River;
import com.yaroshevich.trophies.room.entity.composite.PreviewPlace;

import java.util.ArrayList;
import java.util.List;

@Dao
public abstract class RiverDao {

    @Query("SELECT * FROM river")
    public abstract List<River> getAll();

    @Query("SELECT * FROM river WHERE name = :name")
    public abstract River getById(String name);

    @Insert
    public abstract void insert(River fishInfo);

    @Update
    public abstract void update(River fishInfo);

    @Delete
    public abstract void delete(River fishInfo);


    @Transaction
    public List<PreviewPlace> getAllWithCount() {
        List<PreviewPlace> placeList = new ArrayList<>();
        List<River> list = getAll();
        for (River r :
                list) {

            PreviewPlace previewPlace = new PreviewPlace();
            previewPlace.id = r.id;
            previewPlace.name = r.name;
            previewPlace.description = r.description;
            previewPlace.f = getCount(r.id);
            previewPlace.all = getCountAll(r.id);
            placeList.add(previewPlace);
        }

        return placeList;
    }

    @Query("SELECT COUNT(_id) FROM trophy where place_id = :id")
    public abstract int getCountAll(int id);

    @Query("SELECT COUNT(_id) FROM trophy where place_id = :id AND is_find = 1")
    public abstract int getCount(int id);

}