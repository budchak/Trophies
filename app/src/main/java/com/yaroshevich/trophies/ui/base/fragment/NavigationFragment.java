package com.yaroshevich.trophies.ui.base.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.yaroshevich.trophies.R;
import com.yaroshevich.trophies.ui.base.fragment.BaseFragment;


public abstract class NavigationFragment extends BaseFragment implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;

    public abstract int getLayout();

    protected  int getHeader(){
        return 0;
    }

    protected int getMenuLayout(){
        return 0;
    }




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fullView = inflater.inflate(R.layout.fragment_navigation, null);

        FrameLayout activityContainer = fullView.findViewById(R.id.navigation_context);
        getLayoutInflater().inflate(getLayout(), activityContainer, true);
        //super.onCreateView(inflater, container, savedInstanceState);
        this.view = fullView;
        toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        DrawerLayout drawer = fullView.findViewById(R.id.drawer_layout);
        NavigationView navigationView = fullView.findViewById(R.id.nav_view);
        if (getHeader() != 0){
            navigationView.inflateHeaderView(getHeader());
        }

        if (getMenuLayout() != 0){
            navigationView.inflateMenu(getMenuLayout());
        }


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                getActivity(), drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        init();
        return fullView;
    }

    protected abstract void init();


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }
}
