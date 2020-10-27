package com.codecool.starwarspetproject.main;

import android.content.Context;
import android.os.AsyncTask;

import com.codecool.starwarspetproject.model.Character;
import com.codecool.starwarspetproject.util.Constants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainPresenter implements MainContract.Presenter {

    MainContract.View view;
    private ArrayList<Character> characters = new ArrayList<>();

    @Override
    public void getCharacters() {
        new FetchCharactersTask().execute();
    }

    @Override
    public void onAttach(Context context) {
        view = (MainContract.View) context;
    }

    @Override
    public void onDetach() {
        view = null;
    }

    public class FetchCharactersTask  extends AsyncTask<String, Void, ArrayList<Character>> {

        private OkHttpClient client = new OkHttpClient();
        private boolean error;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            view.showLoading();
            error = false;
        }

        @Override
        protected ArrayList<Character> doInBackground(String... strings) {
            Request request = new Request.Builder().url(Constants.URL).build();
            try {
                Response response = client.newCall(request).execute();
                String data = response.body().string();
                JSONArray jsonArray = new JSONArray(data);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject currentJsonObject = jsonArray.getJSONObject(i);
                    int id = currentJsonObject.getInt(Constants.ID_TAG);
                    String name = "";
                    if (currentJsonObject.has(Constants.NAME_TAG)) {
                        name = currentJsonObject.getString(Constants.NAME_TAG);
                    }
                    String image = "";
                    if (currentJsonObject.has(Constants.IMAGE_TAG)) {
                        image = currentJsonObject.getString(Constants.IMAGE_TAG);
                    }
                    String species = "";
                    if (currentJsonObject.has(Constants.SPECIES_TAG)) {
                        species = currentJsonObject.getString(Constants.SPECIES_TAG);
                    }
                    String gender = "";
                    if (currentJsonObject.has(Constants.GENDER_TAG)) {

                        gender = currentJsonObject.getString(Constants.GENDER_TAG);
                    }
                    double height = 0.0;
                    if (currentJsonObject.has(Constants.HEIGHT_TAG)) {
                        height = currentJsonObject.getDouble(Constants.HEIGHT_TAG);
                    }
                    Character currentCharacter = new Character(id, name, image, species, gender, height);
                    characters.add(currentCharacter);
                }
            } catch (IOException e) {
                e.printStackTrace();
                error = true;
            }
            catch (JSONException e) {
                e.printStackTrace();
                error = true;
            }
            return characters;
        }

        @Override
        protected void onPostExecute(ArrayList<Character> characters) {
            if (error) {
                view.onError();
            } else {
                view.setValues(characters);
                view.hideLoading();
            }
        }
    }
}
