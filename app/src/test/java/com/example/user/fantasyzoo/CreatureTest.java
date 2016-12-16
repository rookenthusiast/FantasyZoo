package com.example.user.fantasyzoo;
import org.junit.*;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 16/12/2016.
 */
public class CreatureTest {

    Creature creature;
    ArrayList<HoldType> habitats;

    @Before
    public void before(){
      habitats = new ArrayList<HoldType>();
    }

    @Test
    public void canGetName() {
        habitats.add(HoldType.AVIARY);
        creature = new Creature("Will", SpeciesType.CHIMERA, habitats);
        assertEquals("Will", creature.getName());
    }

    @Test
    public void canGetSpecies(){
        creature = new Creature("Will", SpeciesType.CHIMERA, habitats);
        assertEquals(SpeciesType.CHIMERA, creature.getSpecies());
    }

}
