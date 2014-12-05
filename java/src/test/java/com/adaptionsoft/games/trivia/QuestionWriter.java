package com.adaptionsoft.games.trivia;

import java.net.Socket;

/**
 * Created by adi on 12/5/14.
 */
public class QuestionWriter {
    private Socket socket;

    public QuestionWriter(Socket socket) {

        this.socket = socket;
    }

    public void ask(String s) {
        // TODO Create real server and connect to it
    }
}
