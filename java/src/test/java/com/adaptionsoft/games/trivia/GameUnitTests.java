package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.uglytrivia.Console;
import com.adaptionsoft.games.uglytrivia.Game;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by adi on 11/7/14.
 */
public class GameUnitTests {

    @Test
    public void sometest(){
        Console consoleMock = mock(Console.class);
        Game game = new Game(consoleMock);

        game.add("PlayerOne");

        verify(consoleMock).writeLine("PlayerOne was added");
        verify(consoleMock).writeLine("They are player number 1");
    }
}
