package com.example.user.fantasyzoo;
import org.junit.*;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 16/12/2016.
 */
public class CreatureTest {

    Creature creature;


    @Test
    public void canGetName() {
        creature = new Creature("Will", SpeciesType.CHIMERA);
        assertEquals("Will", creature.getName());
    }

    @Test
    public void canGetSpecies(){
        creature = new Creature("Will", SpeciesType.CHIMERA);
        assertEquals(SpeciesType.CHIMERA, creature.getSpecies());
    }

}
