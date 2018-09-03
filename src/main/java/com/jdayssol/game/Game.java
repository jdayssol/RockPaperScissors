package com.jdayssol.game;

import org.apache.commons.lang3.math.NumberUtils;

import com.jdayssol.strategy.Motion;
import com.jdayssol.strategy.PaperStrategy;
import com.jdayssol.strategy.RandomStrategy;
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
	private int[] results;

	public Game(Player playerOne, Player playerTwo, int nbGame) {
		super();
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
		this.nbGames = nbGame;
		this.results = new int[3];
	}

	/**
	 * Main method. Two player, one with a random strategy and one with a single play strategy play 100 games. 
	 * The result is then printed in the console.
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		System.out.println("Welcome to my Paper-Scissors-Rock program.");

		Player playerOne = new Player("Christian");
		Player playerTwo = new Player("Nils");
		playerOne.setStrategy(new PaperStrategy());
		playerTwo.setStrategy(new RandomStrategy());
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
			System.out.println("Paper Scissors Rock game starts between " + playerOne.getName() + " playing "
					+ playerOne.getStrategy().getName() + " and " + playerTwo.getName() + " playing "
					+ playerTwo.getStrategy().getName() + " for " + nbGames + " round(s).");
			this.start();
			this.printResults();
			System.out.println("Press 'Q' to quit, 'C' to configure another game, or any key to start the same game.");
			choice = InputScanner.getInstance().nextLine();
			if (choice.equalsIgnoreCase("C")) {
				this.configure();
			}
		} while (!choice.equalsIgnoreCase("Q"));
		System.out.println("Thank you and goodbye!");
	}

	/**
	 * Start the game and play it the number of game.
	 */
	protected void start() {
		init();
		for (int i = 0; i < nbGames; i++) {
			int result = play();
			results[result]++;
		}
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

	protected void printResults() {
		System.out.println("Game is over after " + nbGames + " round(s):");
		System.out.println("Player " + playerOne.getName() + " wins " + results[1] + " round(s).");
		System.out.println("Player " + playerTwo.getName() + " wins " + results[2] + " round(s).");
		System.out.println("Number of ties: " + results[0] + ".");
	}

	protected int[] getResults() {
		return results;
	}
	
	private void configure() {
		configureNbGames();
		configurePlayerStrategy(this.playerOne);
		configurePlayerStrategy(this.playerTwo);
	}

	private void configureNbGames() {
		System.out.println("Configure the number of games");
		String nbGameInput;
		do {
			nbGameInput = InputScanner.getInstance().nextLine();
			if (!NumberUtils.isDigits(nbGameInput)) {
				System.out.println("Wrong input, try again please");
			}
		} while (!NumberUtils.isDigits(nbGameInput));
		this.nbGames = Integer.parseInt(nbGameInput);
	}

	private void configurePlayerStrategy(Player player) {
		System.out.println("Configure player " + player.getName() + " strategy: U ( User ) P (Paper) R ( Random)");
		String playerStrategyInput;
		do {
			playerStrategyInput = InputScanner.getInstance().nextLine();
			if (!(playerStrategyInput.equalsIgnoreCase("U") || playerStrategyInput.equalsIgnoreCase("P")
					|| playerStrategyInput.equalsIgnoreCase("R"))) {
				System.out.println("Wrong input, try again please");
			}
		} while (!(playerStrategyInput.equalsIgnoreCase("R") || playerStrategyInput.equalsIgnoreCase("P")
				|| playerStrategyInput.equalsIgnoreCase("R")));
		switch (playerStrategyInput) {
		case "U":
			player.setStrategy(new UserStrategy());
			break;
		case "P":
			player.setStrategy(new PaperStrategy());
			break;
		case "R":
			player.setStrategy(new RandomStrategy());
			break;
		default:
			System.out.println("Unexpected choice result");
		}
	}

	private void init() {
		results[0] = 0;
		results[1] = 0;
		results[2] = 0;
	}
}
