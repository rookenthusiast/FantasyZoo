package com.example.user.fantasyzoo;
import org.junit.*;

import static junit.framework.Assert.assertEquals;


/**
 * Created by user on 16/12/2016.
 */
public class EnclosureTest {

    Enclosure enclosure;
    Creature creature;

    @Before

    public void before(){
        enclosure = new Enclosure("Northern Sea",HoldType.AQUATIC);

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
        creature = new Creature("Will",SpeciesType.HIPPOCAMPUS);
        enclosure.addCreature(creature);
        assertEquals("Will", enclosure.getCreatureByIndex(0).name);
    }

    @Test
    public void canGetCreatureByIndex(){
       Creature creature1 = new Creature("Tegan",SpeciesType.UNICORN);
        Creature creature2 = new Creature("Lewis",SpeciesType.PEGASUS);
        enclosure.addCreature(creature1);
        enclosure.addCreature(creature2);
        assertEquals("Tegan", enclosure.getCreatureByIndex(0).name);

    }
}
