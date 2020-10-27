package com.codecool.starwarspetproject.main;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

import com.codecool.starwarspetproject.R;
import com.codecool.starwarspetproject.details.DetailsActivity;
import com.codecool.starwarspetproject.model.Character;
import com.codecool.starwarspetproject.util.Util;

import java.util.ArrayList;
import java.util.List;

public class CharactersAdapter extends RecyclerView.Adapter<CharactersAdapter.CharactersViewHolder> {

    private ArrayList<Character> characters;
    private Context context;

    public CharactersAdapter(Context context) {
        this.context = context;
    }

    public void updateCharacters(List<Character> newCharacters) {
        characters.clear();
        characters.addAll(newCharacters);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CharactersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CharactersViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CharactersAdapter.CharactersViewHolder holder, int position) {
        holder.bind(characters.get(position));
    }

    @Override
    public int getItemCount() {
        return characters == null ? 0 : characters.size();
    }

    public class CharactersViewHolder extends RecyclerView.ViewHolder {
        ImageView characterImage;
        TextView characterName;
        TextView characterSpecies;
        CircularProgressDrawable progressDrawable;

        public CharactersViewHolder(@NonNull View itemView) {
            super(itemView);
            characterImage = itemView.findViewById(R.id.character_image);
            characterName = itemView.findViewById(R.id.character_name);
            characterSpecies = itemView.findViewById(R.id.character_species);
            progressDrawable = Util.getProgressDrawable(itemView.getRootView().getContext());
        }

        public void bind(Character character) {
            Util.loadImage(characterImage, character.getImage(), progressDrawable);
            characterName.setText(character.getName());
            characterSpecies.setText(character.getSpecies());

            itemView.setOnClickListener(v -> {
                    Intent intent = new Intent(itemView.getContext(), DetailsActivity.class);
                    intent.putExtra("character", character);
                    itemView.getContext().startActivity(intent);
            });
        }
    }
}
