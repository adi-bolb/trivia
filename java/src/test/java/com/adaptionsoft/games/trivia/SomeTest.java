package com.adaptionsoft.games.trivia;

import static org.junit.Assert.*;
import org.junit.Test;
import com.adaptionsoft.games.uglytrivia.Game;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class SomeTest {

    @Test
    public void testWhenAddingPlayerItsNameAndNumberAreWritten(){
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(stream);
        System.setOut(printStream);

        Game game = new Game();
        game.add("Some Player");

        assertEquals("Some Player was added\n" +
                "They are player number 1\n", stream.toString());
    }

    @Test
    public void testWhenAddingTwoPlayers(){
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(stream);
        System.setOut(printStream);

        Game game = new Game();
        game.add("Some Player");
        game.add("Some other Player");

        assertEquals("Some Player was added\n" +
                "They are player number 1\n" +
                "Some other Player was added\n" +
                "They are player number 2\n", stream.toString());
    }

    @Test
    public void testWhenAddingPlayerItsNameAndNumberAreWrittenWithExtractAndOverride(){

        GameForTests game = new GameForTests();
        game.add("Some Player");

        assertEquals("Some Player was addedThey are player number 1", game.textWritten);
    }

}