package com.codecool.starwarspetproject.details;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codecool.starwarspetproject.R;
import com.codecool.starwarspetproject.model.Character;
import com.codecool.starwarspetproject.util.Util;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends AppCompatActivity {

    private Character character;

    @BindView(R.id.details_image)
    ImageView detailsImage;

    @BindView(R.id.current_name)
    TextView currentName;

    @BindView(R.id.current_species)
    TextView currentSpecies;

    @BindView(R.id.current_gender)
    TextView currentGender;

    @BindView(R.id.current_height)
    TextView currentHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ButterKnife.bind(this);

        character = (Character) getIntent().getSerializableExtra("character");

        setViews();
    }

    private void setViews() {
        Util.loadDetailsImage(this, character.getImage(), detailsImage);
        String capitalizedName = character.getName().substring(0, 1).toUpperCase() + character.getName().substring(1);
        currentName.setText(capitalizedName);
        String capitalizedSpecies = character.getSpecies().substring(0, 1).toUpperCase() + character.getSpecies().substring(1);
        currentSpecies.setText(capitalizedSpecies);
        String capitalizedGender = character.getGender().substring(0, 1).toUpperCase() + character.getGender().substring(1);
        currentGender.setText(capitalizedGender);
        currentHeight.setText(String.valueOf(character.getHeight()));
    }
}