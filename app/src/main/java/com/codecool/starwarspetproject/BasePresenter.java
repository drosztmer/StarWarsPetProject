package com.codecool.starwarspetproject;

import android.view.View;

public interface BasePresenter {
    void onAttach(View view);
    void onDetach();
}
