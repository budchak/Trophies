package com.yaroshevich.trophies.ui.preview;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yaroshevich.trophies.App;
import com.yaroshevich.trophies.R;
import com.yaroshevich.trophies.model.interfaces.model.Preview;
import com.yaroshevich.trophies.ui.base.fragment.BaseFragment;
import com.yaroshevich.trophies.ui.base.fragment.ToolbarFragment;
import com.yaroshevich.trophies.ui.emptyDetail.EmptyDetailFragmentArgs;
import com.yaroshevich.trophies.ui.preview.interfaces.PreviewContract;
import com.yaroshevich.trophies.ui.riverTrophiew.decorator.BorderDecorator;
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

    public PreviewFragment() {
    }

    public PreviewFragment(int id) {
        this.id = id;
    }

    @Override
    public void setTAG(String tag) {
        super.setTAG("Preview Fragment");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.fragment_preview, container, false);
        init();
        return view;
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
        recyclerView.addItemDecoration(new BorderDecorator());

    }


    @Override
    public void showPreview(List<Preview> preview) {
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }


}
