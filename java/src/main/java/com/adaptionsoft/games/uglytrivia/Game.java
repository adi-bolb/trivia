package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.LinkedList;

public class Game {

    private ConsoleOutput consoleOutput;

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
        consoleOutput = new ConsoleOutput();
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

	public boolean add(String playerName) {
		
		
	    players.add(playerName);
	    places[howManyPlayers()] = 0;
	    purses[howManyPlayers()] = 0;
	    inPenaltyBox[howManyPlayers()] = false;

        String playerMessage = playerName + " was added";
        consoleOutput.consoleWriteLine(playerMessage);
        consoleOutput.consoleWriteLine("They are player number " + players.size());
        return true;
	}

    public int howManyPlayers() {
		return players.size();
	}

	public void roll(int roll) {
        consoleOutput.consoleWriteLine(players.get(currentPlayer) + " is the current player");
        consoleOutput.consoleWriteLine("They have rolled a " + roll);

        if (inPenaltyBox[currentPlayer]) {
			if (roll % 2 != 0) {
				isGettingOutOfPenaltyBox = true;

                consoleOutput.consoleWriteLine(players.get(currentPlayer) + " is getting out of the penalty box");
                places[currentPlayer] = places[currentPlayer] + roll;
				if (places[currentPlayer] > 11) places[currentPlayer] = places[currentPlayer] - 12;

                consoleOutput.consoleWriteLine(players.get(currentPlayer)
                        + "'s new location is "
                        + places[currentPlayer]);
                String currentCategoryMessage = "The category is " + currentCategory();
                consoleOutput.consoleWriteLine(currentCategoryMessage);
                askQuestion();
			} else {
                consoleOutput.consoleWriteLine(players.get(currentPlayer) + " is not getting out of the penalty box");
                isGettingOutOfPenaltyBox = false;
				}
			
		} else {
		
			places[currentPlayer] = places[currentPlayer] + roll;
			if (places[currentPlayer] > 11) places[currentPlayer] = places[currentPlayer] - 12;

            consoleOutput.consoleWriteLine(players.get(currentPlayer)
                    + "'s new location is "
                    + places[currentPlayer]);
            String currentCategoryMessage = "The category is " + currentCategory();
            consoleOutput.consoleWriteLine(currentCategoryMessage);
            askQuestion();
		}
		
	}

    private void askQuestion() {
		if (currentCategory() == "Pop") {
            String popMessage = popQuestions.removeFirst().toString();
            consoleOutput.consoleWriteLine(popMessage);
        }
		if (currentCategory() == "Science")
            consoleOutput.consoleWriteLine(scienceQuestions.removeFirst().toString());
        if (currentCategory() == "Sports")
            consoleOutput.consoleWriteLine(sportsQuestions.removeFirst().toString());
        if (currentCategory() == "Rock")
            consoleOutput.consoleWriteLine(rockQuestions.removeFirst().toString());
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
		if (inPenaltyBox[currentPlayer]){
			if (isGettingOutOfPenaltyBox) {
                consoleOutput.consoleWriteLine("Answer was correct!!!!");
                purses[currentPlayer]++;
                consoleOutput.consoleWriteLine(players.get(currentPlayer)
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

            consoleOutput.consoleWriteLine("Answer was corrent!!!!");
            purses[currentPlayer]++;
            consoleOutput.consoleWriteLine(players.get(currentPlayer)
                    + " now has "
                    + purses[currentPlayer]
                    + " Gold Coins.");

            boolean winner = didPlayerWin();
			currentPlayer++;
			if (currentPlayer == players.size()) currentPlayer = 0;
			
			return winner;
        }
    }

    public boolean wrongAnswer(){
        String questionIncorrectlyAnsweredMessage = "Question was incorrectly answered";
        consoleOutput.consoleWriteLine(questionIncorrectlyAnsweredMessage);
        consoleOutput.consoleWriteLine(players.get(currentPlayer) + " was sent to the penalty box");
        inPenaltyBox[currentPlayer] = true;
		
		currentPlayer++;
		if (currentPlayer == players.size()) currentPlayer = 0;
		return true;
	}


    private boolean didPlayerWin() {
		return !(purses[currentPlayer] == 6);
	}
}
