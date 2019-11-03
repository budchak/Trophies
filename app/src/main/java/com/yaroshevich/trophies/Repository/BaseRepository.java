package com.yaroshevich.trophies.Repository;


import com.yaroshevich.trophies.App;
import com.yaroshevich.trophies.room.FishInfoDatabase;

import java.util.List;

public abstract class BaseRepository<Object> implements Repository<Object> {


    protected FishInfoDatabase database;

    public BaseRepository() {
        database = App.getComponent().getDatabase();
    }


    @Override
    public void add(Object entity) {
    }

    @Override
    public void update(Object entity) {

    }

    @Override
    public void remove(Object entity) {

    }

    @Override
    public List<Object> getAll() {
        return null;
    }
}
