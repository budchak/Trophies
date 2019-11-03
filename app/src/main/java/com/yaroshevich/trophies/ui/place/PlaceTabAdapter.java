package com.yaroshevich.trophies.ui.place;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.yaroshevich.trophies.ui.preview.PreviewFragment;
import com.yaroshevich.trophies.ui.trophyInfo.TrophyDescriptionFragment;

public class PlaceTabAdapter extends FragmentPagerAdapter {


    public PlaceTabAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    // Returns the fragment_place_description to display for that page
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new PlaceDescriptionFragment();

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
        switch (position) {
            case 0:
                return "Описание";

            case 1:
                return "Запреты";

            case 2:
                return "Рыбы";

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
