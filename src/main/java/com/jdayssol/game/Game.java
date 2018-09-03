package com.jdayssol.game;

import org.apache.commons.lang3.math.NumberUtils;
import com.jdayssol.library.InputScanner;
import com.jdayssol.strategy.Motion;
import com.jdayssol.strategy.PaperStrategy;
import com.jdayssol.strategy.RandomStrategy;
import com.jdayssol.strategy.UserStrategy;

/**
 * Rock Paper Scissors Game between two computer player. Has a start method
 * which launches the game between thetwo players a parameterized number of
 * times. Contains also the main method.
 */
public class Game {
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
	 * Main method. Two player, one with a random stategy and one with a single
	 * play strategy play 100 games. The result is then printed in the console.
	 * 
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
		game.menu();
	}

	protected void menu() {
		String choice;
		do {
			System.out.println("Paper Scissors Rock game starts between " + playerOne.getName() + " playing "
					+ playerOne.getStrategy().getName() + " and " + playerTwo.getName() + " playing "
					+ playerTwo.getStrategy().getName() + " for " + nbGames + " round(s).");
			this.start();
			this.printResult();
			System.out.println("Press 'Q' to quit, 'C' to configure another game, or any key to start the same game.");
			choice = InputScanner.getInstance().nextLine();
			if (choice.equalsIgnoreCase("C")) {
				this.configureGame();
			}
		} while (!choice.equalsIgnoreCase("Q"));
		System.out.println("Thank you and goodbye!");
		// We can now close the scanner
		InputScanner.getInstance().close();
	}

	/**
	 * Start the game and play the number of game.
	 */
	protected void start() {
		initStatistics();
		for (int i = 0; i < nbGames; i++) {
			int result = play();
			switch (result) {
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
	}

	/**
	 * Play one round and return the result.
	 * 
	 * @return int result.
	 */
	protected int play() {
		Motion motionPlayerOne = playerOne.nextMove();
		Motion motionPlayerTwo = playerTwo.nextMove();
		return motionPlayerOne.getResult(motionPlayerTwo);
	}

	protected void printResult() {
		System.out.println("Game is over after " + nbGames + " round(s):");
		System.out.println("Player " + playerOne.getName() + " wins " + statistics[1] + " round(s).");
		System.out.println("Player " + playerTwo.getName() + " wins " + statistics[2] + " round(s).");
		System.out.println("Number of ties: " + statistics[0] + ".");
	}

	protected int[] getStatistics() {
		return statistics;
	}
	
	private void configureGame() {
		configureNbGame();
		configurePlayerStrategy(this.playerOne);
		configurePlayerStrategy(this.playerTwo);
	}

	private void configureNbGame() {
		System.out.println("Configure number of game");
		String nbGameInput;
		do {
			nbGameInput = InputScanner.getInstance().nextLine();
			if (!NumberUtils.isCreatable(nbGameInput)) {
				System.out.println("Wrong input, try again please");
			}
		} while (NumberUtils.isCreatable(nbGameInput));
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

	private void initStatistics() {
		statistics[0] = 0;
		statistics[1] = 0;
		statistics[2] = 0;
	}
}
