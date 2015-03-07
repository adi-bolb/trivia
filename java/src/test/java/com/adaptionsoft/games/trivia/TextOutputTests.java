package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.uglytrivia.TextOutput;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by adi on 3/7/15.
 */
public class TextOutputTests {

    @Test
    public void canWriteOneLineOfTextToFile() throws IOException {
        String filename = "integrationTest.txt";
        Path path = FileSystems.getDefault().getPath(filename);
        Files.deleteIfExists(path);
        TextOutput textOutput = new TextOutput(filename);

        textOutput.consoleWriteLine("valid message");

        assertEquals("valid message", readText(filename));
    }

    private String readText(String filename) throws IOException {
        Path path = FileSystems.getDefault().getPath(filename);
        List<String> lines = Files.readAllLines(path, Charset.defaultCharset());
        return lines.get(0);
    }
}