package com.yaroshevich.trophies.ui.base;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public abstract class BaseRecyclerViewAdapter<O> extends RecyclerView.Adapter<BaseViewHolder> {

    List<O> list;

    public BaseRecyclerViewAdapter(List<O> objects) {
        list = objects;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return getViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public abstract BaseViewHolder getViewHolder(ViewGroup group, int viewType);


}
