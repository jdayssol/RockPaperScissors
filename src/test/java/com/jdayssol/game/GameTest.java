package com.jdayssol.game;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.jdayssol.strategy.PaperStrategy;
import com.jdayssol.strategy.RandomStrategy;
import com.jdayssol.strategy.UserStrategy;

public class GameTest {

	Player playerOne = new Player("Christian");
	Player playerTwo = new Player("Nils");
	

	@Test
	public void run_100_games()
	{		
		playerOne.setStrategy(new PaperStrategy());
		playerTwo.setStrategy(new RandomStrategy());
		Game game = new Game(playerOne,playerTwo,100);
		game.start();
		int totalResult = game.getStatistics()[0] + game.getStatistics()[1] + game.getStatistics()[2];
		Assert.assertEquals(100,totalResult);
	}
		
	@Test
	public void run_1_game_paper_against_random()
	{
		playerOne.setStrategy(new PaperStrategy());
		playerTwo.setStrategy(new RandomStrategy());
		Game game = new Game(playerOne,playerTwo,1);
		Integer result = game.play();
		String possibleResults = "0 1 -1";
		Assert.assertThat(possibleResults, CoreMatchers.containsString(result.toString()));
	}
	
	@Ignore @Test
	public void run_1_game_user_against_random()
	{
		playerOne.setStrategy(new UserStrategy());
		playerTwo.setStrategy(new RandomStrategy());
		Game game = new Game(playerOne,playerTwo,1);
		Integer result = game.play();
		System.out.println("run_one_game : result is " + result +".");
		String possibleResults = "0 1 -1";
		Assert.assertThat(possibleResults, CoreMatchers.containsString(result.toString()));
	}
	
	@Ignore @Test
	public void run_menu()
	{
		playerOne.setStrategy(new UserStrategy());
		playerTwo.setStrategy(new RandomStrategy());
		Game game = new Game(playerOne,playerTwo,1);
		game.menu();
	}
	
}
