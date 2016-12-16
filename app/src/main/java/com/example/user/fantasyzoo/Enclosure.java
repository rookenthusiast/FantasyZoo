package com.example.user.fantasyzoo;

import android.widget.GridLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by user on 16/12/2016.
 */
public class Enclosure {
    private String name;
    private ArrayList<Creature> coop;
    private HoldType hold;
    private Creature creature;

    public Enclosure(String name, HoldType hold) {
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

    public void addCreature(Creature creature) {
        coop.add(creature);
    }

    public Creature getCreatureByIndex(int position) {
        return coop.get(position);
    }
//
    public String addCreatureIfSuitable(Creature creature) {
        String message = null;
        for (HoldType holds : creature.getHabitats()) {
            if (this.hold == holds) {
                addCreature(creature);
                message = "You have added your creature to the enclosure!";
            } else
                message = "That creature can't live there *chuckle*";
        }
        return message;
    }


//if (comparison.contains(species)){
//    List holds = (List)comparison.get(species);
//    holds.add(hold);
//}
//        else
//{
//    List values = new ArrayList();
//    values.add(hold);
//    comparison.put(species, values);
//}
//        return (List)comparison.get(species);
//
//    }
}


