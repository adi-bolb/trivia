package com.adaptionsoft.games.trivia;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import com.adaptionsoft.games.trivia.runner.ConsoleWrapper;
import com.adaptionsoft.games.trivia.runner.IConsoleWrapper;
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

        Game game = new Game(new ConsoleWrapper());
        game.add("Some Player");

        assertEquals("Some Player was added\n" +
                "They are player number 1\n", stream.toString());
    }

    @Test
    public void testWhenAddingTwoPlayers(){
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(stream);
        System.setOut(printStream);

        Game game = new Game(new ConsoleWrapper());
        game.add("Some Player");
        game.add("Some other Player");

        assertEquals("Some Player was added\n" +
                "They are player number 1\n" +
                "Some other Player was added\n" +
                "They are player number 2\n", stream.toString());
    }

    @Test
    public void testWhenAddingPlayerItsNameAndNumberAreWrittenWithExtractAndOverride(){

        IConsoleWrapper consoleWrapperMock = mock(IConsoleWrapper.class);
        GameForTests game = new GameForTests(consoleWrapperMock);
        game.add("Some Player");

        verify(consoleWrapperMock).consoleWriteLine("Some Player was added");
        verify(consoleWrapperMock).consoleWriteLine("They are player number 1");
    }

}