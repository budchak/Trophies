package com.yaroshevich.trophies.ui.detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.yaroshevich.trophies.App;
import com.yaroshevich.trophies.R;
import com.yaroshevich.trophies.Repository.TrophyRepository;
import com.yaroshevich.trophies.model.interfaces.model.Detail;
import com.yaroshevich.trophies.model.interfaces.model.Trophy;

public class DetailFragment extends Fragment implements DetailContract.View {

    private ImageView imageView;
    private TextView weight, place;
    private TrophyRepository repository;
    private Trophy trophy;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int arg2Value;
        DetailFragmentArgs args = DetailFragmentArgs.fromBundle(getArguments());
        arg2Value = args.getId();

        repository = new TrophyRepository();
        trophy = repository.getById(arg2Value);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view;

        view = inflater.inflate(R.layout.fragment_detail, container, false);
        //  getActivity().setTitle(detail.getName());

        imageView = view.findViewById(R.id.detail_image);
        weight = view.findViewById(R.id.detail_weight);
        place = view.findViewById(R.id.detail_place);
        String s = trophy.getSrc().get(0);
        App.getComponent().getImageLoader().loadImage(s, imageView);
        weight.setText(trophy.getWeight());


        return view;
    }


    @Override
    public void showDetail(Detail detail) {

    }
}
