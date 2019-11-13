package com.yaroshevich.trophies.ui;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.yaroshevich.trophies.App;
import com.yaroshevich.trophies.R;
import com.yaroshevich.trophies.navigation.AppNavigator;

public class MainActivity extends AppCompatActivity implements ActionBarModule {


    public static final String MAIN_ACTIVITY_TAG = "MAIN ACTIVITY";

    private Toolbar toolbar;
    AppNavigator navigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e(MAIN_ACTIVITY_TAG, "on create");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        App.getInstance().initMainActivityComponent(this).inject(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(MAIN_ACTIVITY_TAG, "on resume");
        navigator = AppNavigator.getInstance(this);

    }


    public void setStatusBarColor(int color) {
        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(color);
    }

    public int getStatusBarColor() {
        Window window = getWindow();
        return window.getStatusBarColor();
    }

    @Override
    public Toolbar get() {
        return toolbar;
    }

    @Override
    public void set(Toolbar toolbar) {
        setSupportActionBar(toolbar);
    }


}
