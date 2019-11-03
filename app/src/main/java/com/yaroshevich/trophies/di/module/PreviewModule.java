package com.yaroshevich.trophies.di.module;

import androidx.core.content.PermissionChecker;

import com.yaroshevich.trophies.di.spore.FragmentSpore;
import com.yaroshevich.trophies.ui.newTrophy.NewTrophyFragment;
import com.yaroshevich.trophies.ui.preview.PreviewAdapter;
import com.yaroshevich.trophies.ui.preview.PreviewFragment;
import com.yaroshevich.trophies.ui.preview.PreviewPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class PreviewModule {

    private PreviewFragment fragment;

    public PreviewModule(PreviewFragment fragment) {
        this.fragment = fragment;
    }


    @Provides
    PreviewFragment provideFragment() {
        return fragment;
    }


    @FragmentSpore
    @Provides
    PreviewPresenter providePreviewPresenter(){
        return new PreviewPresenter();
    }

    @FragmentSpore
    @Provides
    PreviewAdapter providePreviewAdapter(PreviewPresenter previewPresenter){
        return new PreviewAdapter(previewPresenter);
    }
}
