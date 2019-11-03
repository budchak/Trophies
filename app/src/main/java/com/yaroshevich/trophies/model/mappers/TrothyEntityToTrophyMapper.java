package com.yaroshevich.trophies.model.mappers;

import com.yaroshevich.trophies.App;
import com.yaroshevich.trophies.model.PlaceImpl;
import com.yaroshevich.trophies.model.TrophyImpl;
import com.yaroshevich.trophies.room.entity.Trophy;

public class TrothyEntityToTrophyMapper extends Mapper<Trophy, com.yaroshevich.trophies.model.interfaces.model.Trophy> {



    @Override
    public com.yaroshevich.trophies.model.interfaces.model.Trophy map(Trophy value) {
        com.yaroshevich.trophies.model.interfaces.model.Trophy trophy = new TrophyImpl();

       //tDate(new Date(15));
        trophy.setName(value.name);
        trophy.setWeight(value.weight);
        ((TrophyImpl) trophy).setPlaces(new PlaceImpl("name"));
        ((TrophyImpl) trophy).setPreviewImage(value.previewSrc);


        return trophy;
    }

    @Override
    public Trophy reverseMap(com.yaroshevich.trophies.model.interfaces.model.Trophy value) {



        return null;
    }
}
