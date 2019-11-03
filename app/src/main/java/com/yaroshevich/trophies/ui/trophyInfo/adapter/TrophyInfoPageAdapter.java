package com.yaroshevich.trophies.ui.trophyInfo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.yaroshevich.trophies.R;
import com.yaroshevich.trophies.ui.preview.PreviewFragment;
import com.yaroshevich.trophies.ui.trophyInfo.TrophyDescriptionFragment;

import java.util.List;

public class   TrophyInfoPageAdapter extends FragmentPagerAdapter {


    public TrophyInfoPageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    // Returns the fragment_place_description to display for that page
    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                return new PreviewFragment();

            case 1:
                return new TrophyDescriptionFragment();


            case 2:
                return new PreviewFragment();


            default:
                return null;
        }
    }

    // Will be displayed as the tab's label
    @Override
    public CharSequence getPageTitle(int position) {
        switch(position) {
            case 0:
                return "Fragment 1 title";

            case 1:
                return "Fragment 2 title";

            case 2:
                return "Fragment 3 title";

            default:
                return null;
        }
    }

    // Returns total number of pages
    @Override
    public int getCount() {
        return 3;
    }

}

