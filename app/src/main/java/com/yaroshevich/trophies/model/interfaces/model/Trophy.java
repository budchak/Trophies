package com.yaroshevich.trophies.model.interfaces.model;

import java.util.Date;
import java.util.List;

public interface Trophy {


    int getId();
    void setId(int id);

    int getPlaceId();
    void setPlaceId(int placeId);

    void setName(String name);
    String getName();
    void setWeight(String weight);
    String getWeight();
    Place getPlace();
    void setPlace(Place place);
    void setDate(String date);
    String getDate();
    void setSrc(List<String> src);
    String getPreviewSrc();
    void setPreviewSrc(String src);
    List<String> getSrc();


}
