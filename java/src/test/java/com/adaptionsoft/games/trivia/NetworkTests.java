package com.adaptionsoft.games.trivia;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by adi on 12/5/14.
 */
public class NetworkTests {
    @Test
    public void doesNotReturnErrorWhenConnectionOK(){
        boolean noError;
        boolean network = false;

        noError = Network.networkConnect(network);

        assertTrue(noError);
    }

    @Test
    public void returnsErrorWhenConnectionFailed(){
        boolean noError = true;
        boolean network = true;

        noError = Network.networkConnect(network);

        assertFalse(noError);
    }

    @Test
    public void returnsErrorWhenNothingAnswered(){
        boolean noError = true;
        boolean network = true;

        noError = Network.networkConnect(network);

        assertFalse(noError);

    }

    @Test
    public void something(){
        String loopBackAnswer = "one messageSent";

        assertEquals("one messageSent", loopBackAnswer);
    }


}
