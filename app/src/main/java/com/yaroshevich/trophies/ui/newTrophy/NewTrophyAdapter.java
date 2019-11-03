package com.yaroshevich.trophies.ui.newTrophy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.yaroshevich.trophies.R;
import com.yaroshevich.trophies.ui.MainActivity;
import com.yaroshevich.trophies.ui.newTrophy.interfaces.BindItem;
import com.yaroshevich.trophies.ui.newTrophy.interfaces.NewTrophyRViewPresenter;


public class NewTrophyAdapter extends RecyclerView.Adapter<NewTrophyAdapter.TrophyViewHolder>{

    private NewTrophyRViewPresenter presenter;
    private Context context;

    public NewTrophyAdapter(NewTrophyRViewPresenter presenter) {
        this.presenter = presenter;
    }

    @NonNull
    @Override
    public TrophyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_new_trophy, parent, false);
        return new TrophyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull TrophyViewHolder holder, int position) {
        presenter.onBindView(position, holder);
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    class TrophyViewHolder extends RecyclerView.ViewHolder implements BindItem {

        private ImageView view;
        private BindItem item;

        public TrophyViewHolder(@NonNull View itemView) {
            super(itemView);
            item = this;
            view = itemView.findViewById(R.id.new_trophy_image_view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    presenter.onItemCLick(item);
                }
            });
        }

        @Override
        public void setImage(Uri uri) {
            loadImageFromURI(uri, view);
        }

        public void loadImageFromURI(Uri src, ImageView imageView) {
            Picasso picasso = new Picasso.Builder(context).listener(new Picasso.Listener() {
                @Override
                public void onImageLoadFailed(Picasso picasso, Uri uri, Exception exception) {
                    // Do something here
                }
            }).build();

            picasso.load(src).resize(150,150).placeholder(R.drawable.progress_animation).into(imageView, new Callback() {
                @Override
                public void onSuccess() {

                }

                @Override
                public void onError(Exception e) {

                }
            });

        }
    }
}
