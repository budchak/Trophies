package com.yaroshevich.trophies.ui.preview;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.yaroshevich.trophies.ui.base.fragment.ToolbarFragment;

public class PreviewFragmentWithToolbar extends ToolbarFragment {

    private int id;

    @Override
    public void setTAG(String tag) {
        super.setTAG("Preview Fragment With Toolbar");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PreviewFragmentWithToolbarArgs args = getArguments() != null
                ? PreviewFragmentWithToolbarArgs.fromBundle(getArguments())
                : null;

        if (args != null) {
            id = args.getId();
        }
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    protected Fragment getFragment() {
        return new PreviewFragment(id);
    }


}
