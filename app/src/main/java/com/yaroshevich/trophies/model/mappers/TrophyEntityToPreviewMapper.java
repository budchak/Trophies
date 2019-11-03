package com.yaroshevich.trophies.model.mappers;

import com.yaroshevich.trophies.model.PreviewImpl;
import com.yaroshevich.trophies.model.interfaces.model.Preview;
import com.yaroshevich.trophies.room.entity.Trophy;

public class TrophyEntityToPreviewMapper extends Mapper<Trophy, Preview> {

    @Override
    public Preview map(Trophy value) {
        Preview preview = new PreviewImpl();
        ((PreviewImpl) preview).setId(value.id);
        ((PreviewImpl) preview).setEmpty(value.isFind == 0);
        preview.setName(value.name);
        ((PreviewImpl) preview).setDate(value.date);
        ((PreviewImpl) preview).setSrc(value.previewSrc);
        ((PreviewImpl) preview).setWeight(value.weight);


        return preview;
    }

    @Override
    public Trophy reverseMap(Preview value) {
        return null;
    }
}
