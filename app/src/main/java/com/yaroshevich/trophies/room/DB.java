package com.yaroshevich.trophies.room;

import android.content.Context;
import android.util.Log;

import androidx.room.Room;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DB {
    private static final String TAG = DB.class.getSimpleName();

    private FishInfoDatabase mAppDataBase;
    private Context context;


    public DB(Context context) {
        //call method that check if database not exists and copy prepopulated file from assets
        this.context = context;
        copyAttachedDatabase(context, "fishInfoDatabase");
        mAppDataBase = Room.databaseBuilder(context,
                FishInfoDatabase.class, "fishInfoDatabase").allowMainThreadQueries().build();
    }

    public FishInfoDatabase getDB() {
        return mAppDataBase;
    }


    private void copyAttachedDatabase(Context context, String databaseName) {
        final File dbPath = context.getDatabasePath(databaseName);

        // If the database already exists, return
        if (dbPath.exists()) {
            Log.e("SDf", "гимно");
          //  return;
        }

        // Make sure we have a path to the file
        dbPath.getParentFile().mkdirs();

        // Try to copy database file
        try {
            final InputStream inputStream = context.getAssets().open("databases/fishInfo.db");
            final OutputStream output = new FileOutputStream(dbPath);

            byte[] buffer = new byte[8192];
            int length;

            while ((length = inputStream.read(buffer, 0, 8192)) > 0) {
                output.write(buffer, 0, length);
            }

            output.flush();
            output.close();
            inputStream.close();
        }
        catch (IOException e) {
            Log.d(TAG, "Failed to open file", e);
            e.printStackTrace();
        }
    }

}