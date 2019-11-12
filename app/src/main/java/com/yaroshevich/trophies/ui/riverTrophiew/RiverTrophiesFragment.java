package com.yaroshevich.trophies.ui.riverTrophiew;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yaroshevich.trophies.R;
import com.yaroshevich.trophies.Repository.PlaceTrophyRepository;
import com.yaroshevich.trophies.ui.base.fragment.BaseFragment;
import com.yaroshevich.trophies.ui.riverTrophiew.decorator.BorderDecorator;

public class RiverTrophiesFragment extends BaseFragment {

    private RecyclerView recyclerView;
    private BorderDecorator borderDecorator;


    @Override
    public void setTAG(String tag) {
        super.setTAG("River Trophy Fragment");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        borderDecorator = new BorderDecorator();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.fragment_recycler_view, container,false);
        init();
        return view;
    }

    public void init() {
        recyclerView = view.findViewById(R.id.recycler_view);

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.setAdapter(new RVAdapter(new PlaceTrophyRepository().getAll()));
        recyclerView.addItemDecoration(borderDecorator);

    }


}
