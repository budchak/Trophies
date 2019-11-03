package com.yaroshevich.trophies.ui.riverTrophiew;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.yaroshevich.trophies.App;
import com.yaroshevich.trophies.R;
import com.yaroshevich.trophies.model.interfaces.model.Place;
import com.yaroshevich.trophies.model.interfaces.model.PlaceTrophy;
import com.yaroshevich.trophies.navigation.AppNavigator;
import com.yaroshevich.trophies.ui.base.BaseRecyclerViewAdapter;
import com.yaroshevich.trophies.ui.base.BaseViewHolder;
import com.yaroshevich.trophies.ui.newTrophy.interfaces.NewTrophyContract;
import com.yaroshevich.trophies.util.ImageLoader;

import java.util.List;

public class RVAdapter extends BaseRecyclerViewAdapter<PlaceTrophy> {

    public RVAdapter(List<PlaceTrophy> objects) {
        super(objects);
    }

    @Override
    public BaseViewHolder getViewHolder(ViewGroup group, int viewType) {
        View view = LayoutInflater.from(group.getContext()).inflate(R.layout.item_river_trophy, group,false);
        return new RVViewHolder(view);
    }


    public class RVViewHolder extends BaseViewHolder<PlaceTrophy> {

        private TextView name, count;
        private ImageView imageView;

        @Override
        public void bind(PlaceTrophy o) {
            name = view.findViewById(R.id.name);
            imageView = view.findViewById(R.id.preview_image);
            count = view.findViewById(R.id.count);

            name.setText(o.getName());
            count.setText( o.getValueFound() + " / "+ o.getValueAll());

            App.getComponent().getImageLoader().loadImage(o.getSrc(), imageView);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AppNavigator.getInstance(null).navigateToPreviewScreen(o.getId());
                }
            });

        }

        @Override
        public void clear() {

        }

        public RVViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
