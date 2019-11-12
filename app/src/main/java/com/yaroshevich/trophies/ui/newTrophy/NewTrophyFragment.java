package com.yaroshevich.trophies.ui.newTrophy;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.palette.graphics.Palette;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yaroshevich.trophies.App;
import com.yaroshevich.trophies.R;
import com.yaroshevich.trophies.databinding.FragmentNewTrophyBinding;
import com.yaroshevich.trophies.model.interfaces.model.Trophy;
import com.yaroshevich.trophies.ui.ActionBarModule;
import com.yaroshevich.trophies.ui.MainActivity;
import com.yaroshevich.trophies.ui.emptyDetail.EmptyDetailFragmentArgs;
import com.yaroshevich.trophies.ui.newTrophy.interfaces.NewTrophyContract;
import com.yaroshevich.trophies.ui.newTrophy.interfaces.RecyclerViewContract;
import com.yaroshevich.trophies.util.ImageLoader;

import java.io.File;
import java.io.IOException;

import javax.inject.Inject;

public class NewTrophyFragment extends Fragment implements NewTrophyContract.View, RecyclerViewContract.View {

    public static final int RESULT_PREVIEW = 0;
    public static final int RESULT_RV = 1;

    private static final int REQUEST_PERMISSIONS_CODE_WRITE_STORAGE = 555;

    private FragmentNewTrophyBinding binding;

    @Inject
    public NewTrophyPresenter presenter;

    @Inject
    public NewTrophyAdapter adapter;

    @Inject
    public ImageLoader imageLoader;



    public ActionBar supportActionBar;

    public ActionBarModule actionBarModule;

    private int id;


    private Uri selectedImage;
    private int color;
    private GradientDrawable gd;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        actionBarModule = (ActionBarModule)context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

        App.getInstance().initNewTrophyComponent(this).inject(this);

        EmptyDetailFragmentArgs args = getArguments() != null ? EmptyDetailFragmentArgs.fromBundle(getArguments()) : null;

        if (args != null) {
            id = args.getId();
        }

        presenter.attach(this);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_new_trophy, container, false);

        presenter.loadTrophy(id);
        init(binding.getRoot());
        setToolbar();
        return binding.getRoot();
    }


    private void setToolbar() {
        actionBarModule.set(binding.toolbar);
    }



    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.new_trophy_menu, menu);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_add) {
            presenter.onClickEvent(NewTrophyCLickEvent.APPLY_CLICK);

            App.getInstance().destroyListComponent();
        }
        return true;
    }

    private void init(View view) {
        binding.fishInfoCollapsingToolbar.setTitleEnabled(false);
        color = ((MainActivity) getActivity()).getStatusBarColor();

        ((MainActivity) getActivity()).setStatusBarColor(getResources().getColor(R.color.colorPrimaryTransparent));

        binding.newTrophyWeightImageView.setOnClickListener(v -> presenter.onClickEvent(NewTrophyCLickEvent.WEIGHT_CLICK));

        binding.newTrophyPlaceImageView.setOnClickListener(v -> presenter.onClickEvent(NewTrophyCLickEvent.PLACE_CLICK));

        binding.newTrophyDateImageView.setOnClickListener(v -> presenter.onClickEvent(NewTrophyCLickEvent.DATE_CLICK));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, true);
        linearLayoutManager.setStackFromEnd(true);

        binding.newTrophyRv.setLayoutManager(linearLayoutManager);
        binding.newTrophyRv.setAdapter(adapter);
        DividerItemDecoration decoration = new DividerItemDecoration(binding.newTrophyRv.getContext(), RecyclerView.HORIZONTAL);
        binding.newTrophyRv.addItemDecoration(decoration);

    }

    @Override
    public void getImage() {
        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    REQUEST_PERMISSIONS_CODE_WRITE_STORAGE
            );
            Log.e("NewTrophy", "denied");
        } else {
            Log.e("NewTrophy", "грантед");
            Intent galleryIntent = new Intent(
                    Intent.ACTION_PICK,
                    android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(galleryIntent, RESULT_RV);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_PERMISSIONS_CODE_WRITE_STORAGE) {
            if (permissions[0].equals(Manifest.permission.READ_EXTERNAL_STORAGE)
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Intent galleryIntent = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent, RESULT_RV);
            }
        }
    }

    @Override
    public void getTitleImage() {
        Intent galleryIntent = new Intent(
                Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(galleryIntent, RESULT_PREVIEW);
    }

    void setWeight(String weight) {
        binding.newTrophyWeight.setText(weight);
    }

    @Override
    public void update(Trophy trophy) {
        if (trophy.getPreviewSrc() != null) {

            imageLoader.loadImage(trophy.getPreviewSrc(), binding.trophyTitleImage);

        }
        binding.toolbar.setTitle(trophy.getName());
        binding.setTrophy(trophy);
        binding.invalidateAll();
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (data != null) {
            switch (requestCode) {
                case RESULT_RV:
                    //data.getData returns the content URI for the selected Image
                    selectedImage = data.getData();
                    presenter.onImageTake(selectedImage);
                    break;
                case RESULT_PREVIEW:
                    Uri Image = data.getData();
                    selectedImage = Image;
                    presenter.onTitleImageTake(Image);
                    break;
            }
        }
    }

    @Override
    public void setTitleImage(String titleImage) {
        Bitmap bitmap = null;
        File file = new File(titleImage);
        Uri myUri = null;
        if (file.exists()) {
            myUri = Uri.fromFile(file);
        }

        try {
            bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), myUri);
            createBackgroundColor(bitmap);
        } catch (IOException e) {
            e.printStackTrace();
        }

        imageLoader.loadImage(titleImage, binding.trophyTitleImage);

    }


    @Override
    public void onPause() {
        super.onPause();
        ((MainActivity) getActivity()).setStatusBarColor(color);
    }

    public void createBackgroundColor(Bitmap bitmap) {
        int pix = bitmap.getPixel(0, bitmap.getHeight() - 1);
        Log.e("pix", " " + pix);
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                int defaultValue = 0x000000;
                int vibrant = palette.getVibrantColor(defaultValue);
                int vibrantLight = palette.getLightVibrantColor(defaultValue);
                int vibrantDark = palette.getDarkVibrantColor(defaultValue);
                int muted = palette.getMutedColor(defaultValue);
                int mutedLight = palette.getLightMutedColor(defaultValue);
                int mutedDark = palette.getDarkMutedColor(defaultValue);
                int[] colors = {pix, getActivity().getResources().getColor(R.color.blueThemeToolbar)};
                gd = new GradientDrawable(
                        GradientDrawable.Orientation.TOP_BOTTOM, colors);

                int[] colors2 = {Color.parseColor("#00000000")
                        , Color.parseColor("#00000000")
                        , pix};
                GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, colors2);
                binding.coordinator.setBackground(gd);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    binding.trophyTitleImage.setForeground(gradientDrawable);
                }
                //binding.view.setBackground(gradientDrawable);

            }
        });

    }

    @Override
    public void add(int pos) {

    }

    @Override
    public void remove(int pos) {

    }

    @Override
    public void clear() {

    }

    @Override
    public void update() {

    }
}
