package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.uglytrivia.GameResultConsoleWriterImpl;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


/**
 * Created by adi on 12/4/14.
 */
public class GameResultFileWriterImplTests {
    GameResultTextWriterImpl textWriter;
    File fileMock;
    @Before
    public void before(){
        textWriter = new GameResultTextWriterImpl();
        fileMock = mock(File.class);
        textWriter.setFile(fileMock);
    }

    @Test
    public void aValidTextShouldBeWrittenToFile(){
        textWriter.writeLine("my text");

        verify(fileMock).write("my text");
    }

    @Test
    public void createFileAtFirstTextWriterCall(){
        textWriter.writeLine("mytext");

        verify(fileMock, times(1)).createFile(anyString());
    }

    @Test
    public void doesNotCreateFileAtSecondTextWriterCall(){
        textWriter.writeLine("mytext");

        textWriter.writeLine("mytext");

        verify(fileMock, times(1)).createFile(anyString());
    }
}