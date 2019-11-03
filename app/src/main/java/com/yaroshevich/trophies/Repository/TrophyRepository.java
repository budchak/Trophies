package com.yaroshevich.trophies.Repository;

import android.util.Log;

import com.yaroshevich.trophies.model.TrophyImpl;
import com.yaroshevich.trophies.model.interfaces.model.Trophy;
import com.yaroshevich.trophies.room.entity.composite.IsCatсh;
import com.yaroshevich.trophies.room.entity.composite.TrophyWithImages;
import com.yaroshevich.trophies.room.dao.FindedFishDao;
import com.yaroshevich.trophies.room.dao.FishPictureDao;
import com.yaroshevich.trophies.room.dao.TrophyDao;
import com.yaroshevich.trophies.room.entity.TrophyPicture;

import java.util.ArrayList;
import java.util.List;

public class TrophyRepository extends BaseRepository<Trophy> {

    private FindedFishDao findedFishDao;
    private FishPictureDao fishPictureDao;
    private TrophyDao trophyDao;

    public TrophyRepository() {
        super();
        trophyDao = database.TrophyDao();
    }

    @Override
    public void add(Trophy entity) {

    }

    @Override
    public void update(Trophy entity) {
        TrophyWithImages trophyWithImages = new TrophyWithImages();

        trophyWithImages.findFish.id = entity.getId();
        trophyWithImages.findFish.name = entity.getName();
        trophyWithImages.findFish.weight = entity.getWeight();
        trophyWithImages.findFish.date = entity.getDate();
        trophyWithImages.findFish.previewSrc = entity.getPreviewSrc();
        trophyWithImages.findFish.placeId = entity.getPlaceId();
        trophyWithImages.findFish.isFind = 1;

        List<TrophyPicture> trophyPictures = new ArrayList<>();
        for (String s :
                entity.getSrc()) {
            TrophyPicture picture = new TrophyPicture();
            picture.src = s;
            picture.trophyId = entity.getId();
            trophyPictures.add(picture);
        }
        trophyWithImages.stringList = trophyPictures;
        Log.e("Save",Integer.toString( trophyPictures.size()));

        trophyDao.update(trophyWithImages);

    }

    @Override
    public void remove(Trophy entity) {

    }

    @Override
    public List<Trophy> getAll() {
        List<IsCatсh> isCatсhs = trophyDao.getCatch();

        for (IsCatсh isCatch :
                isCatсhs) {
            if (isCatch.isCatch == 0) {

            }
        }
        return null;
    }

    public Trophy getById(int id){
        TrophyWithImages withImages =   trophyDao.getTrophyWithPhoto(id);
        Log.e("repo", withImages.findFish.previewSrc);
        Trophy trophy = new TrophyImpl();
        trophy.setPreviewSrc(withImages.findFish.previewSrc);
        trophy.setId(withImages.findFish.id);
        trophy.setName(withImages.findFish.name);
        trophy.setDate(withImages.findFish.date);
        trophy.setWeight(withImages.findFish.weight);
        trophy.setPlaceId(withImages.findFish.placeId);
        List<String> strings = new ArrayList<>();
        Log.e("repo", Integer.toString(withImages.findFish.placeId));
        for (TrophyPicture s :
                withImages.stringList) {
            strings.add(s.src);
            Log.e("repo2", s.src);
        }
        trophy.setSrc(strings);
        return trophy;
    }
}
