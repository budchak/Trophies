package com.yaroshevich.trophies.ui.trophyInfo;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yaroshevich.trophies.R;
import com.yaroshevich.trophies.adapter.PlacesAdapter;
import com.yaroshevich.trophies.adapter.TrophyInfoAdapter;
import com.yaroshevich.trophies.ui.base.fragment.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class TrophyDescriptionFragment extends BaseFragment {

    RecyclerView recyclerView;
    TrophyInfoAdapter adapter;


    public int getLayout() {
        return R.layout.fragment_places;
    }


    public void init() {
        List<String> name = new ArrayList<>();
        for (int i = 0; i< 100; i++){
            name.add("sdfghdfgg" + i);
        }
        recyclerView = view.findViewById(R.id.places_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new PlacesAdapter(name));
    }
}
