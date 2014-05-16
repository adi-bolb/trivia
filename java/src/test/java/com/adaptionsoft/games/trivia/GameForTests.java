package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.uglytrivia.Game;
/**
 * Created by adi on 5/16/14.
 */
public class GameForTests extends Game {
    public String textWritten = "";
    protected void consoleWriteLine(String text) {
        textWritten += text;
    }
}