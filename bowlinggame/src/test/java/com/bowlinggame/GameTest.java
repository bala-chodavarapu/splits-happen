package com.bowlinggame;

import com.bowlinggame.Game;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/*
 * Class to test the total scores 
 */

public class GameTest {
	private Game game;

	@Before
	public void setUp() {
		game = new Game();
	}

	@Test
	public void ifScoreAllStrike() {
		try {
			assertEquals(300, game.calculateScore("XXXXXXXXXXXX"));
			System.out.println("The total score for all strikes in a game is 300");
		} catch (AssertionError e) {
			System.out.println("There is an error in calculating the score for all strikes " + e.toString());
			throw e;
		}
	}

	@Test
	public void ifScoreNineAndMiss() {
		try {
			assertEquals(90, game.calculateScore("9-9-9-9-9-9-9-9-9-9-"));
			System.out.println("The total score at the end of the game for score board \"9-9-9-9-9-9-9-9-9-9-\" is 90");
		} catch (AssertionError e) {
			System.out.println("There is an error in calculating the score for score board \"9-9-9-9-9-9-9-9-9-9-\" "
					+ e.toString());
			throw e;
		}
	}

	@Test
	public void ifScoreFiveAndStrike() {
		try {
			assertEquals(150, game.calculateScore("5/5/5/5/5/5/5/5/5/5/5"));
			System.out.println("The total score at the end of the game for all 5's and strikes is 150");
		} catch (AssertionError e) {
			System.out.println("There is an error in calculating the score for score board with all 5's and strikes "
					+ e.toString());
			throw e;
		}
	}

	@Test
	public void ifScoreIsCombination() {
		try {
			assertEquals(167, game.calculateScore("X7/9-X-88/-6XXX81"));
			System.out.println("The total score at the end of the game for score board \"X7/9-X-88/-6XXX81\" is 167");
		} catch (AssertionError e) {
			System.out.println(
					"There is an error in calculating the score for score board \"X7/9-X-88/-6XXX81\" " + e.toString());
			throw e;
		}
	}
}
