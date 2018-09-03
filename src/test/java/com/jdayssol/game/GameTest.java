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

	Player playerOne = new Player("Christian");
	Player playerTwo = new Player("Nils");
	
	@Rule
	public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

	
	@Test
	public void run_100_games()
	{		
		playerOne.setStrategy(new PaperStrategy());
		playerTwo.setStrategy(new RandomStrategy());
		Game game = new Game(playerOne,playerTwo,100);
		game.start();
		int totalResult = game.getResults()[0] + game.getResults()[1] + game.getResults()[2];
		Assert.assertEquals(100,totalResult);
	}


	@Test
	public void run_a_game_paper_against_random()
	{
		playerOne.setStrategy(new PaperStrategy());
		playerTwo.setStrategy(new RandomStrategy());
		Game game = new Game(playerOne,playerTwo,1);
		Integer result = game.play();
		String possibleResults = "0 1 2";
		Assert.assertThat(possibleResults, CoreMatchers.containsString(result.toString()));
	}
	
	@Test
	public void run_1_game_user_against_random()
	{
		systemInMock.provideLines("R");
		playerOne.setStrategy(new UserStrategy());
		playerTwo.setStrategy(new RandomStrategy());
		Game game = new Game(playerOne,playerTwo,1);
		Integer result = game.play();
		System.out.println("run_one_game : result is " + result +".");
		String possibleResults = "0 1 2";
		Assert.assertThat(possibleResults, CoreMatchers.containsString(result.toString()));
	}
	
	@Test
	public void run_menu()
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
