package com.yaroshevich.trophies.Repository;

import com.yaroshevich.trophies.model.PlaceImpl;
import com.yaroshevich.trophies.model.interfaces.model.Place;

import java.util.ArrayList;
import java.util.List;

public class PlaceRepository extends BaseRepository<Place> {

    private List<Place> places;

    public PlaceRepository() {
        places = new ArrayList<>();
        places.add(new PlaceImpl("Лань"));
        places.add(new PlaceImpl("Цна"));
        places.add(new PlaceImpl("Неман"));
        places.add(new PlaceImpl("Свислачь"));
        places.add(new PlaceImpl("Припять"));
    }

    @Override
    public List<Place> getAll() {
        return places;
    }
}
