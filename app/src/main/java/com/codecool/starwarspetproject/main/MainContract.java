package com.codecool.starwarspetproject.main;

import com.codecool.starwarspetproject.BasePresenter;
import com.codecool.starwarspetproject.BaseView;
import com.codecool.starwarspetproject.model.Character;

import java.util.List;

public interface MainContract {

    interface Presenter extends BasePresenter {
        void getCharacters();
    }

    interface View extends BaseView {
        void setValues(List<Character> characters);
    }
}
