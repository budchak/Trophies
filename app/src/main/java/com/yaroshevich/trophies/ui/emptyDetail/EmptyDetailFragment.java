package com.yaroshevich.trophies.ui.emptyDetail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.yaroshevich.trophies.App;
import com.yaroshevich.trophies.R;

public class EmptyDetailFragment extends Fragment implements EmptyDetailContract.View {

    EmptyDetailPresenter previewPresenter;
    String s;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        int arg2Value;
        EmptyDetailFragmentArgs args = EmptyDetailFragmentArgs.fromBundle(getArguments());
        arg2Value = args.getId();

        s = App.getComponent().getDatabase().TrophyDao().getById(arg2Value).name;

        previewPresenter = new EmptyDetailPresenter(arg2Value);
        previewPresenter.attach(this);


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_empty, container, false);
        Toolbar toolbar = view.findViewById(R.id.detail_toolbar);
        toolbar.setTitle(s);
        if (((AppCompatActivity) getActivity()).getSupportActionBar() != null){
            ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        }

        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        FloatingActionButton floatingActionButton = view.findViewById(R.id.empty_detail_fb);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                previewPresenter.onFloatingButtonCLick();
            }
        });

        return view;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.detail_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_search) {
            previewPresenter.onInfoClick();
        }
        return true;
    }
}
