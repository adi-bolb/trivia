package com.adaptionsoft.games.trivia;

import static org.junit.Assert.*;

import com.adaptionsoft.games.uglytrivia.Game;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class SomeTest {

    private Game game;
    @Before
    public void setup(){
        game = new Game();
    }

    private ByteArrayOutputStream getConsoleText() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        return outputStream;
    }

	@Test
    public void gameWasCorrectlyAnsweredWhenNotInPenaltyBoxWriteCorrectAnswerToConsole(){
        String expected = "Answer was correct!!!!\n" +
                "some player name now has 1 Gold Coins.\n";
        game.add("some player name");
        ByteArrayOutputStream outputStream = getConsoleText();
        game.wasCorrectlyAnswered();

        String actual = outputStream.toString();

        assertEquals(expected, actual);
    }

    @Test
    public void correctAnswerMessageIsValidChangedBecauseOfBug(){
        String expected = "Answer was correct!!!!";

        String actual = game.getCorrectAnswerMessage();

        assertEquals(expected, actual);
    }
}