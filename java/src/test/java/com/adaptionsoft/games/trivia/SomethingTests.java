package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.uglytrivia.GameResultConsoleWriterImpl;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


/**
 * Created by adi on 12/4/14.
 */
public class SomethingTests {

    @Test
    public void aValidTextShouldBeWrittenToFile(){
        GameResultTextWriterImpl textWriter = new GameResultTextWriterImpl();
        File fileMock = mock(File.class);
        textWriter.setFile(fileMock);

        textWriter.writeLine("my text");

        verify(fileMock).write("my text");
    }


}
