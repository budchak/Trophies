package com.yaroshevich.trophies.ui.riverList;

import androidx.fragment.app.Fragment;

import com.yaroshevich.trophies.ui.base.fragment.ToolbarFragment;

public class RiverListWithToolbarFragment extends ToolbarFragment {


    @Override
    protected Fragment getFragment() {
        return new RiverListFragment();
    }
}
