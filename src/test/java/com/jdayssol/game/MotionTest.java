package com.jdayssol.game;

import org.junit.Assert;
import org.junit.Test;

import com.jdayssol.strategy.Motion;
import com.jdayssol.strategy.RoundResult;

public class MotionTest {

	@Test
	public void paper_should_win_against_rock()
	{
		Assert.assertEquals(RoundResult.Win,Motion.Paper.isWinningAgainst(Motion.Rock));
	}
	
	@Test
	public void rock_should_win_against_scissors()
	{
		Assert.assertEquals(RoundResult.Win,Motion.Rock.isWinningAgainst(Motion.Scissors));
	}
	
	@Test
	public void scissors_should_win_against_paper()
	{
		Assert.assertEquals(RoundResult.Win,Motion.Rock.isWinningAgainst(Motion.Scissors));
	}
	
	@Test
	public void paper_should_lose_against_scissors()
	{
		Assert.assertEquals(RoundResult.Lose,Motion.Paper.isWinningAgainst(Motion.Scissors));
	}
	
	@Test
	public void paper_should_tie_against_paper()
	{
		Assert.assertEquals(RoundResult.Tie,Motion.Paper.isWinningAgainst(Motion.Paper));
	}
}
