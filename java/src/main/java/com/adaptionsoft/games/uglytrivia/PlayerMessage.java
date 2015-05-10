package com.adaptionsoft.games.uglytrivia;

/**
 * Created by adi on 4/19/15.
 */
public class PlayerMessage {
    public String playerMessageCreateWhenAnsweredIncorrectly() {
        return "Question was incorrectly answered";
    }

    public String playerMessageCreateWithNumber(int playerNumber) {
        return "They are player number " + playerNumber;
    }

    public String playerMessageCreateWhenPlayerAdded(String playerName) {
        return playerName + " was added";
    }
}