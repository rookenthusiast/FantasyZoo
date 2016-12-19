package com.example.user.fantasyzoo;
import org.junit.*;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 18/12/2016.
 */
public class ShopTest {
    Shop shop;

    @Test
    public void canAddToTheStore(){
        shop = new Shop();
        Creature creature = new Creature("Bubba", SpeciesType.YETI);
        shop.addCreatureToStore(creature);
        assertEquals(5,shop.checkHowManyCreaturesInStore());
    }

    @Test
    public void checkHowManyCreaturesInStock(){
        shop = new Shop();
        assertEquals(4,shop.checkHowManyCreaturesInStore());
    }
}
