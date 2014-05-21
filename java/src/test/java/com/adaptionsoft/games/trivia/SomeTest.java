package com.adaptionsoft.games.trivia;

import static org.junit.Assert.*;

import com.adaptionsoft.games.uglytrivia.Game;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class SomeTest {

	@Test
    public void gameWasCorrectlyAnsweredWhenNotInPenaltyBoxWriteCorrectAnswerToConsole(){

        Game game = new Game();
        game.add("some player name");

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        game.wasCorrectlyAnswered();

        assertEquals("Answer was corrent!!!!\n" +
                "some player name now has 1 Gold Coins.\n", outputStream.toString());
    }

    @Test
    public void correctAnswerMessageIsValid(){
        Game game = new Game();
        String expected = "Answer was corrent!!!!";

        String actual = game.getCorrectAnswerMessage();

        assertEquals(expected, actual);
    }
}