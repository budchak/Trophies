package com.yaroshevich.trophies.ui.riverList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yaroshevich.trophies.R;
import com.yaroshevich.trophies.Repository.PlaceRepository;
import com.yaroshevich.trophies.ui.base.fragment.BaseFragment;
import com.yaroshevich.trophies.ui.base.fragment.ToolbarFragment;

public class RiverListFragment extends BaseFragment {

    private RecyclerView recyclerView;
    private RiverListAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_river_list, container, false);
        this.view = view;
        init();

        return view;
    }

    public void init() {
        recyclerView = view.findViewById(R.id.fish_list_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new RiverListAdapter(new PlaceRepository().getAll());
        recyclerView.setAdapter(adapter);
    }

}
