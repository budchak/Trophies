package com.yaroshevich.trophies.di.module;


import android.util.Log;

import com.yaroshevich.trophies.Repository.TrophyRepository;
import com.yaroshevich.trophies.di.spore.FragmentSpore;
import com.yaroshevich.trophies.model.ObservableTrophy;
import com.yaroshevich.trophies.ui.newTrophy.NewTrophyAdapter;
import com.yaroshevich.trophies.ui.newTrophy.NewTrophyPresenter;
import com.yaroshevich.trophies.ui.newTrophy.NewTrophyFragment;
import com.yaroshevich.trophies.util.ImageLoader;

import dagger.Module;
import dagger.Provides;

@Module
public class NewTrophyScreenModule {

    private NewTrophyFragment fragment;

    public NewTrophyScreenModule(NewTrophyFragment fragment) {
        this.fragment = fragment;
    }


    @Provides
    NewTrophyFragment provideFragment() {
        return fragment;
    }

    @FragmentSpore
    @Provides
    NewTrophyPresenter providePresenter(NewTrophyFragment fragment, ImageLoader loader, TrophyRepository repository, ObservableTrophy trophy) {
        Log.e("MODULE", "provide presenter");
        return new NewTrophyPresenter(fragment, repository, loader, trophy);
    }

    @FragmentSpore
    @Provides
    TrophyRepository provideTrophyRepository() {
        return new TrophyRepository();
    }

    @FragmentSpore
    @Provides
    NewTrophyAdapter provideNewTrophyAdapter(NewTrophyPresenter presenter) {
        return new NewTrophyAdapter(presenter);
    }

    @FragmentSpore
    @Provides
    ObservableTrophy provideTrophy() {
        Log.e("MODULE", "provide trophy");
        return new ObservableTrophy();
    }
}
