package com.adaptionsoft.games.trivia;

import java.io.*;

public class ConsoleReader {

    ByteArrayOutputStream inputStream;

    public ConsoleReader(){
        inputStream = new ByteArrayOutputStream();
    }

    public void startReadingFromConsole(){
        System.setOut(new PrintStream(inputStream));
    }

    public String read() throws IOException {
        inputStream.flush();
        return inputStream.toString();

    }
}
