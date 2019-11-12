package com.yaroshevich.trophies.ui.preview;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yaroshevich.trophies.App;
import com.yaroshevich.trophies.R;
import com.yaroshevich.trophies.model.interfaces.model.Preview;
import com.yaroshevich.trophies.ui.base.fragment.BaseFragment;
import com.yaroshevich.trophies.ui.emptyDetail.EmptyDetailFragmentArgs;
import com.yaroshevich.trophies.ui.preview.interfaces.PreviewContract;
import com.yaroshevich.trophies.util.ScreenSizeManager;

import java.util.List;

import javax.inject.Inject;

public class PreviewFragment extends BaseFragment implements PreviewContract.View {

    private RecyclerView recyclerView;

    @Inject
    public PreviewAdapter adapter;

    @Inject
    public PreviewPresenter presenter;

    int id;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EmptyDetailFragmentArgs args = getArguments() != null
                ? EmptyDetailFragmentArgs.fromBundle(getArguments())
                : null;

        if (args != null) {
            id = args.getId();
        }

    }


    public int getLayout() {
        return R.layout.fragment_preview;
    }


    public void init() {

        App.getInstance().initPreviewComponent(this).inject(this);
        presenter.attach(this);
        presenter.onCreateView(id);
        recyclerView = view.findViewById(R.id.preview_recycler_view);

        recyclerView.setAdapter(adapter);

        ScreenSizeManager manager = new ScreenSizeManager(getActivity());
        int row;
        if (manager.getDisplayInch() > 6) {
            row = 4;
        } else row = 2;

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), row));
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
    public void showPreview(List<Preview> preview) {
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }


}
