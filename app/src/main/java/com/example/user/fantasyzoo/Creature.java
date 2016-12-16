package com.example.user.fantasyzoo;

/**
 * Created by user on 16/12/2016.
 */
public class Creature {
    public String name;
    private SpeciesType species;

    public Creature(String name, SpeciesType species ){
        this.name = name;
        this.species = species;
}

    public String getName() {
        return name;
    }

    public SpeciesType getSpecies() {
        return species;
    }

}