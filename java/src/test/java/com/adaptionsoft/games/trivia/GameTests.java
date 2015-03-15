package com.adaptionsoft.games.trivia;

import static org.junit.Assert.*;

import com.adaptionsoft.games.uglytrivia.ConsoleOutput;
import com.adaptionsoft.games.uglytrivia.Game;
import com.adaptionsoft.games.uglytrivia.TextOutput;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class GameTests {

    private Game gameWithConsoleOutput;
    private Game gameWithTextOutput;
    private String fileName = "system-test.txt";
    @Before
    public void setup(){
        gameWithConsoleOutput = new Game(new ConsoleOutput());
        gameWithTextOutput = new Game(new TextOutput(fileName));
    }

    private ByteArrayOutputStream getConsoleOutput() {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(stream);
        System.setOut(printStream);
        return stream;
    }

    @Test
    public void whenGameIsCreatedNothingIsWrittenToTheOutput(){
        ByteArrayOutputStream stream = getConsoleOutput();
        String emptyString = "";

        assertEquals(emptyString, stream.toString());
    }

    @Test
    public void whenPlayerIsAddedHisNameAndPlayerNumberIsWritten() throws IOException {
        ByteArrayOutputStream stream = getConsoleOutput();
        String playerNameAndNumber = "Adi was added\n" +
                "They are player number 1\n";
        String playerName = "Adi";

        gameWithConsoleOutput.add(playerName);

        assertEquals(playerNameAndNumber, stream.toString());
    }

    @Test
    public void whenTwoPlayersAreAddedTheirNameAndPlayerNumbersAreWritten() throws IOException {
        ByteArrayOutputStream stream = getConsoleOutput();
        String playerNameAndNumber = "Adi was added\n" +
                "They are player number 1\n" +
                "Alex was added\n" +
                "They are player number 2\n";
        String playerName = "Adi";
        String secondPlayerName = "Alex";

        gameWithConsoleOutput.add(playerName);
        gameWithConsoleOutput.add(secondPlayerName);

        assertEquals(playerNameAndNumber, stream.toString());
    }

    @Test
    public void whenRollingDiceNumber1MessageAboutDiceAndPlayerLocationAndScienceCategoryIsWrittenToOutput() throws IOException {
        ByteArrayOutputStream stream = getConsoleOutput();
        gameWithConsoleOutput.add("SomePlayer");

        gameWithConsoleOutput.roll(1);

        assertEquals("SomePlayer was added\n" +
                "They are player number 1\n" +
                "SomePlayer is the current player\n" +
                "They have rolled a 1\n" +
                "SomePlayer's new location is 1\n" +
                "The category is Science\n" +
                "Science Question 0\n", stream.toString());
    }

    @Test
    public void whenInPenaltyBoxAndRollingOddDiceMessageAboutPlayerAndGettingOutOfPenaltyBoxIsWrittenToOutput() throws IOException {
        ByteArrayOutputStream stream = getConsoleOutput();
        gameWithConsoleOutput.add("Adi");
        gameWithConsoleOutput.wrongAnswer();

        gameWithConsoleOutput.roll(3);

        assertEquals("Adi was added\n" +
                "They are player number 1\n" +
                "Question was incorrectly answered\n" +
                "Adi was sent to the penalty box\n" +
                "Adi is the current player\n" +
                "They have rolled a 3\n" +
                "Adi is getting out of the penalty box\n" +
                "Adi's new location is 3\n" +
                "The category is Rock\n" +
                "Rock Question 0\n", stream.toString());
    }

    @Test
    public void whenInPenaltyBoxAndRollingEvenDiceMessageAbouPlayerAndNotGettingOutOfPenaltyBoxIsWrittenToOutput() throws IOException {
        ByteArrayOutputStream stream = getConsoleOutput();
        gameWithConsoleOutput.add("Adi");
        gameWithConsoleOutput.wrongAnswer();

        gameWithConsoleOutput.roll(2);

        assertEquals("Adi was added\n" +
                "They are player number 1\n" +
                "Question was incorrectly answered\n" +
                "Adi was sent to the penalty box\n" +
                "Adi is the current player\n" +
                "They have rolled a 2\n" +
                "Adi is not getting out of the penalty box\n", stream.toString());
    }

    @Test
    public void whenRollingDiceNumber4AMessageAboutDiceAndPlayerLocationAndPopCategoryIsWrittenToOutput() throws IOException {
        ByteArrayOutputStream stream = getConsoleOutput();
        gameWithConsoleOutput.add("Adi");

        gameWithConsoleOutput.roll(4);

        assertEquals("Adi was added\n" +
                "They are player number 1\n" +
                "Adi is the current player\n" +
                "They have rolled a 4\n" +
                "Adi's new location is 4\n" +
                "The category is Pop\n" +
                "Pop Question 0\n", stream.toString());

    }

    @Test
    public void whenRollingDiceNumber2AMessageAboutDiceAndPlayerLocationAndSportCategoryIsWrittenToOutput() throws IOException {
        ByteArrayOutputStream stream = getConsoleOutput();
        gameWithConsoleOutput.add("Adi");

        gameWithConsoleOutput.roll(2);

        assertEquals("Adi was added\n" +
                "They are player number 1\n" +
                "Adi is the current player\n" +
                "They have rolled a 2\n" +
                "Adi's new location is 2\n" +
                "The category is Sports\n" +
                "Sports Question 0\n", stream.toString());

    }

    @Test
    public void whenCorrectlyAnsweredAndInPenaltyBoxAndGettingOutOfPenaltyBoxThenMessageAboutCorrectAnswerAndWinningGoldenCoinsIsWrittenToOutput() throws IOException {
        ByteArrayOutputStream stream = getConsoleOutput();
        gameWithConsoleOutput.add("Adi");
        gameWithConsoleOutput.wrongAnswer();
        gameWithConsoleOutput.roll(3);

        gameWithConsoleOutput.wasCorrectlyAnswered();

        assertEquals("Adi was added\n" +
                "They are player number 1\n" +
                "Question was incorrectly answered\n" +
                "Adi was sent to the penalty box\n" +
                "Adi is the current player\n" +
                "They have rolled a 3\n" +
                "Adi is getting out of the penalty box\n" +
                "Adi's new location is 3\n" +
                "The category is Rock\n" +
                "Rock Question 0\n" +
                "Answer was correct!!!!\n" +
                "Adi now has 1 Gold Coins.\n", stream.toString());
    }

    @Test
    public void whenCorrectlyAnsweredThenWinningGoldenCoinsMessageIsWrittenToOutput() throws IOException {
        ByteArrayOutputStream stream = getConsoleOutput();
        gameWithConsoleOutput.add("Adi");

        gameWithConsoleOutput.wasCorrectlyAnswered();

        assertEquals("Adi was added\n" +
                "They are player number 1\n" +
                "Answer was corrent!!!!\n" +
                "Adi now has 1 Gold Coins.\n", stream.toString());
    }

    @Test
    public void whenCorrectlyAnsweredThenWinningGoldenCoinMessageIsWrittenToTextFile() throws IOException {
        Path path = FileSystems.getDefault().getPath(fileName);
        Files.deleteIfExists(path);
        gameWithTextOutput.add("Adi");

        gameWithTextOutput.wasCorrectlyAnswered();

        assertEquals("Adi was added\n" +
                "They are player number 1\n" +
                "Answer was corrent!!!!\n" +
                "Adi now has 1 Gold Coins.\n", readText(fileName));
    }

    private String readText(String fileName) throws IOException {
        Path path = FileSystems.getDefault().getPath(fileName);
        List<String> lines = Files.readAllLines(path, Charset.defaultCharset());

        String text = "";
        for (String line : lines) {
            text += line.concat("\n");
        }

        return text;
    }
}