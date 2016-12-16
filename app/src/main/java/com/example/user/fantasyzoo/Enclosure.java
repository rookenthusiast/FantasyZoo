package com.example.user.fantasyzoo;

import java.util.ArrayList;

/**
 * Created by user on 16/12/2016.
 */
public class Enclosure {
    private String name;
    private ArrayList<Creature> coop;
    private HoldType hold;
    private Creature creature;

    public Enclosure(String name, HoldType hold ){
        this.name = name;
        this.hold = hold;
        this.coop = new ArrayList<Creature>();
    }

    public String getName() {
        return name;
    }

    public HoldType getHold() {
        return hold;
    }

    public void addCreature(Creature creature){
        coop.add(creature);
    }

    public Creature getCreatureByIndex(int position) {
       return coop.get(position);
    }

}
