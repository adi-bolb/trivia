package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.uglytrivia.QuestionWriterForMockist;
import org.junit.Test;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by adi on 12/5/14.
 */
public class QuestionWriterForMockistImplTests {
    @Test
    public void something(){
        QuestionSocket questionSocket = mock(QuestionSocket.class);
        QuestionWriterForMockistImpl questionWriterForMockist = new QuestionWriterForMockistImpl(questionSocket);

        questionWriterForMockist.ask("doesnt matter");

        verify(questionSocket).sendMessage(anyString());
    }
}
