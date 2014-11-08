package com.adaptionsoft.games.trivia;

import static org.junit.Assert.*;

import com.adaptionsoft.games.uglytrivia.Game;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TriviaSystemTests {

    // Methods to test for System.out.println
    // add - DONE
    // roll
    // askquestion
    // was correctly answered
    // wrong answer

    @Test
    public void addWritesToConsole(){
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(stream);
        System.setOut(printStream);
        Game game = new Game();

        game.add("PlayerOne");

        assertEquals("PlayerOne was added\n" +
                "They are player number 1\n", stream.toString());

    }

    @Test
    public void rollWritesToConsoleWhenNotInPenaltyBox(){
        Game game = new Game();
        game.add("PlayerOne");
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(stream);
        System.setOut(printStream);

        game.roll(1);

        assertEquals("PlayerOne is the current player\n" +
                "They have rolled a 1\n" +
                "PlayerOne's new location is 1\n" +
                "The category is Science\n" +
                "Science Question 0\n", stream.toString());
    }
}