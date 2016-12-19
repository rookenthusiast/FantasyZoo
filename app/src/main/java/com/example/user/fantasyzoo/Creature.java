package com.example.user.fantasyzoo;

import java.util.ArrayList;

/**
 * Created by user on 16/12/2016.
 */
public class Creature {
    public String name;
    private SpeciesType species;
    private ArrayList<HoldType> habitats;

    public Creature(String name, SpeciesType species){
        this.name = name;
        this.species = species;
        this.habitats = new ArrayList<HoldType>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecies(SpeciesType species) {
        this.species = species;
    }

    public SpeciesType getSpecies() {
        return species;
    }

    public ArrayList<HoldType> getHabitats(){
        return habitats;
    }

    public int checkHowManyHabitatsItCanLive(){
        return habitats.size();
    }

    public void addHabitat(HoldType holdType){
        habitats.add(holdType);
    }

    @Override
    public String toString(){
        return "Name: " + this.name + " ,Species:" + this.species + ", habitats:" + habitats.toString();
    }
}