package com.example.user.fantasyzoo;

import java.util.ArrayList;

/**
 * Created by user on 16/12/2016.
 */
public class Shop {
    ArrayList<Creature> shopWarehouse;

    public Shop(){
        this.shopWarehouse = new ArrayList<Creature>();
        Creature creature1 = new Creature("Bucklebeak", SpeciesType.GRIFFIN);
        Creature creature2 = new Creature("Zeus", SpeciesType.PEGASUS);
        Creature creature3 = new Creature("Hera", SpeciesType.MANTICORE);
        Creature creature4 = new Creature("MrWhippy", SpeciesType.YETI);
        addCreatureToStore(creature1);
        addCreatureToStore(creature2);
        addCreatureToStore(creature3);
        addCreatureToStore(creature4);
    }

    public ArrayList<Creature> getShopWarehouse() {
        return shopWarehouse;
    }

    public void addCreatureToStore(Creature creature){
        shopWarehouse.add(creature);
    }

    public int checkHowManyCreaturesInStore(){
        return shopWarehouse.size();
    }

}
