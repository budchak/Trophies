package com.yaroshevich.trophies.ui;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.yaroshevich.trophies.R;
import com.yaroshevich.trophies.navigation.AppNavigator;
import com.yaroshevich.trophies.ui.base.BaseFragment;
import com.yaroshevich.trophies.util.DPI;

import java.security.PublicKey;

public class MainActivity extends AppCompatActivity implements BaseFragment.ToolbarCreator   {

    public static final int INRERNAL_STORAGE_REQUEST_CODE = 555;

    public static final String MAIN_ACTIVITY_TAG = "MAIN ACTIVITY";

    AppNavigator navigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e(MAIN_ACTIVITY_TAG, "on create");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(MAIN_ACTIVITY_TAG, "on resume");
        navigator = AppNavigator.getInstance(this);

    }

    @Override
    public void createToolbar(Toolbar toolbar) {
       // setSupportActionBar(toolbar);
        Log.e("MAIN ACTIVITY", "toolbar creator");
    }







    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case INRERNAL_STORAGE_REQUEST_CODE:
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                } else {
                    // permission denied
                }
                return;
        }
    }



}
