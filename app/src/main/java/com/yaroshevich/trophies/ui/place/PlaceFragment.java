package com.yaroshevich.trophies.ui.place;

import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.yaroshevich.trophies.R;
import com.yaroshevich.trophies.ui.base.BaseFragment;

public class PlaceFragment extends BaseFragment {

    private ViewPager viewPager;

    private PlaceTabAdapter tabAdapter;

    private TabLayout tabLayout;

    @Override
    public int getLayout() {
        return R.layout.fragment_place;
    }

    @Override
    public void init() {

        tabAdapter = new PlaceTabAdapter(getActivity().getSupportFragmentManager(), 1);
        viewPager = view.findViewById(R.id.fish_info_view_pager);
        viewPager.setAdapter(tabAdapter);
        tabLayout = view.findViewById(R.id.fish_info_tablayout);
        tabLayout.setupWithViewPager(viewPager);
    }
}
