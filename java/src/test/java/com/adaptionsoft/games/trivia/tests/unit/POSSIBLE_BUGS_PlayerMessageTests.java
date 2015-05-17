package com.adaptionsoft.games.trivia.tests.unit;

import com.adaptionsoft.games.uglytrivia.PlayerMessage;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by adi on 5/17/15.
 */
public class POSSIBLE_BUGS_PlayerMessageTests {

    @Test
    public void returnsMessageCreateWhenPlayerAddedWithPlayerNameOfOnlyOneLetter(){
        String expected = "a was added";
        PlayerMessage playerMessage = new PlayerMessage();
        String onlyOneLetterName = "a";

        String actual = playerMessage.createWhenPlayerAdded(onlyOneLetterName);

        assertEquals(expected, actual);
    }

}
