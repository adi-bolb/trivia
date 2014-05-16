package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.trivia.runner.IConsoleWrapper;
import com.adaptionsoft.games.uglytrivia.Game;
/**
 * Created by adi on 5/16/14.
 */
public class GameForTests extends Game {

    public GameForTests(IConsoleWrapper consoleWrapper){
        super(consoleWrapper);
    }

    public String textWritten = "";
    protected void consoleWriteLine(String text) {
        textWritten += text;
    }
}