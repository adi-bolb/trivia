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

        assertEquals("valid message\n", readText(filename));
    }

    @Test
    public void canWriteTwoLinesOfTextToFile() throws IOException {
        String filename = "integrationTest-twoLines.txt";
        Path path = FileSystems.getDefault().getPath(filename);
        Files.deleteIfExists(path);
        TextOutput textOutput = new TextOutput(filename);

        textOutput.consoleWriteLine("valid message");
        textOutput.consoleWriteLine("valid message2");

        assertEquals("valid message\nvalid message2\n", readText(filename));

    }

    private String readText(String filename) throws IOException {
        Path path = FileSystems.getDefault().getPath(filename);
        List<String> lines = Files.readAllLines(path, Charset.defaultCharset());

        String text = "";
        for (String line : lines) {
            text += line.concat("\n");
        }

        return text;
    }
}