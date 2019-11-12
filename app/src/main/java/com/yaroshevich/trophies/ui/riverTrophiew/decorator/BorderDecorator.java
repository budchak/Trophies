package com.yaroshevich.trophies.ui.riverTrophiew.decorator;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class BorderDecorator extends RecyclerView.ItemDecoration {

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        GridLayoutManager.LayoutParams params = (GridLayoutManager.LayoutParams) view.getLayoutParams();

        if (params.getSpanIndex() % 2 == 0) {

            outRect.top = 50;
            outRect.right = 25;
            outRect.left = 50;
        } else {
            outRect.top = 50;
            outRect.right = 50;
            outRect.left = 25;
        }
    }
}
