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

    @Test
    public void canRemoveCreature(){
        shop = new Shop();
        shop.removeCreatureFromShop(0);
        assertEquals(3,shop.checkHowManyCreaturesInStore());
    }

    @Test
    public void canGetCreatureAtIndex(){
        shop = new Shop();
        Creature creature = shop.getCreatureByIndex(0);
        System.out.println(shop.getCreatureByIndex(0));
        System.out.println(shop.getCreatureByIndex(1));
        System.out.println(shop.getCreatureByIndex(2));
        System.out.println(shop.getCreatureByIndex(3));
        assertEquals("Bucklebeak", creature.getName());
    }
}
