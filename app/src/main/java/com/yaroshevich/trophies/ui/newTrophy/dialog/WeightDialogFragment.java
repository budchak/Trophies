package com.yaroshevich.trophies.ui.newTrophy.dialog;

import android.view.View;
import android.widget.EditText;


import com.yaroshevich.trophies.App;
import com.yaroshevich.trophies.R;
import com.yaroshevich.trophies.model.ObservableTrophy;
import com.yaroshevich.trophies.ui.base.BaseDialog;

public class WeightDialogFragment extends BaseDialog {

    private View view;
    private EditText kg, gr;
    private ObservableTrophy trophy;


    public WeightDialogFragment() {
        trophy = App.getInstance().getListComponent().getTrophy();
    }

    @Override
    protected View createView() {
        view = getActivity().getLayoutInflater().inflate(R.layout.dialog_add_weight, null);
        kg = view.findViewById(R.id.weight_dialog_kg);
        gr = view.findViewById(R.id.weight_dialog_gr);
        return view;
    }

    @Override
    protected String createTitle() {
        return "Укажите вес трофея";
    }

    @Override
    protected void onPositiveClick() {
       setWeight();
    }

    @Override
    protected void onNegativeClick() {

    }

    private void setWeight(){
        String kg, gr, res;
        StringBuilder builder = new StringBuilder();
        kg = this.kg.getText().toString();
        gr = this.gr.getText().toString();
        if (!kg.equals("")){
          builder.append(kg)
                  .append(" кг");
        }
        if (!gr.equals("")){
            builder.append(gr).append(" гр");
        }
        trophy.setWeight(builder.toString());
    }


}
