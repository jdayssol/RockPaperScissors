package com.jdayssol.game;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import com.jdayssol.strategy.PaperStrategy;
import com.jdayssol.strategy.RandomStrategy;
import com.jdayssol.strategy.UserStrategy;

public class GameTest {

	Player playerOne = new Player("Player One",new PaperStrategy());
	Player playerTwo = new Player("Player Two",new RandomStrategy());
	
	@Rule
	public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

	
	@Test
	public void run_100_games_should_return_100_result()
	{		
		Game game = new Game(playerOne,playerTwo,100);
		game.start();
		int totalResult = game.getResults()[0] + game.getResults()[1] + game.getResults()[2];
		Assert.assertEquals(100,totalResult);
	}


	@Test
	public void run_1_game_paper_against_random_should_return_random_result()
	{
		Game game = new Game(playerOne,playerTwo,1);
		Integer result = game.playOneRound();
		String possibleResults = "0 1 2";
		Assert.assertThat(possibleResults, CoreMatchers.containsString(result.toString()));
	}
	
	@Test
	public void run_1_game_user_against_random_should_return_random_result()
	{
		systemInMock.provideLines("R");
		playerOne.setStrategy(new UserStrategy());
		playerTwo.setStrategy(new RandomStrategy());
		Game game = new Game(playerOne,playerTwo,1);
		Integer result = game.playOneRound();
		System.out.println("run_one_game : result is " + result +".");
		String possibleResults = "0 1 2";
		Assert.assertThat(possibleResults, CoreMatchers.containsString(result.toString()));
	}
	
	@Test
	public void run_menu_1_game_user_against_random_should_return_random_result()
	{
		systemInMock.provideLines("R","Q");
		playerOne.setStrategy(new UserStrategy());
		playerTwo.setStrategy(new RandomStrategy());
		Game game = new Game(playerOne,playerTwo,1);
		game.callMenu();
		int totalResult = game.getResults()[0] + game.getResults()[1] + game.getResults()[2];
		Assert.assertEquals(1,totalResult);
	}
}
