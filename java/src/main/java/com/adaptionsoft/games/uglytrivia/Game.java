package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.LinkedList;

public class Game {
    ArrayList players = new ArrayList();
    int[] places = new int[6];
    int[] purses = new int[6];
    boolean[] inPenaltyBox = new boolean[6];

    LinkedList popQuestions = new LinkedList();
    LinkedList scienceQuestions = new LinkedList();
    LinkedList sportsQuestions = new LinkedList();
    LinkedList rockQuestions = new LinkedList();

    int currentPlayer = 0;
    boolean isGettingOutOfPenaltyBox;

    public Game() {
        for (int i = 0; i < 50; i++) {
            popQuestions.addLast("Pop Question " + i);
            scienceQuestions.addLast(("Science Question " + i));
            sportsQuestions.addLast(("Sports Question " + i));
            rockQuestions.addLast(createRockQuestion(i));
        }
    }

    public String createRockQuestion(int index) {
        return "Rock Question " + index;
    }

    public boolean add(String playerName) {


        players.add(playerName);
        places[howManyPlayers()] = 0;
        purses[howManyPlayers()] = 0;
        inPenaltyBox[howManyPlayers()] = false;

        print(playerName + " was added");
        print("They are player number " + players.size());
        return true;
    }

    private void print(final String message) {
        System.out.println(message);
    }

    public int howManyPlayers() {
        return players.size();
    }

    public void roll(int roll) {
        print(players.get(currentPlayer) + " is the current player");
        print("They have rolled a " + roll);

        if (isInPenaltyBox()) {
            playFromPenaltyBox(roll);
        } else {
            playNormalTurn(roll);
        }

    }

    private boolean isInPenaltyBox() {
        return inPenaltyBox[currentPlayer];
    }

    private void playNormalTurn(final int roll) {
        places[currentPlayer] = places[currentPlayer] + roll;
        if (places[currentPlayer] > 11) places[currentPlayer] = places[currentPlayer] - 12;

        print(players.get(currentPlayer)
                + "'s new location is "
                + places[currentPlayer]);
        print("The category is " + currentCategory());
        askQuestion();
    }

    private void playFromPenaltyBox(final int roll) {
        if (isEvenRoll(roll)) {
            getOutOfPenaltyBox(roll);
        } else {
            stayInPenaltyBox();
        }
    }

    private void stayInPenaltyBox() {
        print(players.get(currentPlayer) + " is not getting out of the penalty box");
        isGettingOutOfPenaltyBox = false;
    }

    private void getOutOfPenaltyBox(final int roll) {
        isGettingOutOfPenaltyBox = true;

        print(players.get(currentPlayer) + " is getting out of the penalty box");
        playNormalTurn(roll);
    }

    private boolean isEvenRoll(final int roll) {
        return roll % 2 != 0;
    }

    private void askQuestion() {
        if (currentCategory() == "Pop")
            print(popQuestions.removeFirst().toString());
        if (currentCategory() == "Science")
            print(scienceQuestions.removeFirst().toString());
        if (currentCategory() == "Sports")
            print(sportsQuestions.removeFirst().toString());
        if (currentCategory() == "Rock")
            print(rockQuestions.removeFirst().toString());
    }


    private String currentCategory() {
        if (places[currentPlayer] == 0) return "Pop";
        if (places[currentPlayer] == 4) return "Pop";
        if (places[currentPlayer] == 8) return "Pop";
        if (places[currentPlayer] == 1) return "Science";
        if (places[currentPlayer] == 5) return "Science";
        if (places[currentPlayer] == 9) return "Science";
        if (places[currentPlayer] == 2) return "Sports";
        if (places[currentPlayer] == 6) return "Sports";
        if (places[currentPlayer] == 10) return "Sports";
        return "Rock";
    }

    public boolean wasCorrectlyAnswered() {
        if (isInPenaltyBox()) {
            if (isGettingOutOfPenaltyBox) {
                return completeTurn("Answer was correct!!!!");
            } else {
                nextPlayer();
                return true;
            }


        } else {

            return completeTurn("Answer was corrent!!!!");
        }
    }

    private void nextPlayer() {
        currentPlayer++;
        wrapAroundBoard();
    }

    private boolean completeTurn(final String message) {
        print(message);
        purses[currentPlayer]++;
        print(players.get(currentPlayer)
                + " now has "
                + purses[currentPlayer]
                + " Gold Coins.");

        boolean winner = didPlayerWin();
        nextPlayer();

        return winner;
    }

    private void wrapAroundBoard() {
        if (currentPlayer == players.size()) currentPlayer = 0;
    }

    public boolean wrongAnswer() {
        print("Question was incorrectly answered");
        print(players.get(currentPlayer) + " was sent to the penalty box");
        inPenaltyBox[currentPlayer] = true;

        nextPlayer();
        return true;
    }


    private boolean didPlayerWin() {
        return !(purses[currentPlayer] == 6);
    }
}
