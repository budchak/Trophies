package com.yaroshevich.trophies.model;

import com.yaroshevich.trophies.model.interfaces.model.Place;
import com.yaroshevich.trophies.model.interfaces.model.Trophy;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TrophyImpl implements Trophy {

    private int id;

    private String name;
    private String weight;
    private String date;

    private Place places;

    private String previewImage;
    private List<String> srcList;
    private int placeId;


    public TrophyImpl() {
        srcList = new ArrayList<>();
    }

    public TrophyImpl(String name, String weight, String date, Place place, List<String> srcList) {
        this.name = name;
        this.weight = weight;
        this.date = date;
        this.srcList = srcList;
        this.places = place;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setWeight(String weight) {
        this.weight = weight;
    }

    @Override
    public String getWeight() {
        return weight;
    }

    @Override
    public Place getPlace() {
        return places;
    }

    @Override
    public void setPlace(Place place) {
        this.places = place;
    }

    public void setPlaces(Place places) {
        this.places = places;
    }

    @Override
    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String getDate() {
        return date;
    }

    @Override
    public void setSrc(List<String> src) {
        this.srcList = src;
    }

    @Override
    public String getPreviewSrc() {
        return previewImage;
    }

    @Override
    public void setPreviewSrc(String src) {
        this.previewImage = src;
    }


    @Override
    public List<String> getSrc() {
        return srcList;
    }

    public void setPreviewImage(String previewImage) {
        this.previewImage = previewImage;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getPlaceId() {
        return placeId;
    }

    @Override
    public void setPlaceId(int placeId) {
        this.placeId = placeId;
    }
}
