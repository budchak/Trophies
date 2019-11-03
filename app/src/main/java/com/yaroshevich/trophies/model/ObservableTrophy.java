package com.yaroshevich.trophies.model;

import com.yaroshevich.trophies.model.interfaces.model.Place;
import com.yaroshevich.trophies.model.interfaces.model.Trophy;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class ObservableTrophy extends Observable implements Trophy {

    private int id;
    private String name;
    private String weight;
    private Place places;
    private String date;
    private String previewImage;
    private List<String> srcList;
    private int placeId;


    public ObservableTrophy() {
        srcList = new ArrayList<>();
    }

    public ObservableTrophy(String name, String weight, String date, Place place, List<String> srcList) {
        this.name = name;
        this.weight = weight;
        this.date = date;
        this.srcList = srcList;
        this.places = place;
    }

    public void copyTrophy(Trophy trophy) {
        this.name = trophy.getName();
        this.weight = trophy.getWeight();
        this.date = trophy.getDate();
        this.srcList = trophy.getSrc();
        this.places = trophy.getPlace();
        this.placeId = trophy.getPlaceId();
        notifyField();
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
    public void setName(String name) {
        this.name = name;
        notifyField();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setWeight(String weight) {
        this.weight = weight;
        notifyField();
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
        notifyField();
    }

    public void setPlaces(Place places) {
        this.places = places;
        notifyField();
    }

    @Override
    public void setDate(String date) {
        this.date = date;
        notifyField();
    }

    @Override
    public String getDate() {
        return date;
    }

    @Override
    public void setSrc(List<String> src) {
        this.srcList = src;
        notifyField();
    }

    @Override
    public String getPreviewSrc() {
        return previewImage;
    }

    @Override
    public void setPreviewSrc(String src) {
        this.previewImage = src;
        notifyField();
    }


    @Override
    public List<String> getSrc() {
        return srcList;
    }

    public void setPreviewImage(String previewImage) {
        this.previewImage = previewImage;
        notifyField();
    }

    public void setSrcList(List<String> srcList) {
        this.srcList = srcList;
        notifyField();
    }

    @Override
    public int getPlaceId() {
        return placeId;
    }

    @Override
    public void setPlaceId(int placeId) {
        this.placeId = placeId;
    }


    private void notifyField() {
        this.setChanged();
        this.notifyObservers();
    }
}
