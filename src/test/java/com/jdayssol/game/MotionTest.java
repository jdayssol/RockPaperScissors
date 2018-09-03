package com.jdayssol.game;

import org.junit.Assert;
import org.junit.Test;

import com.jdayssol.strategy.Motion;

public class MotionTest {

	@Test
	public void paper_should_win_against_rock()
	{
		Assert.assertEquals(1,Motion.Paper.getResult(Motion.Rock));
	}
	
	@Test
	public void rock_should_win_against_scissors()
	{
		Assert.assertEquals(1,Motion.Rock.getResult(Motion.Scissors));
	}
	
	@Test
	public void scissors_should_win_against_paper()
	{
		Assert.assertEquals(1,Motion.Rock.getResult(Motion.Scissors));
	}
	
	@Test
	public void paper_should_lose_against_scissors()
	{
		Assert.assertEquals(2,Motion.Paper.getResult(Motion.Scissors));
	}
	
	@Test
	public void paper_should_tie_against_paper()
	{
		Assert.assertEquals(0,Motion.Paper.getResult(Motion.Paper));
	}
}
