package com.worth.warp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class LongRunningTests {

    @Test
    public void testSomethingUseful() throws InterruptedException {
       Thread.sleep(5000);
    }

    @Test
    public void testSomethingElse() throws InterruptedException {
        Thread.sleep(1000);
    }

}
