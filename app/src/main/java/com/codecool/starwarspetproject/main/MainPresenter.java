package com.codecool.starwarspetproject.main;

import android.content.Context;
import android.os.AsyncTask;

import org.json.JSONObject;

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

    public class FetchCharactersTask  extends AsyncTask<String, Void, JSONObject> {



        @Override
        protected JSONObject doInBackground(String... strings) {
            return null;
        }
    }
}
