package com.adaptionsoft.games.trivia.tests.unit;

import com.adaptionsoft.games.uglytrivia.PlayerMessage;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by adi on 5/10/15.
 */
public class PlayerMessageTests {

    @Test
    public void alwaysReturnPlayerMessageWhenAnsweredIncorrectly(){
        PlayerMessage playerMessage = new PlayerMessage();
        String expected = "Question was incorrectly answered";

        String actual = playerMessage.playerMessageCreateWhenAnsweredIncorrectly();

        assertEquals(expected, actual);
    }

    @Test
    public void returnValidPlayerMessageWhenTheyRegisteredWithValidPlayerNumber(){
        int validPlayerNumber = 2;
        PlayerMessage playerMessage = new PlayerMessage();
        String expected = "They are player number 2";

        String actual = playerMessage.playerMessageCreateWithNumber(validPlayerNumber);

        assertEquals(expected, actual);
    }

    @Test
    @PossibleBug
    public void returnValidPlayerMessageWhenTheirNumberIsNegative(){
        int validPlayerNumber = -1;
        PlayerMessage playerMessage = new PlayerMessage();
        String expected = "They are player number -1";

        String actual = playerMessage.playerMessageCreateWithNumber(validPlayerNumber);

        assertEquals(expected, actual);
    }
}
