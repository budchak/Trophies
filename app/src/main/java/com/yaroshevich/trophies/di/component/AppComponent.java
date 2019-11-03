package com.yaroshevich.trophies.di.component;


import android.content.Context;


import com.yaroshevich.trophies.Repository.FishRepository;
import com.yaroshevich.trophies.Repository.PreviewRepository;
import com.yaroshevich.trophies.Repository.TrophyRepository;
import com.yaroshevich.trophies.di.module.AppModule;
import com.yaroshevich.trophies.di.module.NewTrophyScreenModule;
import com.yaroshevich.trophies.di.module.PreviewModule;
import com.yaroshevich.trophies.model.interfaces.model.Preview;
import com.yaroshevich.trophies.room.FishInfoDatabase;
import com.yaroshevich.trophies.util.ImageLoader;
import com.yaroshevich.trophies.util.ScreenSizeManager;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {AppModule.class})
@Singleton
public interface AppComponent {

    Context getContext();
    ImageLoader getImageLoader();
    FishInfoDatabase getDatabase();
    FishRepository getFishRepository();
    PreviewRepository getPreviewRepository();
    ScreenSizeManager getScreeSizeManager();
    NewTrophyScreenComponent listComponent(NewTrophyScreenModule listModule);
    PreviewComponent plusPreviewComponent(PreviewModule listModule);


}
