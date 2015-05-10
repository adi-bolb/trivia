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
}
