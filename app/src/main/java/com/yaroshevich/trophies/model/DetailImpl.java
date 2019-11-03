package com.yaroshevich.trophies.model;

import com.yaroshevich.trophies.model.interfaces.model.Detail;

import java.util.List;

public class DetailImpl implements Detail {

    private String name;
    private String weight;
    private String place;
    private List<String> src;

    public DetailImpl(String name, String weight, String place, List<String> src) {
        this.name = name;
        this.weight = weight;
        this.place = place;
        this.src = src;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setSrc(List<String> src) {
        this.src = src;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getWeight() {
        return weight;
    }

    @Override
    public String getData() {
        return null;
    }

    @Override
    public String getPlace() {
        return place;
    }

    @Override
    public List<String> getSRCList() {
        return src;
    }
}
