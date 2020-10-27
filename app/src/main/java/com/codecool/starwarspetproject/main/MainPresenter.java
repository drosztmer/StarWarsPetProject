package com.codecool.starwarspetproject.main;

import android.content.Context;
import android.os.AsyncTask;

import com.codecool.starwarspetproject.model.Character;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Array;
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

        private static final String URL = "https://cdn.rawgit.com/akabab/starwars-api/0.2.1/api/all.json";
        private OkHttpClient client = new OkHttpClient();

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            view.showLoading();
        }

        @Override
        protected ArrayList<Character> doInBackground(String... strings) {
            Request request = new Request.Builder().url(URL).build();

            try {
                Response response = client.newCall(request).execute();
                String data = response.body().string();
                JSONArray jsonArray = new JSONArray(data);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject currentJsonObject = jsonArray.getJSONObject(i);
                    int id = currentJsonObject.getInt("id");
                    String name = "";
                    if (currentJsonObject.has("name")) {
                        name = currentJsonObject.getString("name");
                    }
                    String image = "";
                    if (currentJsonObject.has("image")) {
                        image = currentJsonObject.getString("image");
                    }
                    String species = "";
                    if (currentJsonObject.has("species")) {
                        species = currentJsonObject.getString("species");
                    }
                    String gender = "";
                    if (currentJsonObject.has("gender")) {

                        gender = currentJsonObject.getString("gender");
                    }
                    double height = 0.0;
                    if (currentJsonObject.has("height")) {
                        height = currentJsonObject.getDouble("height");
                    }
                    Character currentCharacter = new Character(id, name, image, species, gender, height);
                    characters.add(currentCharacter);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            catch (JSONException e) {
                e.printStackTrace();
            }
            return characters;
        }

        @Override
        protected void onPostExecute(ArrayList<Character> characters) {
            view.setValues(characters);
            view.hideLoading();
        }
    }
}
