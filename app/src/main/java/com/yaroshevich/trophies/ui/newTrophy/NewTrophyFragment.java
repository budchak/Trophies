package com.yaroshevich.trophies.ui.newTrophy;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
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
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yaroshevich.trophies.App;
import com.yaroshevich.trophies.R;
import com.yaroshevich.trophies.databinding.FragmentNewTrophyBinding;
import com.yaroshevich.trophies.model.interfaces.model.Trophy;
import com.yaroshevich.trophies.ui.emptyDetail.EmptyDetailFragmentArgs;
import com.yaroshevich.trophies.ui.newTrophy.interfaces.NewTrophyContract;
import com.yaroshevich.trophies.util.ImageLoader;

import java.io.File;

import javax.inject.Inject;

public class NewTrophyFragment extends Fragment implements NewTrophyContract.View {

    public static final int RESULT_PREVIEW = 0;
    public static final int RESULT_RV = 1;

    public static final String LOG_NEW_TROPHY = "NEW TROPHY";
    private static final int REQUEST_PERMISSIONS_CODE_WRITE_STORAGE = 555;

    private FragmentNewTrophyBinding binding;

    @Inject
    public NewTrophyPresenter presenter;

    @Inject
    public NewTrophyAdapter adapter;

    @Inject
    public ImageLoader imageLoader;

    private int id;


    private Uri selectedImage;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

        App.getInstance()
                .initNewTrophyComponent(this)
                .inject(this);


        EmptyDetailFragmentArgs args = getArguments() != null
                ? EmptyDetailFragmentArgs.fromBundle(getArguments())
                : null ;

        if (args != null) {
            id = args.getId();

        }

        presenter.attach(this);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_new_trophy, container, false);
        if (((AppCompatActivity) getActivity()).getSupportActionBar() != null) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().hide();

        }
        ((AppCompatActivity) getActivity()).setSupportActionBar(binding.toolbar3);
        presenter.loadTrophy(id);
        init(binding.getRoot());

        return binding.getRoot();
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
        binding.trophyTitleImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onTitleViewClick();
            }
        });

        binding.newTrophyWeightImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onClickEvent(NewTrophyCLickEvent.WEIGHT_CLICK);
            }
        });

        binding.newTrophyPlaceImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onClickEvent(NewTrophyCLickEvent.PLACE_CLICK);
            }
        });

        binding.newTrophyDateImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onClickEvent(NewTrophyCLickEvent.DATE_CLICK);
            }
        });

        binding.newTrophyRv.setLayoutManager(new LinearLayoutManager(view.getContext(), RecyclerView.HORIZONTAL, false));
        binding.newTrophyRv.setAdapter(adapter);

    }

    @Override
    public void getImage() {
        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
           requestPermissions( new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
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
        binding.toolbar3.setTitle(trophy.getName());
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
    public void setTitleImage(Uri titleImage) {
        imageLoader.loadImage(titleImage, binding.trophyTitleImage);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }


    @Override
    public void onResume() {
        super.onResume();
        //binding.newTrophyWeight.setText(trophy.getWeight());
       // Toast.makeText(getContext(), "onResume", Toast.LENGTH_SHORT).show();
       // presenter.loadTrophy(id);
    }




}
