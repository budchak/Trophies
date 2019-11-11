package com.yaroshevich.trophies.ui.newTrophy.interfaces;

public interface RecyclerViewContract {

    interface View {
        void add(int pos);
        void remove(int pos);
        void clear();
        void update();
    }

    interface Presenter {

        int getItemCount();

        void onCreateView(int id);

        void onBindView(int id, BindItem bindItem);

        void onItemCLick(BindItem item);
    }


}

