package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.uglytrivia.QuestionWriterForMockist;

/**
 * Created by adi on 12/5/14.
 */
public class QuestionWriterForMockistImpl implements QuestionWriterForMockist {
    private QuestionSocket questionSocket;

    public QuestionWriterForMockistImpl(QuestionSocket questionSocket) {

        this.questionSocket = questionSocket;
    }

    @Override
    public void ask(String message) {
        questionSocket.sendMessage(message);
    }
}
