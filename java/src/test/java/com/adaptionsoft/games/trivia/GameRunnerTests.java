package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.trivia.runner.GameRunner;
import org.junit.Ignore;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by adi on 3/21/15.
 */
public class GameRunnerTests {
    @Test
    @Ignore
    public void testRunner(){
        ByteArrayOutputStream stream = getConsoleOutput();
        GameRunner gameRunner = new GameRunner();
        gameRunner.main(null);

        assertEquals("Chet was added\n" +
                "They are player number 1\n" +
                "Pat was added\n" +
                "They are player number 2\n" +
                "Sue was added\n" +
                "They are player number 3\n" +
                "Chet is the current player\n" +
                "They have rolled a 2\n" +
                "Chet's new location is 2\n" +
                "The category is Sports\n" +
                "Sports Question 0\n" +
                "Question was incorrectly answered\n" +
                "Chet was sent to the penalty box\n" +
                "Pat is the current player\n" +
                "They have rolled a 4\n" +
                "Pat's new location is 4\n" +
                "The category is Pop\n" +
                "Pop Question 0\n" +
                "Answer was corrent!!!!\n" +
                "Pat now has 1 Gold Coins.\n" +
                "Sue is the current player\n" +
                "They have rolled a 1\n" +
                "Sue's new location is 1\n" +
                "The category is Science\n" +
                "Science Question 0\n" +
                "Answer was corrent!!!!\n" +
                "Sue now has 1 Gold Coins.\n" +
                "Chet is the current player\n" +
                "They have rolled a 2\n" +
                "Chet is not getting out of the penalty box\n" +
                "Pat is the current player\n" +
                "They have rolled a 4\n" +
                "Pat's new location is 8\n" +
                "The category is Pop\n" +
                "Pop Question 1\n" +
                "Answer was corrent!!!!\n" +
                "Pat now has 2 Gold Coins.\n" +
                "Sue is the current player\n" +
                "They have rolled a 4\n" +
                "Sue's new location is 5\n" +
                "The category is Science\n" +
                "Science Question 1\n" +
                "Answer was corrent!!!!\n" +
                "Sue now has 2 Gold Coins.\n" +
                "Chet is the current player\n" +
                "They have rolled a 2\n" +
                "Chet is not getting out of the penalty box\n" +
                "Pat is the current player\n" +
                "They have rolled a 5\n" +
                "Pat's new location is 1\n" +
                "The category is Science\n" +
                "Science Question 2\n" +
                "Answer was corrent!!!!\n" +
                "Pat now has 3 Gold Coins.\n" +
                "Sue is the current player\n" +
                "They have rolled a 5\n" +
                "Sue's new location is 10\n" +
                "The category is Sports\n" +
                "Sports Question 1\n" +
                "Answer was corrent!!!!\n" +
                "Sue now has 3 Gold Coins.\n" +
                "Chet is the current player\n" +
                "They have rolled a 1\n" +
                "Chet is getting out of the penalty box\n" +
                "Chet's new location is 3\n" +
                "The category is Rock\n" +
                "Rock Question 0\n" +
                "Answer was correct!!!!\n" +
                "Chet now has 1 Gold Coins.\n" +
                "Pat is the current player\n" +
                "They have rolled a 3\n" +
                "Pat's new location is 4\n" +
                "The category is Pop\n" +
                "Pop Question 2\n" +
                "Answer was corrent!!!!\n" +
                "Pat now has 4 Gold Coins.\n" +
                "Sue is the current player\n" +
                "They have rolled a 3\n" +
                "Sue's new location is 1\n" +
                "The category is Science\n" +
                "Science Question 3\n" +
                "Answer was corrent!!!!\n" +
                "Sue now has 4 Gold Coins.\n" +
                "Chet is the current player\n" +
                "They have rolled a 2\n" +
                "Chet is not getting out of the penalty box\n" +
                "Pat is the current player\n" +
                "They have rolled a 1\n" +
                "Pat's new location is 5\n" +
                "The category is Science\n" +
                "Science Question 4\n" +
                "Answer was corrent!!!!\n" +
                "Pat now has 5 Gold Coins.\n" +
                "Sue is the current player\n" +
                "They have rolled a 2\n" +
                "Sue's new location is 3\n" +
                "The category is Rock\n" +
                "Rock Question 1\n" +
                "Answer was corrent!!!!\n" +
                "Sue now has 5 Gold Coins.\n" +
                "Chet is the current player\n" +
                "They have rolled a 5\n" +
                "Chet is getting out of the penalty box\n" +
                "Chet's new location is 8\n" +
                "The category is Pop\n" +
                "Pop Question 3\n" +
                "Answer was correct!!!!\n" +
                "Chet now has 2 Gold Coins.\n" +
                "Pat is the current player\n" +
                "They have rolled a 4\n" +
                "Pat's new location is 9\n" +
                "The category is Science\n" +
                "Science Question 5\n" +
                "Answer was corrent!!!!\n" +
                "Pat now has 6 Gold Coins.\n", stream);
    }

    private ByteArrayOutputStream getConsoleOutput() {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(stream);
        System.setOut(printStream);
        return stream;
    }
}
