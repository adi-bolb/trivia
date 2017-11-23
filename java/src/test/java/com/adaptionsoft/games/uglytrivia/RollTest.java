package com.adaptionsoft.games.uglytrivia;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RollTest {
    Roll roll;
    @Before
    public void before() throws Exception {
        roll = new Roll(3);
    }

    @Test
    public void threeIsEvenRoll(){
        assertTrue(roll.isOdd());
    }

}