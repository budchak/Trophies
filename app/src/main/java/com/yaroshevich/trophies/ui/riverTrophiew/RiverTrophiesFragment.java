package com.yaroshevich.trophies.ui.riverTrophiew;

import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yaroshevich.trophies.App;
import com.yaroshevich.trophies.R;
import com.yaroshevich.trophies.Repository.PlaceRepository;
import com.yaroshevich.trophies.Repository.PlaceTrophyRepository;
import com.yaroshevich.trophies.ui.navigation.NavigationFragment;

public class RiverTrophiesFragment extends NavigationFragment {

    private RecyclerView recyclerView;

    @Override
    public int getLayout() {
        return R.layout.fragment_recycler_view;
    }

    @Override
    public void init() {
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.setAdapter(new RVAdapter(new PlaceTrophyRepository().getAll()));
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                GridLayoutManager.LayoutParams params = (GridLayoutManager.LayoutParams) view.getLayoutParams();

                if (params.getSpanIndex() % 2 == 0) {

                    outRect.top = 20;
                    outRect.right = 10;
                    outRect.left = 20;
                } else {
                    outRect.top = 20;
                    outRect.right = 20;
                    outRect.left = 10;
                }
            }

        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }
}
