import static com.jdayssol.utility.Output.print;

import com.jdayssol.game.Game;
import com.jdayssol.game.GameMenu;
import com.jdayssol.game.Player;
import com.jdayssol.strategy.PaperStrategy;
import com.jdayssol.strategy.RandomStrategy;

public class Main {
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
}
