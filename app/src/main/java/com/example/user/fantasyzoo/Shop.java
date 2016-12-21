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
        creature1.addHabitat(HoldType.AVIARY);
        creature2.addHabitat(HoldType.AVIARY);
        creature2.addHabitat(HoldType.RUGGED);
        creature3.addHabitat(HoldType.AVIARY);
        creature4.addHabitat(HoldType.POLAR);
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

    public int getIndexOfCreature(Creature creature) {
        return shopWarehouse.indexOf(creature);
    }

    public Creature getCreatureByIndex(int position){
        return shopWarehouse.get(position);
    }

    public Creature getCreatureByName(String name){
        for(Creature shopCreature : shopWarehouse){
            if(shopCreature.getName().equals(name) ){
                return shopCreature;}

        }

        return null;
    }



    public Creature removeCreatureFromShop(int position){
        Creature creatureToBeRemoved =  shopWarehouse.remove(position);
        return creatureToBeRemoved;
    }

}
