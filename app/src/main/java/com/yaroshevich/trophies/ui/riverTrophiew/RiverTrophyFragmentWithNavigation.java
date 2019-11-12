package com.yaroshevich.trophies.ui.riverTrophiew;

import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;

import com.yaroshevich.trophies.R;
import com.yaroshevich.trophies.navigation.AppNavigator;
import com.yaroshevich.trophies.ui.base.fragment.NavigationFragment;

public class RiverTrophyFragmentWithNavigation extends NavigationFragment {

    @Override
    protected Fragment getFragment() {
        return new RiverTrophiesFragment();
    }

    @Override
    protected int getMenuLayout() {
        return R.menu.activity_navigation_drawer;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        int id = menuItem.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
            AppNavigator.getInstance(null).navigateToRiverInfoScreen();

        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = view.findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }
}
