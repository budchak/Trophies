package com.yaroshevich.trophies.Repository;

import com.yaroshevich.trophies.App;
import com.yaroshevich.trophies.model.interfaces.model.PlaceTrophy;
import com.yaroshevich.trophies.room.entity.composite.PreviewPlace;

import java.util.ArrayList;
import java.util.List;

public class PlaceTrophyRepository extends BaseRepository<PlaceTrophy> {

    List<PlaceTrophy> list;


    @Override
    public List<PlaceTrophy> getAll() {
        List<PreviewPlace> placeList = App.getComponent().getDatabase().riverDao().getAllWithCount();

        List<PlaceTrophy> placeTrophies = new ArrayList<>();
        placeTrophies.addAll(placeList);
        list = placeTrophies;
        return placeTrophies;
    }
}
