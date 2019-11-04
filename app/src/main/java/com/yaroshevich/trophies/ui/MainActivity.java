package com.yaroshevich.trophies.ui;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import com.yaroshevich.trophies.R;
import com.yaroshevich.trophies.navigation.AppNavigator;
import com.yaroshevich.trophies.ui.base.BaseFragment;

public class MainActivity extends AppCompatActivity implements BaseFragment.ToolbarCreator {

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



}
