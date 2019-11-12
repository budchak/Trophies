package com.yaroshevich.trophies.di.component;


import com.yaroshevich.trophies.di.module.MainActivityModule;
import com.yaroshevich.trophies.di.module.NewTrophyScreenModule;
import com.yaroshevich.trophies.di.spore.FragmentSpore;
import com.yaroshevich.trophies.model.ObservableTrophy;
import com.yaroshevich.trophies.ui.newTrophy.NewTrophyFragment;

import dagger.Subcomponent;


@Subcomponent(modules = {NewTrophyScreenModule.class})
@FragmentSpore
public interface NewTrophyScreenComponent {
    void inject(NewTrophyFragment fragment);
    ObservableTrophy getTrophy();
}
