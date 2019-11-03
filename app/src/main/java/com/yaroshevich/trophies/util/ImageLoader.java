package com.yaroshevich.trophies.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.yaroshevich.trophies.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;

public class ImageLoader {

    private Picasso picasso;
    private Context context;

    public ImageLoader(Context context) {
        this.context = context;
        picasso = new Picasso.Builder(context).listener(new Picasso.Listener() {
            @Override
            public void onImageLoadFailed(Picasso picasso, Uri uri, Exception exception) {
                // Do something here
            }
        }).build();
    }

    public void loadImage(Uri src, ImageView imageView) {


        picasso.load(src).resize(200, 170).placeholder(R.drawable.progress_animation).into(imageView, new Callback() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onError(Exception e) {

            }
        });

    }

    public void loadImage(String src, ImageView imageView) {
        File file = null;


        AssetManager mg = context.getResources().getAssets();

        InputStream is = null;
        try {
            file = new File(src);
            is = mg.open(src);
            Log.e(this.getClass().toString(), "из assets");
            picasso.load("file:///android_asset/" + src)
                    .into(imageView, new Callback() {
                        @Override
                        public void onSuccess() {
                            // Do something
                            Log.e("Image loader", "Success image loading...");

                        }

                        @Override
                        public void onError(Exception e) {
                            Log.e("Image loader", "failed image loading...");
                        }


                    });

        } catch (IOException ex) {
            Log.e(this.getClass().toString(), "из файла" + src);
            picasso.load(Uri.fromFile(file))
                    .resize(200, 170)
                    .into(imageView, new Callback() {
                        @Override
                        public void onSuccess() {
                            // Do something
                            Log.e("xcvb", "Success image loading...");

                        }

                        @Override
                        public void onError(Exception e) {
                            Log.e("xcvb", "failed image loading...");
                        }


                    });

        } finally {
            if (is != null) {
                try {
                    is.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }


    public void saveFile(String url, String dst){
        File source = new File(url);
        File destination = new File(dst);

        FileChannel src = null;
        FileChannel dest = null;
        try {
            if (!source.exists()) {

                Log.e("ImageSaver", " плохо");
            }

            src = new FileInputStream(source).getChannel();
            dest = new FileOutputStream(destination).getChannel();
            dest.transferFrom(src, 0, src.size());
            src.close();
            dest.close();
        } catch (
                IOException ex) {
            Log.e("ImageSaver", "error save");
            Log.e("ImageSaver ", ex.getMessage());
            ex.printStackTrace();
        }finally {
            if (src != null){
                try {
                    src.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (dest != null){
                try {
                    dest.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void saveFile(Uri sourceUri, File destination) {
        FileChannel src = null;
        FileChannel dst = null;
        try {
            File source = new File(getStringFromUri(context, sourceUri));
            if (!source.exists()) {

                Log.e("ImageSaver", " плохо");
            }

            src = new FileInputStream(source).getChannel();
            dst = new FileOutputStream(destination).getChannel();
            dst.transferFrom(src, 0, src.size());
            src.close();
            dst.close();
        } catch (
                IOException ex) {
            Log.e("ImageSaver", "error save");
            Log.e("ImageSaver ", ex.getMessage());
            ex.printStackTrace();
        }finally {
            if (src != null){
                try {
                    src.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (dst != null){
                try {
                    dst.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String createFileName(int id, String name) {
        File mydir = context.getDir("image", Context.MODE_PRIVATE); //Creating an internal dir;
        if (!mydir.exists()) {
            mydir.mkdirs();
        }
        File file = new File(mydir, name + id + ".jpg");

        return file.getAbsolutePath();
    }

    public String getStringFromUri(Context context, Uri contentUri) {
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = context.getContentResolver().query(contentUri, proj, null, null, null);
        int column_index
                = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }
}

