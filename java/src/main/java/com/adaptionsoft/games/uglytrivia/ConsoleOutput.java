package com.adaptionsoft.games.uglytrivia;

/**
 * Created by adi on 3/7/15.
 */
public class ConsoleOutput implements GameOutput {
    @Override
    public void consoleWriteLine(String message) {
        System.out.println(message);
    }
}
