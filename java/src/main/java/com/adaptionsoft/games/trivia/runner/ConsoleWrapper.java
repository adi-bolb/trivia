package com.adaptionsoft.games.trivia.runner;

/**
 * Created by adi on 5/16/14.
 */
public class ConsoleWrapper implements IConsoleWrapper {
    public void consoleWriteLine(String text) {
        System.out.println(text);
    }
}
