package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.uglytrivia.GameResultConsoleWriterImpl;
import org.junit.Ignore;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by adi on 12/4/14.
 */
public class FileImplTests {
    @Test
    @Ignore
    public void aValidTextShouldBeAppendedTeExistingText(){
        GameResultConsoleWriterImpl textWriter = new GameResultConsoleWriterImpl();
        textWriter.writeLine("mytext");
        textWriter.writeLine("concatenated");

        String actual = textWriter.toString();

        assertEquals("mytextconcatenated", actual);
    }
}
