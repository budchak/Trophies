package com.yaroshevich.trophies.di.component;

import com.yaroshevich.trophies.di.module.NewTrophyScreenModule;
import com.yaroshevich.trophies.di.module.PreviewModule;
import com.yaroshevich.trophies.di.spore.FragmentSpore;
import com.yaroshevich.trophies.model.ObservableTrophy;
import com.yaroshevich.trophies.model.interfaces.model.Preview;
import com.yaroshevich.trophies.ui.newTrophy.NewTrophyFragment;
import com.yaroshevich.trophies.ui.preview.PreviewFragment;

import dagger.Subcomponent;


@Subcomponent(modules = {PreviewModule.class})
@FragmentSpore
public interface PreviewComponent {
    void inject(PreviewFragment fragment);

}


