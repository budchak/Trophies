package com.yaroshevich.trophies;

import android.app.Application;

import com.yaroshevich.trophies.di.component.AppComponent;
import com.yaroshevich.trophies.di.component.DaggerAppComponent;
import com.yaroshevich.trophies.di.component.NewTrophyScreenComponent;
import com.yaroshevich.trophies.di.component.PreviewComponent;
import com.yaroshevich.trophies.di.module.AppModule;
import com.yaroshevich.trophies.di.module.NewTrophyScreenModule;
import com.yaroshevich.trophies.di.module.PreviewModule;
import com.yaroshevich.trophies.model.interfaces.model.Preview;
import com.yaroshevich.trophies.ui.newTrophy.NewTrophyFragment;
import com.yaroshevich.trophies.ui.preview.PreviewFragment;


public class App extends Application {

    private static App app;
    private static AppComponent component;
    private static NewTrophyScreenComponent newTrophyScreenComponent;
    private static PreviewComponent previewComponent;

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
            newTrophyScreenComponent = component.listComponent(new NewTrophyScreenModule(fragment));
        }
        return newTrophyScreenComponent;
    }

    public PreviewComponent initPreviewComponent(PreviewFragment fragment){
        if (previewComponent == null){
            previewComponent = component.plusPreviewComponent(new PreviewModule(fragment));
        }
        return previewComponent;
    }

    public static AppComponent getComponent() {
        return component;
    }


    public NewTrophyScreenComponent getListComponent() {
        return newTrophyScreenComponent;
    }

    public PreviewComponent getPreviewComponent(){
        return previewComponent;
    }

    public void destroyListComponent() {
        newTrophyScreenComponent = null;
    }


}
