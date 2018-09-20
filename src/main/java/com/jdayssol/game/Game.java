package com.jdayssol.game;

import java.util.HashMap;

import org.apache.commons.lang3.math.NumberUtils;

import com.jdayssol.strategy.Motion;
import com.jdayssol.strategy.PaperStrategy;
import com.jdayssol.strategy.RandomStrategy;
import com.jdayssol.strategy.Strategy;
import com.jdayssol.strategy.UserStrategy;
import com.jdayssol.utility.InputScanner;


/**
 * Rock Paper Scissors Game between two computer player. Has a start method
 * which launches the game between the two players a parameterized number of
 * times. Contains also the main method.
 */
public class Game {
	
	private Player playerOne;
	private Player playerTwo;
	private int nbGames;
	private int[] results = new int[3];
	HashMap<String,Strategy> strategies = new HashMap<String,Strategy>();

	public Game(Player playerOne, Player playerTwo, int nbGames) {
		super();
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
		this.nbGames = nbGames;
		strategies.put("U", new UserStrategy());
		strategies.put("P", new PaperStrategy());
		strategies.put("R", new RandomStrategy());
	}

	/**
	 * Main method. Two player, one with a random strategy and one with a single play strategy play 100 games. 
	 * The result is then printed in the console.
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		print("Welcome to my Paper-Scissors-Rock program.");
		Player playerOne = new Player("Christian",new PaperStrategy());
		Player playerTwo = new Player("Nils",new RandomStrategy());
		int nbGames = 100;
		Game game = new Game(playerOne, playerTwo, nbGames);
		game.callMenu();
	}

	/**
	 * Call a menu to play the game several times and configures it.
	 */
	public void callMenu() {
		String choice;
		do {
			print("Paper Scissors Rock game starts between %s playing %s  and %s playing %s for %d round(s).",
					playerOne.getName(),
					playerOne.getStrategy().getName(),
					playerTwo.getName(),
					playerTwo.getStrategy().getName(),
					nbGames);
			this.start();
			this.printResults();
			print("Press 'Q' to quit, 'C' to configure another game, or any key to start the same game.");
			choice = InputScanner.getInstance().nextLine();
			if (choice.equalsIgnoreCase("C")) {
				this.configure();
			}
		} while (!choice.equalsIgnoreCase("Q"));
		print("Thank you and goodbye!");
	}

	/**
	 * Start the game and play it the number of game.
	 */
	protected void start() {
		init();
		for (int i = 0; i < nbGames; i++) {
			int result = playOneRound();
			results[result]++;
		}
	}

	/**
	 * Play one round and return the result.
	 * @return int result.
	 */
	protected int playOneRound() {
		Motion motionPlayerOne = playerOne.nextMove();
		Motion motionPlayerTwo = playerTwo.nextMove();
		return motionPlayerOne.retrieveResult(motionPlayerTwo);
	}

	private void configure() {
		configureNbGames();
		configurePlayerStrategy(this.playerOne);
		configurePlayerStrategy(this.playerTwo);
	}

	private void configureNbGames() {
		print("Configure the number of games: ");
		String nbGameInput;
		do {
			nbGameInput = InputScanner.getInstance().nextLine();
			if (!NumberUtils.isDigits(nbGameInput)) {
				print("Wrong input, try again please");
			}
		} while (!NumberUtils.isDigits(nbGameInput));
		this.nbGames = Integer.parseInt(nbGameInput);
	}

	private void configurePlayerStrategy(Player player) {
		print("Configure player " + player.getName() + " strategy: U ( User ) P (Paper) R ( Random)");
		String strategyInput;
		do {
			strategyInput=InputScanner.getInstance().nextLine();
			if (!strategies.containsKey("strategyInput")) {
				print("Wrong input, try again please");
			}
		} while (!strategies.containsKey("strategyInput"));
		player.setStrategy(strategies.get(strategyInput));
	}
	
	protected void printResults() {
		print("Game is over after %d round(s):",nbGames );
		print("Player %s wins %d round(s).",playerOne.getName(),results[1]);		
		print("Player %s wins %d round(s).",playerTwo.getName(),results[2]);
		print("Number of ties: %d .",results[0]);
	}
	
	protected static void print(String toPrint,Object... args)
	{
		System.out.printf(toPrint,args);
	}
	
	protected static void print(String toPrint)
	{
		System.out.println(toPrint);
	}

	private void init() {
		results = new int[3];
	}
	
	protected int[] getResults() {
		return results;
	}
}
