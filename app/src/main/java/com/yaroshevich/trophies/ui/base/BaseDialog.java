package com.yaroshevich.trophies.ui.base;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.yaroshevich.trophies.R;

public abstract class BaseDialog extends DialogFragment {

    protected AlertDialog.Builder builder;

    protected abstract View createView();
    protected abstract String createTitle();
    protected abstract void onPositiveClick();
    protected abstract void onNegativeClick();


    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        builder = new AlertDialog.Builder(getActivity());

        final View customLayout = createView();
        builder.setView(customLayout)
                .setTitle(createTitle())
                .setPositiveButton("ОК", (dialog, which) -> onPositiveClick())
                .setNegativeButton("Отмена", (dialog, which) -> onNegativeClick());
        return builder.create();
    }


}
