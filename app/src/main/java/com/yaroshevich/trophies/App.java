package com.yaroshevich.trophies;

import android.app.Activity;
import android.app.Application;

import com.yaroshevich.trophies.di.component.AppComponent;
import com.yaroshevich.trophies.di.component.DaggerAppComponent;
import com.yaroshevich.trophies.di.component.MainActivityComponent;
import com.yaroshevich.trophies.di.component.NewTrophyScreenComponent;
import com.yaroshevich.trophies.di.component.PreviewComponent;
import com.yaroshevich.trophies.di.module.AppModule;
import com.yaroshevich.trophies.di.module.MainActivityModule;
import com.yaroshevich.trophies.di.module.NewTrophyScreenModule;
import com.yaroshevich.trophies.di.module.PreviewModule;
import com.yaroshevich.trophies.ui.MainActivity;
import com.yaroshevich.trophies.ui.newTrophy.NewTrophyFragment;
import com.yaroshevich.trophies.ui.preview.PreviewFragment;


public class App extends Application {

    private static App app;
    private static AppComponent component;
    private static NewTrophyScreenComponent newTrophyScreenComponent;
    private static PreviewComponent previewComponent;
    private static MainActivityComponent mainActivityComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        component = DaggerAppComponent.builder()
                .appModule(new AppModule(getApplicationContext()))
                .build();


    }

    public static App getInstance() {
        return app;
    }

    public NewTrophyScreenComponent initNewTrophyComponent(NewTrophyFragment fragment) {
        if (newTrophyScreenComponent == null) {
            newTrophyScreenComponent = component.plusNewTrophyComponent(new NewTrophyScreenModule(fragment));
        }
        return newTrophyScreenComponent;
    }

    public PreviewComponent initPreviewComponent(PreviewFragment fragment){
        if (previewComponent == null){
            previewComponent = component.plusPreviewComponent(new PreviewModule(fragment));
        }
        return previewComponent;
    }

    public PreviewComponent getPreviewComponent(){
        return previewComponent;
    }

    public MainActivityComponent initMainActivityComponent(MainActivity activity){
        if (mainActivityComponent == null){
            mainActivityComponent = component.plusMainActivityComponent(new MainActivityModule(activity));
        }
        return mainActivityComponent;
    }

    public static AppComponent getComponent() {
        return component;
    }


    public NewTrophyScreenComponent getListComponent() {
        return newTrophyScreenComponent;
    }





    public void destroyListComponent() {
        newTrophyScreenComponent = null;
    }


}
