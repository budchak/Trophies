package com.yaroshevich.trophies.di.module;


import android.content.Context;


import com.yaroshevich.trophies.Repository.FishRepository;
import com.yaroshevich.trophies.Repository.PreviewRepository;
import com.yaroshevich.trophies.Repository.TrophyRepository;
import com.yaroshevich.trophies.room.DB;
import com.yaroshevich.trophies.room.FishInfoDatabase;
import com.yaroshevich.trophies.util.ImageLoader;
import com.yaroshevich.trophies.util.ScreenSizeManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    Context context;


    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    Context getAppContext(){
        return this.context;
    }

    @Provides
    @Singleton
    FishInfoDatabase getDatabase(DB db){
        return db.getDB();
    }

    @Provides
    @Singleton
    DB getDB(Context context){
        return new DB(context);
    }

    @Provides
    @Singleton
    FishRepository getFishRepository(){
        return new FishRepository();
    }

    @Provides
    @Singleton
    PreviewRepository getPreviewRepository(){
        return new PreviewRepository();
    }

    @Provides
    ImageLoader getImageLoader(){
        return new ImageLoader(context);
    }

    @Provides
    ScreenSizeManager provideScreenSizeManager(Context context){
        return new ScreenSizeManager(context);
    }

}
