package com.example.user.fantasyzoo;
import org.junit.*;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;


/**
 * Created by user on 16/12/2016.
 */
public class EnclosureTest {

    Enclosure enclosure;
    Creature creature;
    ArrayList<HoldType> habitats;

    @Before

    public void before(){
        enclosure = new Enclosure("Northern Sea",HoldType.AQUATIC);
//        ArrayList<HoldType> habitats = new ArrayList<HoldType>();

    }

    @Test
    public void getNameTest(){
        assertEquals("Northern Sea", enclosure.getName());
    }

    @Test
    public void getHoldType(){
        assertEquals(HoldType.AQUATIC, enclosure.getHold());
    }

    @Test
    public void canAddCreatureTest(){
        creature = new Creature("Will",SpeciesType.HIPPOCAMPUS, habitats );
        enclosure.addCreature(creature);
        assertEquals("Will", enclosure.getCreatureByIndex(0).name);
    }

    @Test
    public void canGetCreatureByIndex(){
       Creature creature1 = new Creature("Tegan",SpeciesType.UNICORN, habitats);
        Creature creature2 = new Creature("Lewis",SpeciesType.PEGASUS, habitats);
        enclosure.addCreature(creature1);
        enclosure.addCreature(creature2);
        assertEquals("Tegan", enclosure.getCreatureByIndex(0).name);

    }

    @Test
    public void checkCreatureSuitable(){
        creature = new Creature("Will", SpeciesType.HIPPOCAMPUS, habitats);
        habitats.add(HoldType.AQUATIC);
        assertEquals(0,e);
//
    }
}
