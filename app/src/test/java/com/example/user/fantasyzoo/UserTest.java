package com.example.user.fantasyzoo;
import org.junit.*;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 17/12/2016.
 */
public class UserTest {

    User user;
    Enclosure enclosure;
    Creature creature;
    Shop shop;

    @Before
    public void before(){
        enclosure = new Enclosure("Hilltop",HoldType.AVIARY);
        user = new User("Cameron",enclosure);
        creature = new Creature("Bucklebeak",SpeciesType.GRIFFIN);
        creature.addHabitat(HoldType.AVIARY);
        shop = new Shop();
    }

    @Test
    public void canGetName(){
        assertEquals("Cameron", user.getName());
    }

    @Test
    public  void checkHowManyCreaturesAUserHas(){
        assertEquals(0,user.checkHowManyCreaturesInStorage());
    }

    @Test
    public void canAddCreatureToStorage(){
        assertEquals(0,user.checkHowManyCreaturesInStorage());
        user.addCreatureToStorage(creature);
        assertEquals(1,user.checkHowManyCreaturesInStorage());
    }

    @Test
    public void canGetCreatureByName(){
        user.addCreatureToStorage(creature);
        assertEquals(1,user.checkHowManyCreaturesInStorage());
        assertEquals(creature, user.getCreatureByName("Bucklebeak"));
        System.out.println(user.getCreatureByName("Bucklebeak").toString());
    }

    @Test
    public void canAddCreatureToEnclosure(){
        user.addCreatureToStorage(creature);
        assertEquals(1,user.checkHowManyCreaturesInStorage());
        user.addCreatureToEnclosure("Bucklebeak");
        assertEquals(1,user.enclosure.checkHowManyCreaturesInCoop());
    }

}
