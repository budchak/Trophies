package com.yaroshevich.trophies.adapter;

import android.view.ViewGroup;

import com.yaroshevich.trophies.ui.base.BaseRecyclerViewAdapter;
import com.yaroshevich.trophies.ui.base.BaseViewHolder;


import java.util.List;

public class TrophyInfoAdapter extends BaseRecyclerViewAdapter<String> {


    public TrophyInfoAdapter(List<String> objects) {
        super(objects);
    }

    @Override
    public BaseViewHolder getViewHolder(ViewGroup group, int viewType) {
        return null;
    }
}
