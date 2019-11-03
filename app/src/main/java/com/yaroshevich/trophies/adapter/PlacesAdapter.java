package com.yaroshevich.trophies.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.yaroshevich.trophies.R;
import com.yaroshevich.trophies.ui.base.BaseRecyclerViewAdapter;
import com.yaroshevich.trophies.ui.base.BaseViewHolder;

import java.util.List;

public class PlacesAdapter extends BaseRecyclerViewAdapter<String> {

    public PlacesAdapter(List<String> objects) {
        super(objects);
    }

    @Override
    public BaseViewHolder getViewHolder(ViewGroup group, int viewType) {
        return new DescriptionViewHolder(LayoutInflater.from(group.getContext())
                .inflate(R.layout.item_places, group,false));
    }


    public class DescriptionViewHolder extends BaseViewHolder<String> {

        TextView textView;

        public DescriptionViewHolder(@NonNull View itemView) {
            super(itemView);
            init();
        }

        @Override
        public void bind(String o) {
            textView.setText(o);
        }

        @Override
        public void clear() {

        }

        public void init() {
            textView = view.findViewById(R.id.places_river_name);
        }
    }

}
