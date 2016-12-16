package com.example.user.fantasyzoo;
import org.junit.*;

import static junit.framework.Assert.assertEquals;


/**
 * Created by user on 16/12/2016.
 */
public class EnclosureTest {

    Enclosure enclosure;

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
}
