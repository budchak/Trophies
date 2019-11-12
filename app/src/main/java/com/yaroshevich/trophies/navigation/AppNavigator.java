package com.yaroshevich.trophies.navigation;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.yaroshevich.trophies.R;
import com.yaroshevich.trophies.ui.emptyDetail.EmptyDetailFragmentDirections;
import com.yaroshevich.trophies.ui.newTrophy.NewTrophyFragmentDirections;
import com.yaroshevich.trophies.ui.preview.PreviewFragmentDirections;
import com.yaroshevich.trophies.ui.riverTrophiew.RiverTrophiesFragmentDirections;

public class AppNavigator {


    private static AppNavigator navigator;
    private static NavController controller;


    private AppNavigator(Context context) {
        controller = Navigation.findNavController((Activity) context, R.id.nav_host_fragment);
    }

    public static AppNavigator getInstance(Context context) {
        if (context == null) {
            return navigator;
        } else {
            navigator = new AppNavigator(context);
            return navigator;
        }
    }

    public void onBackPressed(){
        if (controller !=null){
            switch (controller.getCurrentDestination().getId()){

            }
        }else {
            Log.e("APP NAVIGATOR", "controller is null");
        }

    }


    public void navigateToDetailScreen(int id) {
        PreviewFragmentDirections.ActionDetail action = PreviewFragmentDirections.actionDetail();
        action.setId(id);
        controller.navigate(action);
    }

    public void navigateToRiverInfoScreen() {

        controller.navigate(R.id.riverListWithToolbarFragment);
    }

    public void navigateToPreviewScreen(int id) {

        if (controller.getCurrentDestination().getId() == R.id.newTrophyFragment) {
            NewTrophyFragmentDirections.ActionNewTrophyFragmentToPreviewFragment action = NewTrophyFragmentDirections.actionNewTrophyFragmentToPreviewFragment();
            action.setId(id);
            controller.navigate(action);
        } else {

            RiverTrophiesFragmentDirections.ActionTrophy action = RiverTrophiesFragmentDirections.actionTrophy();
            action.setId(id);
            controller.navigate(action);
        }
    }

    public void navigateToEmptyDetailScreen(int id) {
        PreviewFragmentDirections.ActionToEmptyScreen action = PreviewFragmentDirections.actionToEmptyScreen();
        action.setId(id);
        controller.navigate(action);
    }

    public void navigateToFishInfoScreen() {
        controller.navigate(R.id.trophyInfoFragment);
    }

    public void navigateToNewTrophyScreen(int id) {
        EmptyDetailFragmentDirections.ActionAddNewTrophy action = EmptyDetailFragmentDirections.actionAddNewTrophy(id);
        action.setId(id);
        controller.navigate(action);
    }


    public void navigate() {
        controller.navigate(R.id.newTrophyFragment);
    }


    public void navigateWeightDialog() {
        controller.navigate(R.id.weightDialogFragment);
    }

    public void navigatePlaceDialog() {
        controller.navigate(R.id.placeDialogFragment);
    }

    public void navigateDateDialog() {
        controller.navigate(R.id.dateDialogFragment);
    }

    public void navigateToRiverList() {
        controller.navigate(R.id.riverListFragment);
    }

    public void navigateToRiverScreen() {
        controller.navigate(R.id.placeFragment);
    }


}
