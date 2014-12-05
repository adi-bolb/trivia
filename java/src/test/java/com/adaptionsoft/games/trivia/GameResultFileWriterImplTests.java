package com.adaptionsoft.games.trivia;

import org.junit.Before;
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

    File fileMock;
    private GameResultTextWriterImpl textWriter;
    public static final String DOESNT_MATTER_TEXT = "DoesntMatter";

    protected GameResultTextWriterImpl getGameResultTextWriter() {
        GameResultTextWriterImpl textWriter = new GameResultTextWriterImpl();
        textWriter.setFile(fileMock);
        return textWriter;
    }

    @Before
    public void before(){
        textWriter = new GameResultTextWriterImpl();
        fileMock = mock(File.class);
        textWriter.setFile(fileMock);
    }

    @Test
    public void aValidTextShouldBeWrittenToFile(){
        String validTextToBeVerified = "Valid text to be verified";
        textWriter.writeLine(validTextToBeVerified);

        verify(fileMock).write(validTextToBeVerified);
    }

    @Test
    public void createFileAtFirstTextWriterCall(){
        GameResultTextWriterImpl textWriter = getGameResultTextWriter();
        textWriter.writeLine(DOESNT_MATTER_TEXT);

        verify(fileMock, times(1)).createFile(anyString());
    }

    @Test
    public void doesNotCreateFileAtSecondTextWriterCall(){
        GameResultTextWriterImpl textWriter = getGameResultTextWriter();
        textWriter.writeLine(DOESNT_MATTER_TEXT);

        textWriter.writeLine(DOESNT_MATTER_TEXT);

        verify(fileMock, times(1)).createFile(anyString());
    }
}