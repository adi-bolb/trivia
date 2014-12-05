package com.adaptionsoft.games.trivia;

import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.net.Socket;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by adi on 12/5/14.
 */
public class QuestionWriterTests {
    @Test
    @Ignore
    public void connectWhenFirstQuestionReceived() throws IOException {
        Socket socket = new Socket("127.0.0.1", 8081);
        QuestionWriter questionWriter = new QuestionWriter(socket);

        questionWriter.ask("What time it is?");

        assertTrue(socket.isConnected());
    }
}
