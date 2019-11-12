package com.yaroshevich.trophies.di.component;

import com.yaroshevich.trophies.di.module.MainActivityModule;
import com.yaroshevich.trophies.di.spore.ActivitySpore;
import com.yaroshevich.trophies.ui.MainActivity;


import dagger.Subcomponent;

@ActivitySpore
@Subcomponent(modules = {MainActivityModule.class})
public interface MainActivityComponent {

    void inject(MainActivity mainActivity);
}
