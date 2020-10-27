package com.codecool.starwarspetproject.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.codecool.starwarspetproject.R;
import com.codecool.starwarspetproject.model.Character;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void setValues(List<Character> characters) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void onError() {

    }
}