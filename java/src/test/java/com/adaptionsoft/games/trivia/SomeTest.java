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


}