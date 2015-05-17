package com.adaptionsoft.games.uglytrivia;

/**
 * Created by adi on 4/19/15.
 */
public class PlayerMessage {
    public String createWhenAnsweredIncorrectly() {
        return "Question was incorrectly answered";
    }

    public String createWithNumber(int playerNumber) {
        return "They are player number " + playerNumber;
    }

    public String createWhenPlayerAdded(String playerName) {
        return playerName + " was added";
    }
}