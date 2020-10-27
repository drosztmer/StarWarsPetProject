package com.codecool.starwarspetproject.model;

import java.io.Serializable;

public class Character implements Serializable {
    private int id;
    private String name;
    private String image;
    private String species;
    private String gender;
    private double height;

    public Character(int id, String name, String image, String species, String gender, double height) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.species = species;
        this.gender = gender;
        this.height = height;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
