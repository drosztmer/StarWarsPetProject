package com.codecool.starwarspetproject.main;

import android.content.Context;

public class MainPresenter implements MainContract.Presenter {

    MainContract.View view;

    @Override
    public void getCharacters() {

    }

    @Override
    public void onAttach(Context context) {
        view = (MainContract.View) context;
    }

    @Override
    public void onDetach() {
        view = null;
    }
}
