package com.yaroshevich.trophies.ui.preview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.yaroshevich.trophies.App;
import com.yaroshevich.trophies.databinding.ItemPreviewVolDvaBinding;
import com.yaroshevich.trophies.model.interfaces.model.Preview;
import com.yaroshevich.trophies.ui.base.BindItem;
import com.yaroshevich.trophies.ui.preview.interfaces.PreviewRVPresenter;
import com.yaroshevich.trophies.util.ImageLoader;

public class PreviewAdapter extends RecyclerView.Adapter<PreviewAdapter.PreviewViewHolder> {

    private PreviewRVPresenter presenter;
    private ImageLoader imageLoader;

    public PreviewAdapter(PreviewRVPresenter presenter) {
        this.presenter = presenter;
        imageLoader = App.getComponent().getImageLoader();
    }

    @NonNull
    @Override
    public PreviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemPreviewVolDvaBinding dvaBinding = ItemPreviewVolDvaBinding.inflate(inflater, parent, false);
        return new PreviewViewHolder(dvaBinding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull PreviewViewHolder holder, int position) {
        presenter.onBindView(position, holder);
    }

    @Override
    public int getItemCount() {
        return presenter.getItemCount();
    }


    class PreviewViewHolder extends RecyclerView.ViewHolder implements BindItem<Preview> {

        ItemPreviewVolDvaBinding binding;

        public PreviewViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }

        public void setEmptyHolder(Preview preview) {
            binding.textView2.setVisibility(View.VISIBLE);
            loadImage(binding.previewImage, preview.getSrc());
            binding.setPreview(preview);


        }

        public void setHolder(Preview preview) {
            binding.textView2.setVisibility(View.GONE);
            loadImage(binding.previewImage, preview.getSrc());
            binding.setPreview(preview);
        }


        @Override
        public void bind(Preview preview) {
            if (preview.isEmpty()) {
                setEmptyHolder(preview);
            } else {
                setHolder(preview);
            }
            View view = binding.previewItem;
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    presenter.onItemCLick(getAdapterPosition());
                }
            });
        }


        public void loadImage(ImageView view, String imageUrl) {
            imageLoader.loadImage(imageUrl, view);
        }

    }
}



