package com.jdayssol.game;

import java.util.Scanner;

import com.jdayssol.strategy.Motion;
import com.jdayssol.strategy.PaperStrategy;
import com.jdayssol.strategy.RandomStrategy;

/**
 * Rock Paper Scissors Game between two computer player.
 * Has a start method which launches the game between thetwo players a parameterized number of times.
 * Contains also the main method.
 */
public class Game 
{
	private Player playerOne;
	private Player playerTwo;
	private int nbGames;
	private int[] statistics;
	

	public Game(Player playerOne, Player playerTwo, int nbGame) {
		super();
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
		this.nbGames = nbGame;
		this.statistics = new int[3];
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
		System.out.println("Welcome to my Paper-Scissors-Rock program.");
		Scanner scan = new Scanner(System.in);
		Player playerOne = new Player("Christian");
		Player playerTwo = new Player("Nils");
		playerOne.setStrategy(new PaperStrategy());
		playerTwo.setStrategy(new RandomStrategy());
		Game game = new Game(playerOne,playerTwo,100);
		String choice;
		do
		{
			game.start();
			System.out.println("Press 'Q' to quit, or any key to continue.");
			choice = scan.next();
		}while(!choice.equalsIgnoreCase("Q"));
		System.out.println("Thank you and goodbye!");
		scan.close();
    }

	/**
	 * Start the game and play the number of game.
	 */
	public void start() {
		System.out.println("Paper Scissors Rock game starts between " + playerOne.getName() + " and " + playerTwo.getName() + " for "+ nbGames + " round(s).");
		initStatistics();
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
			default:
		        System.out.println("Unexpected round result");
		        throw new RuntimeException("Unexpected round result");
			}
		}
		printResult();		
	}

	/**
	 * Play one round and return the result.
	 * @return int result.
	 */
	protected int play() {
		Motion motionPlayerOne = playerOne.nextMove();
		Motion motionPlayerTwo = playerTwo.nextMove();
		return motionPlayerOne.getResult(motionPlayerTwo);
	}
	
	protected void printResult() {
		System.out.println("Game is over after " + nbGames+ " round(s):");
		System.out.println( "Player " + playerOne.getName() + " wins " + statistics[1] + " round(s).");
		System.out.println( "Player " + playerTwo.getName() + " wins " + statistics[2] + " round(s).");
		System.out.println( "Number of ties: " + statistics[0] + ".");
	}
	
	protected int[] getStatistics() {
		return statistics;
	}
	
	private void initStatistics()
	{
		statistics[0]=0;
		statistics[1]=0;
		statistics[2]=0;
	}
}
