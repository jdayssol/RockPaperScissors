package com.jdayssol.game;

import com.jdayssol.strategy.Motion;
import com.jdayssol.strategy.RoundResult;
/**
 * Rock Paper Scissors Game between two computer player. Has a start method
 * which launches the game between the two players a parameterized number of
 * times. Contains also the main method.
 */
public class Game {
	
	private Player playerOne;
	private Player playerTwo;
	private int numberOfGames;
	private GameResults results = new GameResults();


	public Game(Player playerOne, Player playerTwo, int numberOfGames) {
		super();
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
		this.setNumberOfGames(numberOfGames);
	}

	/**
	 * Start the game and play it the number of game.
	 */
	public void start() {
		init();
		for (int i = 0; i < numberOfGames; i++) {
			RoundResult result = playOneRound();
			results.storeResult(result);
		}
	}

	/**
	 * Play one round and return the result.
	 * @return Result result.
	 */
	protected RoundResult playOneRound() {
		Motion motionPlayerOne = playerOne.nextMove();
		Motion motionPlayerTwo = playerTwo.nextMove();
		return motionPlayerOne.isWinningAgainst(motionPlayerTwo);
	}

	private void init() {
		results = new GameResults();
	}
	
	protected GameResults getResults() {
		return results;
	}

	protected Player getPlayerOne() {
		return playerOne;
	}

	protected Player getPlayerTwo() {
		return playerTwo;
	}

	protected int getNumberOfGames() {
		return numberOfGames;
	}
	
	public void setNumberOfGames(int numberOfGames) {
		this.numberOfGames = numberOfGames;
	}
}
