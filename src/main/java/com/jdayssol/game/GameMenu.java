package com.jdayssol.game;

import static com.jdayssol.utility.Output.print;

import java.util.HashMap;

import org.apache.commons.lang3.math.NumberUtils;

import com.jdayssol.strategy.PaperStrategy;
import com.jdayssol.strategy.RandomStrategy;
import com.jdayssol.strategy.Strategy;
import com.jdayssol.strategy.UserStrategy;
import com.jdayssol.utility.InputScanner;

/**
 * Provide a menu to launch the game Paper Scissors Rock
 * @author jdayssol
 *
 */
public class GameMenu {
	
	private Game game;
	
	public GameMenu(Game game) {
		super();
		this.game = game;
	}

	private final HashMap<String,Strategy> inputStrategies = new HashMap<String,Strategy>()
	{
		private static final long serialVersionUID = 1L;
		{
				put("U", new UserStrategy());
				put("P", new PaperStrategy());
				put("R", new RandomStrategy());
		}
	};
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
		GameMenu gameMenu = new GameMenu(game);
		gameMenu.callMenu();
	}

	/**
	 * Call a menu to play the game several times and configures it.
	 */
	public void callMenu() {
		String choice;
		do {
			print("Paper Scissors Rock game starts between %s playing %s  and %s playing %s for %d round(s).",
					game.getPlayerOne().getName(),
					game.getPlayerOne().getStrategy().getName(),
					game.getPlayerTwo().getName(),
					game.getPlayerTwo().getStrategy().getName(),
					game.getNumberOfGames());
			game.start();
			printResults();
			print("Press 'Q' to quit, 'C' to configure another game, or any key to start the same game.");
			choice = InputScanner.getInstance().nextLine();
			if (choice.equalsIgnoreCase("C")) {
				this.configure();
			}
		} while (!choice.equalsIgnoreCase("Q"));
		print("Thank you and goodbye!");
	}
	
	private void configure() {
		configureNumberOfGames();
		configurePlayerStrategy(game.getPlayerOne());
		configurePlayerStrategy(game.getPlayerTwo());
	}

	private void configureNumberOfGames() {
		print("Configure the number of games: ");
		String numberOfGamesInput;
		do {
			numberOfGamesInput = InputScanner.getInstance().nextLine();
			if (!NumberUtils.isDigits(numberOfGamesInput)) {
				print("Wrong input, try again please");
			}
		} while (!NumberUtils.isDigits(numberOfGamesInput));
		game.setNumberOfGames(Integer.parseInt(numberOfGamesInput));
	}

	private void configurePlayerStrategy(Player player) {
		print("Configure player " + player.getName() + " strategy: U ( User ) P (Paper) R ( Random)");
		String strategyInput;
		do {
			strategyInput=InputScanner.getInstance().nextLine();
			if (!inputStrategies.containsKey(strategyInput)) {
				print("Wrong input, try again please");
			}
		} while (!inputStrategies.containsKey(strategyInput));
		player.setStrategy(inputStrategies.get(strategyInput));
	}
	
	private void printResults() {
		print("Game is over after %d round(s):",game.getNumberOfGames());
		print("Player %s wins %d round(s).",game.getPlayerOne().getName(),game.getResults().retrieveResult(GameResult.PlayerOne));		
		print("Player %s wins %d round(s).",game.getPlayerTwo().getName(),game.getResults().retrieveResult(GameResult.PlayerTwo));
		print("Number of ties: %d.",game.getResults().retrieveResult(GameResult.Tie));
	}

	public Game getGame() {
		return game;
	}
}
