package com.example.user.fantasyzoo;

import java.util.ArrayList;

/**
 * Created by user on 16/12/2016.
 */
public class Enclosure {
    private String name;
    private ArrayList<Creature> coop;
    private HoldType hold;

    public Enclosure(String name, HoldType hold ){
        this.name = name;
        this.hold = hold;
        this.coop = new ArrayList<Creature>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Creature> getCoop() {
        return coop;
    }

    public HoldType getHold() {
        return hold;
    }
}
