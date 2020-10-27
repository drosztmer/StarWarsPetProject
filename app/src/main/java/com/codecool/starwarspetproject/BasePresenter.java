package com.codecool.starwarspetproject;

import android.content.Context;

public interface BasePresenter {
    void onAttach(Context context);
    void onDetach();
}
