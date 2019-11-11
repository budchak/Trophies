package com.yaroshevich.trophies.ui.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.yaroshevich.trophies.R;

import java.util.zip.Inflater;

public abstract class ToolbarFragment extends BaseFragment {

    protected Toolbar toolbar;

    public int createToolbar() {
        return 0;
    }

    @Override
    public int getLayout() {
        return 0;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fullView = inflater.inflate(R.layout.fragment_toolbar, null);

        FrameLayout activityContainer = fullView.findViewById(R.id.content_container);
        FrameLayout toolbarContainer = fullView.findViewById(R.id.toolbar_container);

        this.view = fullView;
        if (createToolbar() != 0) {
            setToolbar(inflater, toolbarContainer, false);
        }

        if (getLayout() != 0) {
            setContent(activityContainer);
        }

        init();
        return fullView;
    }

    private void setToolbar(LayoutInflater inflater, FrameLayout container, boolean attachToRoot) {

        inflater.inflate(createToolbar(), container, attachToRoot);
        toolbar = view.findViewById(R.id.toolbar);
        toolbar.setVisibility(View.VISIBLE);

        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
    }

    private void setContent(FrameLayout container){
        getLayoutInflater().inflate(getLayout(), container, true);
    }


    @Override
    public void init() {

    }
}
