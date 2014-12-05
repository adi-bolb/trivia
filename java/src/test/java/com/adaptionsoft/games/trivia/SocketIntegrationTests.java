package com.adaptionsoft.games.trivia;

import org.junit.Test;

import java.net.Socket;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by adi on 12/5/14.
 */
public class SocketIntegrationTests {

    @Test
    public void returnsErrorWhenConnectionFailed(){
        Socket socket = new Socket();
        boolean notConnected = socket.isConnected();

        assertFalse(notConnected);
    }
}