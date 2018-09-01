package com.jdayssol.game;

import com.jdayssol.strategy.Motion;
import com.jdayssol.strategy.PaperStrategy;
import com.jdayssol.strategy.RandomStrategy;

/**
 * Rock Paper Scissors Game between two computer player.
 * Have a start method which launch the game between two players a parameterized number of time. 
 */
public class Game 
{
	private Player playerOne;
	private Player playerTwo;
	private int nbGames;
	private int[] statistics = new int[3];
	

	public Game(Player playerOne, Player playerTwo, int nbGame) {
		super();
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
		this.nbGames = nbGame;
	}

	/**
	 * Main method. 
	 * Two player, one with a random stategy and one with a single play strategy
	 * play 100 games. 
	 * The result is then printed in the console.
	 * @param args
	 */
	public static void main( String[] args )
    {
		Player playerOne = new Player("Christian");
		Player playerTwo = new Player("Nils");
		playerOne.setStrategy(new PaperStrategy());
		playerTwo.setStrategy(new RandomStrategy());
		Game game = new Game(playerOne,playerTwo,100);
		game.start();
    }

	/**
	 * Start the game and play the number of game.
	 */
	public void start() {
		for(int i = 0;i< nbGames; i++)
		{
			int result = play();
			switch(result)
			{
			case 0:
				statistics[0]++;
				break;
			case 1:
				statistics[1]++;
				break;
			case -1:
				statistics[2]++;
				break;
			}
		}
		printResult();		
	}

	/**
	 * Play one round and return the result.
	 * @return int result.
	 */
	protected int play() {
		Motion motionPlayerOne = playerOne.play();
		Motion motionPlayerTwo = playerTwo.play();
		return motionPlayerOne.getResult(motionPlayerTwo);
	}
	
	protected void printResult() {
		System.out.println("Game is over after " + nbGames+ " round(s).");
		System.out.println( "Player "+playerOne.getName()+" wins " + statistics[1]+ " round(s).");
		System.out.println( "Player "+playerTwo.getName()+" wins " + statistics[2]+ " round(s).");
		System.out.println( "Number of ties: " + statistics[0] + ".");
	}
	
	protected int[] getStatistics() {
		return statistics;
	}
}
