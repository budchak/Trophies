package com.yaroshevich.trophies.util;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;

public class ScreenSizeManager {

    private Context context;

    public ScreenSizeManager(Context context) {
        this.context = context;
    }

    public DPI getDPI() {
        float dpi = context.getResources().getDisplayMetrics().density;
        if (dpi <= 0.5) return DPI.LDPI;
        if (dpi <= 1) return DPI.MDPI;
        if (dpi <= 1.5) return DPI.HDPI;
        if (dpi <= 2) return DPI.XHDPI;
        if (dpi <= 3) return DPI.XXHDPI;
        if (dpi <= 4) return DPI.XXXHDPI;

        return null;

    }

    public double getDisplayInch() {
        DisplayMetrics dm = new DisplayMetrics();
        ((Activity)context).getWindowManager().getDefaultDisplay().getMetrics(dm);
        double x = Math.pow(dm.widthPixels, 2);
        double y = Math.pow(dm.heightPixels, 2);
        double screenInches = Math.sqrt(x + y) / dm.densityDpi;
        Log.d("debug", "Screen inches : " + screenInches);
        return screenInches;
    }
}
