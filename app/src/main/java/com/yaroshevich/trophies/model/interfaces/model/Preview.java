package com.yaroshevich.trophies.model.interfaces.model;

public interface Preview {

    int getId();
    String getName();
    void setName(String name);
    String getSrc();

    String getWeight();
    String getPlaces();
    String getDate();
    boolean isEmpty();
}
