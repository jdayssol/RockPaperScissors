package com.jdayssol.game;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import com.jdayssol.strategy.PaperStrategy;
import com.jdayssol.strategy.RandomStrategy;
import com.jdayssol.strategy.UserStrategy;

public class GameMenuTest {
	
	Player playerOne = new Player("Player One",new PaperStrategy());
	Player playerTwo = new Player("Player Two",new RandomStrategy());
	
	@Rule
	public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

	@Test
	public void run_menu_1_game_user_against_random_should_return_random_result()
	{
		systemInMock.provideLines("R","Q");
		playerOne.setStrategy(new UserStrategy());
		playerTwo.setStrategy(new RandomStrategy());
		Game game = new Game(playerOne,playerTwo,1);
		GameMenu gameMenu = new GameMenu(game);
		gameMenu.callMenu();
		int totalResult = gameMenu.getGame().getResults().retrieveTotal();
		Assert.assertEquals(1,totalResult);
	}
}
