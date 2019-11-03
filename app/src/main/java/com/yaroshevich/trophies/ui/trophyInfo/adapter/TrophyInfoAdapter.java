package com.yaroshevich.trophies.ui.trophyInfo.adapter;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.yaroshevich.trophies.R;
import com.yaroshevich.trophies.ui.trophyInfo.TrophyInfoPresenter;
import com.yaroshevich.trophies.ui.trophyInfo.interfaces.TrophyInfoContent;

public class TrophyInfoAdapter extends RecyclerView.Adapter<TrophyInfoAdapter.TrophyInfoViewHolder> {

    TrophyInfoPresenter presenter;


    public TrophyInfoAdapter(TrophyInfoPresenter presenter) {
        this.presenter = presenter;
    }

    @NonNull
    @Override
    public TrophyInfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fish_info_rv, parent, false);
        return new TrophyInfoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrophyInfoViewHolder holder, int position) {
        Log.e("RV", Integer.toString(position));
        presenter.onBind(position, holder);

    }

    @Override
    public int getItemCount() {
        return presenter.getItemCount();
    }

    class TrophyInfoViewHolder extends RecyclerView.ViewHolder implements TrophyInfoContent {

        private ImageView imageView;
        private TextView textView;

        private Context context;

        public TrophyInfoViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            imageView = itemView.findViewById(R.id.fish_info_image);
            textView = itemView.findViewById(R.id.page_number);
        }

        @Override
        public void setInfo(String string) {
            loadImageFromAsset(string, imageView);
        }

        @Override
        public void setTitle(String string) {
            textView.setText(string);
        }

        public void loadImageFromAsset(String src, ImageView imageView) {
            Picasso picasso = new Picasso.Builder(context).listener(new Picasso.Listener() {
                @Override
                public void onImageLoadFailed(Picasso picasso, Uri uri, Exception exception) {
                    // Do something here
                }
            }).build();

            picasso.load("file:///android_asset/" + src)
                    .into(imageView, new Callback() {
                        @Override
                        public void onSuccess() {
                            // Do something
                            Log.e("xcvb", "Success image loading...");

                        }

                        @Override
                        public void onError(Exception e) {
                            Log.e("xcvb", "failed image loading...");
                        }


                    });

        }

    }
}
