package com.example.user.fantasyzoo;

import java.util.ArrayList;

/**
 * Created by user on 16/12/2016.
 */
public class User{
    private String name;
    ArrayList<Creature> storage;
    Enclosure enclosure;


    public User(String name, Enclosure enclosure) {
        this.name = name;
        this.storage = new ArrayList<Creature>();
        this.enclosure = enclosure;
    }

    public int checkHowManyCreaturesInStorage() {
        return storage.size();
    }

    public String getName() {
        return name;
    }

    public void addCreatureToStorage(Creature creature){
        storage.add(creature);
    }

    public Creature getCreatureByName(String name){
        for(Creature userCreature : storage){
            if(userCreature.getName() == name)
                return userCreature;
        }

        return null;
    }

    public int getCreatureByIndex(Creature creature) {
        return storage.indexOf(creature);
    }

    public Creature removeCreatureFromStorage(int position){
       Creature creatureToBeRemoved =  storage.remove(position);
        return creatureToBeRemoved;
    }

public void addCreatureToEnclosure(String string){
    Creature userCreature = getCreatureByName(string);
    int index = getCreatureByIndex(userCreature);
    Creature creatureToBeAdded = removeCreatureFromStorage(index);
    enclosure.addCreatureIfSuitable(creatureToBeAdded);
}

}