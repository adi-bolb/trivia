package com.adaptionsoft.games.uglytrivia;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RollTest {
    @Test
    public void threeIsOddRoll(){
        assertTrue( Roll.fromInteger(3).isOdd());
    }

    @Test
    public void fourIsEvenRoll(){
        assertFalse( Roll.fromInteger(4).isOdd());
    }

}