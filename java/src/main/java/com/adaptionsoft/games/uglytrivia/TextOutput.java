package com.adaptionsoft.games.uglytrivia;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

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
        byte[] messageAsByteArray = message.getBytes();
        Path path = FileSystems.getDefault().getPath(filename);
        Files.write(path, messageAsByteArray);
    }
}
