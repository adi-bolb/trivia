package com.adaptionsoft.games.uglytrivia;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class Game {

    private GameOutput gameOutput;

    ArrayList players = new ArrayList();
    int[] places = new int[6];
    int[] purses  = new int[6];
    boolean[] inPenaltyBox  = new boolean[6];
    
    LinkedList popQuestions = new LinkedList();
    LinkedList scienceQuestions = new LinkedList();
    LinkedList sportsQuestions = new LinkedList();
    LinkedList rockQuestions = new LinkedList();
    
    int currentPlayer = 0;
    boolean isGettingOutOfPenaltyBox;
    
    public  Game(){
        gameOutput = new ConsoleOutput();
    	for (int i = 0; i < 50; i++) {
			popQuestions.addLast("Pop Question " + i);
			scienceQuestions.addLast(("Science Question " + i));
			sportsQuestions.addLast(("Sports Question " + i));
			rockQuestions.addLast(createRockQuestion(i));
    	}
    }

	public String createRockQuestion(int index){
		return "Rock Question " + index;
	}
	
	public boolean isPlayable() {
		return (howManyPlayers() >= 2);
	}

	public boolean add(String playerName) throws IOException {
		
		
	    players.add(playerName);
	    places[howManyPlayers()] = 0;
	    purses[howManyPlayers()] = 0;
	    inPenaltyBox[howManyPlayers()] = false;

        String playerMessage = playerName + " was added";
        gameOutput.consoleWriteLine(playerMessage);
        gameOutput.consoleWriteLine("They are player number " + players.size());
        return true;
	}

    public int howManyPlayers() {
		return players.size();
	}

	public void roll(int roll) throws IOException {
        gameOutput.consoleWriteLine(players.get(currentPlayer) + " is the current player");
        gameOutput.consoleWriteLine("They have rolled a " + roll);

        if (inPenaltyBox[currentPlayer]) {
			if (roll % 2 != 0) {
				isGettingOutOfPenaltyBox = true;

                gameOutput.consoleWriteLine(players.get(currentPlayer) + " is getting out of the penalty box");
                places[currentPlayer] = places[currentPlayer] + roll;
				if (places[currentPlayer] > 11) places[currentPlayer] = places[currentPlayer] - 12;

                gameOutput.consoleWriteLine(players.get(currentPlayer)
                        + "'s new location is "
                        + places[currentPlayer]);
                String currentCategoryMessage = "The category is " + currentCategory();
                gameOutput.consoleWriteLine(currentCategoryMessage);
                askQuestion();
			} else {
                gameOutput.consoleWriteLine(players.get(currentPlayer) + " is not getting out of the penalty box");
                isGettingOutOfPenaltyBox = false;
				}
			
		} else {
		
			places[currentPlayer] = places[currentPlayer] + roll;
			if (places[currentPlayer] > 11) places[currentPlayer] = places[currentPlayer] - 12;

            gameOutput.consoleWriteLine(players.get(currentPlayer)
                    + "'s new location is "
                    + places[currentPlayer]);
            String currentCategoryMessage = "The category is " + currentCategory();
            gameOutput.consoleWriteLine(currentCategoryMessage);
            askQuestion();
		}
		
	}

    private void askQuestion() throws IOException {
		if (currentCategory() == "Pop") {
            String popMessage = popQuestions.removeFirst().toString();
            gameOutput.consoleWriteLine(popMessage);
        }
		if (currentCategory() == "Science")
            gameOutput.consoleWriteLine(scienceQuestions.removeFirst().toString());
        if (currentCategory() == "Sports")
            gameOutput.consoleWriteLine(sportsQuestions.removeFirst().toString());
        if (currentCategory() == "Rock")
            gameOutput.consoleWriteLine(rockQuestions.removeFirst().toString());
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

	public boolean wasCorrectlyAnswered() throws IOException {
		if (inPenaltyBox[currentPlayer]){
			if (isGettingOutOfPenaltyBox) {
                gameOutput.consoleWriteLine("Answer was correct!!!!");
                purses[currentPlayer]++;
                gameOutput.consoleWriteLine(players.get(currentPlayer)
                        + " now has "
                        + purses[currentPlayer]
                        + " Gold Coins.");

                boolean winner = didPlayerWin();
				currentPlayer++;
				if (currentPlayer == players.size()) currentPlayer = 0;
				
				return winner;
			} else {
				currentPlayer++;
				if (currentPlayer == players.size()) currentPlayer = 0;
                return true;
                }



} else {

            gameOutput.consoleWriteLine("Answer was corrent!!!!");
            purses[currentPlayer]++;
            gameOutput.consoleWriteLine(players.get(currentPlayer)
                    + " now has "
                    + purses[currentPlayer]
                    + " Gold Coins.");

            boolean winner = didPlayerWin();
			currentPlayer++;
			if (currentPlayer == players.size()) currentPlayer = 0;
			
			return winner;
        }
    }

    public boolean wrongAnswer() throws IOException {
        String questionIncorrectlyAnsweredMessage = "Question was incorrectly answered";
        gameOutput.consoleWriteLine(questionIncorrectlyAnsweredMessage);
        gameOutput.consoleWriteLine(players.get(currentPlayer) + " was sent to the penalty box");
        inPenaltyBox[currentPlayer] = true;
		
		currentPlayer++;
		if (currentPlayer == players.size()) currentPlayer = 0;
		return true;
	}


    private boolean didPlayerWin() {
		return !(purses[currentPlayer] == 6);
	}
}
