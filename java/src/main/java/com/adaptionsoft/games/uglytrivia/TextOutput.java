package com.adaptionsoft.games.uglytrivia;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;

/**
 * Created by adi on 3/7/15.
 */
public class TextOutput implements GameOutput{
    private String filename;

    public TextOutput(String filename) {

        this.filename = filename;
    }

    @Override
    public void consoleWriteLine(String message) throws IOException {
        String messageWithNewLine = message + "\n";
        byte[] messageAsByteArray = messageWithNewLine.getBytes();
        Path path = FileSystems.getDefault().getPath(filename);
        if(!Files.exists(path)){
            Files.write(path, new byte[]{}, StandardOpenOption.CREATE_NEW);
        }
        Files.write(path, messageAsByteArray, StandardOpenOption.APPEND);
    }
}
