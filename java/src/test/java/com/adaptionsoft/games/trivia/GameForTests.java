package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.uglytrivia.Game;

/**
 * Created by adi on 12/4/14.
 */
public class GameForTests extends Game {

    public String output = "";

    @Override
    protected void consoleWriteLine(String playerWonText) {
        output = playerWonText;
    }
}
