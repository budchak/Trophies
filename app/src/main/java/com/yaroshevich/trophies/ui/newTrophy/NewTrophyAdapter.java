package com.yaroshevich.trophies.ui.newTrophy;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.yaroshevich.trophies.R;
import com.yaroshevich.trophies.ui.newTrophy.interfaces.BindItem;
import com.yaroshevich.trophies.ui.newTrophy.interfaces.RecyclerViewContract;


public class NewTrophyAdapter extends RecyclerView.Adapter<NewTrophyAdapter.TrophyViewHolder> {

    private RecyclerViewContract.Presenter presenter;
    private Context context;
    private RecyclerView.Adapter adapter;

    public NewTrophyAdapter(RecyclerViewContract.Presenter presenter) {
        this.presenter = presenter;
        adapter = this;
    }

    @NonNull
    @Override
    public TrophyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        switch (viewType) {
            case 0:
                view = inflater.inflate(R.layout.item_new_trophy, parent, false);
                return new TrophyViewHolder1(view);

            case 2:
                view = inflater.inflate(R.layout.item_new_trophy, parent, false);
                return new TrophyViewHolder2(view);

            default:
                view = inflater.inflate(R.layout.item_new_trophy, parent, false);
                return new TrophyViewHolder1(view);

        }


    }


    @Override
    public void onBindViewHolder(@NonNull TrophyViewHolder holder, int position) {
        presenter.onBindView(position, holder);
        Log.e("holder type", holder.getItemType() + " ");
    }

    @Override
    public int getItemViewType(int position) {
        if (position >= getItemCount()) {
            return 0;
        } else return 2;
    }

    @Override
    public int getItemCount() {
        return presenter.getItemCount() + 1;
    }

    abstract class TrophyViewHolder extends RecyclerView.ViewHolder implements BindItem {

        private ImageView view;
        private BindItem item;
        private  int position;


        protected int viewType = 2;

        public TrophyViewHolder(@NonNull View itemView) {
            super(itemView);
            item = this;
            view = itemView.findViewById(R.id.new_trophy_image_view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    presenter.onItemCLick(item);
                    if (viewType != 0){
                        viewType = 0;
                    }

                }
            });
        }

        @Override
        public void setPosition(int position) {
            this.position = position;
        }

        @Override
        public int getCurrentPosition() {
            return position;
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

            picasso.load(src).resize(150, 150).placeholder(R.drawable.progress_animation).into(imageView, new Callback() {
                @Override
                public void onSuccess() {

                }

                @Override
                public void onError(Exception e) {

                }
            });

        }
    }


    class TrophyViewHolder1 extends TrophyViewHolder {

        public TrophyViewHolder1(@NonNull View itemView) {
            super(itemView);
        }

        @Override
        public int getItemType() {
            return viewType;
        }

    }

    class TrophyViewHolder2 extends TrophyViewHolder {

        public TrophyViewHolder2(@NonNull View itemView) {
            super(itemView);
        }

        @Override
        public int getItemType() {
            return viewType;
        }

    }
}
