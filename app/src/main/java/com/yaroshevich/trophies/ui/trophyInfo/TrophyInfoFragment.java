package com.yaroshevich.trophies.ui.trophyInfo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import com.yaroshevich.trophies.R;
import com.yaroshevich.trophies.ui.trophyInfo.adapter.TrophyInfoAdapter;
import com.yaroshevich.trophies.ui.trophyInfo.adapter.TrophyInfoPageAdapter;
import com.yaroshevich.trophies.ui.trophyInfo.interfaces.TrophyInfoContract;

public class TrophyInfoFragment extends Fragment implements TrophyInfoContract.View {

    private RecyclerView recyclerView;
    private TrophyInfoPresenter presenter;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new TrophyInfoPresenter();
        presenter.attach(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getActivity(), R.style.transparent);
        inflater.cloneInContext(contextThemeWrapper);
        View view = inflater.inflate(R.layout.fragment_fish_info, container, false);
        recyclerView = view.findViewById(R.id.fish_info_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        TrophyInfoAdapter adapter = new TrophyInfoAdapter(presenter);

        recyclerView.setAdapter(adapter);

        tabLayout = view.findViewById(R.id.fish_info_tablayout);
        viewPager = view.findViewById(R.id.fish_info_view_pager);
        viewPager.setAdapter(new TrophyInfoPageAdapter(getActivity().getSupportFragmentManager(), 1));
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
