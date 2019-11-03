package com.yaroshevich.trophies.ui.base;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseViewHolder<H> extends RecyclerView.ViewHolder {

    protected View view;

    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
        view = itemView;
    }

    public abstract void bind(H o);

    public abstract void clear();
}