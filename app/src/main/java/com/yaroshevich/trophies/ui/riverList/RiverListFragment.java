package com.yaroshevich.trophies.ui.riverList;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.yaroshevich.trophies.R;
import com.yaroshevich.trophies.Repository.PlaceRepository;
import com.yaroshevich.trophies.ui.base.BaseFragment;
import com.yaroshevich.trophies.ui.base.ToolbarFragment;
import com.yaroshevich.trophies.ui.place.PlaceTabAdapter;

public class RiverListFragment extends ToolbarFragment {

    private RecyclerView recyclerView;
    private RiverListAdapter adapter;


    @Override
    public int createToolbar() {
        return R.layout.toolbar;
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_river_list;
    }

    @Override
    public void init() {
        recyclerView = view.findViewById(R.id.fish_list_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new RiverListAdapter(new PlaceRepository().getAll());
        recyclerView.setAdapter(adapter);
    }
}
