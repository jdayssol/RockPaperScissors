package com.jdayssol.strategy;

import org.junit.Assert;
import org.junit.Test;

import com.jdayssol.strategy.Motion;
import com.jdayssol.strategy.Result;

public class MotionTest {

	@Test
	public void paper_should_win_against_rock()
	{
		Assert.assertEquals(Result.Win,Motion.Paper.isWinningAgainst(Motion.Rock));
	}
	
	@Test
	public void rock_should_win_against_scissors()
	{
		Assert.assertEquals(Result.Win,Motion.Rock.isWinningAgainst(Motion.Scissors));
	}
	
	@Test
	public void scissors_should_win_against_paper()
	{
		Assert.assertEquals(Result.Win,Motion.Rock.isWinningAgainst(Motion.Scissors));
	}
	
	@Test
	public void paper_should_lose_against_scissors()
	{
		Assert.assertEquals(Result.Lose,Motion.Paper.isWinningAgainst(Motion.Scissors));
	}
	
	@Test
	public void paper_should_tie_against_paper()
	{
		Assert.assertEquals(Result.Tie,Motion.Paper.isWinningAgainst(Motion.Paper));
	}
}
