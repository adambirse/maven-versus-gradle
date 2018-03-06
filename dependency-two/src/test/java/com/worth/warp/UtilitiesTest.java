package com.worth.warp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class UtilitiesTest {

    @Test
    public void testSomethingUseful() {
        Utilities utilities = new Utilities();
        assertEquals("I am a helpful monkey", utilities.somethingUseful());
    }

}
