package com.yaroshevich.trophies.ui.base.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.yaroshevich.trophies.R;
import com.yaroshevich.trophies.ui.ActionBarModule;

public abstract class ToolbarFragment extends BaseFragment {

    protected Toolbar toolbar;

    private FragmentManager fragmentManager;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fullView = inflater.inflate(R.layout.fragment_toolbar, null);
        toolbar = fullView.findViewById(R.id.toolbar);
        fragmentManager = getChildFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.container, getFragment()).commit();
        this.view = fullView;
        return fullView;
    }



    protected abstract Fragment getFragment();



}
