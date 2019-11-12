package com.yaroshevich.trophies.ui.riverTrophiew;

import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;
import com.yaroshevich.trophies.R;
import com.yaroshevich.trophies.Repository.PlaceTrophyRepository;
import com.yaroshevich.trophies.navigation.AppNavigator;
import com.yaroshevich.trophies.ui.base.fragment.NavigationFragment;

public class RiverTrophiesFragment extends NavigationFragment {

    private RecyclerView recyclerView;

    @Override
    public int getLayout() {
        return R.layout.fragment_recycler_view;
    }

    @Override
    protected int getMenuLayout() {
        return R.menu.activity_navigation_drawer;
    }

    @Override
    public void init() {
        NavigationView navigationView = view.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.setAdapter(new RVAdapter(new PlaceTrophyRepository().getAll()));
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                GridLayoutManager.LayoutParams params = (GridLayoutManager.LayoutParams) view.getLayoutParams();

                if (params.getSpanIndex() % 2 == 0) {

                    outRect.top = 50;
                    outRect.right = 25;
                    outRect.left = 50;
                } else {
                    outRect.top = 50;
                    outRect.right = 50;
                    outRect.left = 25;
                }
            }

        });
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
