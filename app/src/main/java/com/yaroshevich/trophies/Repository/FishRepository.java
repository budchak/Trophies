package com.yaroshevich.trophies.Repository;


import com.yaroshevich.trophies.room.dao.FishDao;
import com.yaroshevich.trophies.room.entity.Fish;

import java.util.List;

public class FishRepository extends BaseRepository<Fish> {

    List<Fish> fishList;

    public FishRepository() {
        super();
    }

    @Override
    public void add(Fish fish) {
      FishDao d = database.fishDao();
      d.insert(fish);
    }

    @Override
    public void update(Fish fish) {

    }

    @Override
    public void remove(Fish fish) {

    }

    @Override
    public List<Fish> getAll() {
       return database.fishDao().getAll();
    }



}
