package com.yaroshevich.trophies.model;

import com.yaroshevich.trophies.model.interfaces.model.Preview;

public class PreviewImpl implements Preview {

    int id;
    boolean isEmpty;
    String name;
    String src;
    String date;
    String weight;
    String places;

    public PreviewImpl() {
    }

    public PreviewImpl(String name, String src, String weight, String places) {
        this.name = name;
        this.src = src;
        this.weight = weight;
        this.places = places;
    }

    public PreviewImpl(int id, String name, String src, String weight, String places) {
        this.id = id;
        this.name = name;
        this.src = src;
        this.weight = weight;
        this.places = places;
    }

    public PreviewImpl(int id, boolean isEmpty, String name, String src) {
        this.id = id;
        this.isEmpty = isEmpty;
        this.name = name;
        this.src = src;
    }

    public PreviewImpl(String name) {
        this.name = name;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }



    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getSrc() {
        return src;
    }

    @Override
    public String getWeight() {
        return weight;
    }

    @Override
    public String getPlaces() {
        return places;
    }

    @Override
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public boolean isEmpty() {
        return isEmpty;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setPlaces(String places) {
        this.places = places;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }
}
