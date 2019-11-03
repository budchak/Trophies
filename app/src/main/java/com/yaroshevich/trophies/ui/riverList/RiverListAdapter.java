package com.yaroshevich.trophies.ui.riverList;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yaroshevich.trophies.R;
import com.yaroshevich.trophies.model.interfaces.model.Place;
import com.yaroshevich.trophies.navigation.AppNavigator;
import com.yaroshevich.trophies.room.entity.River;
import com.yaroshevich.trophies.ui.base.BaseRecyclerViewAdapter;
import com.yaroshevich.trophies.ui.base.BaseViewHolder;

import java.util.List;

public class RiverListAdapter extends BaseRecyclerViewAdapter<Place> {


    public RiverListAdapter(List<Place> objects) {
        super(objects);
    }

    @Override
    public BaseViewHolder getViewHolder(ViewGroup group, int viewType) {
        View view = LayoutInflater.from(group.getContext()).inflate(R.layout.item_river_rv, group, false);
        return new RiverViewHolder(view);
    }


    public class RiverViewHolder extends BaseViewHolder<Place> {

        public RiverViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AppNavigator.getInstance(null).navigateToRiverScreen();
                }
            });
        }

        @Override
        public void bind(Place o) {
            TextView textView = view.findViewById(R.id.places_name);
            textView.setText(o.getName());
            TextView desc = view.findViewById(R.id.places_description);
            desc.setText(Html.fromHtml("f sdfsdfsdfsd sdfsdfsdfsd sdfsdf sdfsdgcjhvkglhklljhg sdfsdfsdfsd sdfsdfsdfsd sdfsdfsdfsd njxyj yt lkbyysq ntrcn yf cbcntvs android"));
        }

        @Override
        public void clear() {

        }
    }
}
