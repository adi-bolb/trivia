package com.adaptionsoft.games.trivia;

import static org.junit.Assert.*;

import com.adaptionsoft.games.uglytrivia.Game;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

public class SomeTest {

	private ConsoleReader consoleReader;

	@Before
	public void before(){
		consoleReader = new ConsoleReader();
	}

	@Test
	public void true_is_true() throws Exception {
		consoleReader.startReadingFromConsole();
		String expectedRecordedMessage = GoldenMaster.readNext();
		boolean notAWinner;
		Game aGame = new Game();

		aGame.add("Chet");
		aGame.add("Pat");
		aGame.add("Sue");

		int seed = 1;
		Random rand = new Random(seed);

		do {

			aGame.roll(rand.nextInt());

			if (rand.nextInt(9) == 7) {
				notAWinner = aGame.wrongAnswer();
			} else {
				notAWinner = aGame.wasCorrectlyAnswered();
			}

		} while (notAWinner);

		String actual = consoleReader.read();


		//GoldenMaster.write(seed, actual);
		assertEquals(expectedRecordedMessage, actual);
	}
}
