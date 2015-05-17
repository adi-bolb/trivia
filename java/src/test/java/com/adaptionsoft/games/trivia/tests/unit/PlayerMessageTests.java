package com.adaptionsoft.games.trivia.tests.unit;

import com.adaptionsoft.games.uglytrivia.PlayerMessage;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by adi on 5/10/15.
 */
public class PlayerMessageTests {
    PlayerMessage playerMessage;
    @Before
    public void setup(){
        playerMessage = new PlayerMessage();
    }

    @Test
    public void alwaysReturnMessageWhenAnsweredIncorrectly(){
        String expected = "Question was incorrectly answered";

        String actual = playerMessage.createWhenAnsweredIncorrectly();

        assertEquals(expected, actual);
    }

    @Test
    public void returnValidMessageWhenTheyRegisteredWithValidPlayerNumber(){
        int validPlayerNumber = 2;
        String expected = "They are player number 2";

        String actual = playerMessage.createWithNumber(validPlayerNumber);

        assertEquals(expected, actual);
    }

    @Test
    @PossibleBug
    public void returnValidMessageWhenTheirNumberIsNegative(){
        int validPlayerNumber = -1;
        String expected = "They are player number -1";

        String actual = playerMessage.createWithNumber(validPlayerNumber);

        assertEquals(expected, actual);
    }

    @Test
    @PossibleBug
    public void returnValidMessageWhenTheirNumberIsZero(){
        int validPlayerNumber = 0;
        String expected = "They are player number 0";

        String actual = playerMessage.createWithNumber(validPlayerNumber);

        assertEquals(expected, actual);
    }

    @Test
    @PossibleBug
    public void returnValidMessageWhenTheirNumberIsVeryBig(){
        int validPlayerNumber = 1000;
        String expected = "They are player number 1000";

        String actual = playerMessage.createWithNumber(validPlayerNumber);

        assertEquals(expected, actual);
    }

    @Test
    @PossibleBug
    public void returnsCreateWhenPlayerAddedWithEmptyPlayerName(){
        String expected = " was added";
        String emptyPlayerName = "";

        String actual = playerMessage.createWhenPlayerAdded(emptyPlayerName);

        assertEquals(expected, actual);
    }

    @Test
    public void POSSIBLE_BUG_returnsMessageCreateWhenPlayerAddedWithOnlyNumericalPlayerName(){
        String expected = "1 was added";
        String onlyNumericalPlayerName = "1";

        String actual = playerMessage.createWhenPlayerAdded(onlyNumericalPlayerName);

        assertEquals(expected, actual);
    }
}