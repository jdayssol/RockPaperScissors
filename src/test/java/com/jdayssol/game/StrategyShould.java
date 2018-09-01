package com.jdayssol.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.jdayssol.strategy.Motion;
import com.jdayssol.strategy.PaperStrategy;
import com.jdayssol.strategy.RandomStrategy;
import com.jdayssol.strategy.Strategy;

public class StrategyShould {

	@Test
	public void paperStrategy_should_return_paper()
	{
		Strategy paperStrategy = new PaperStrategy();
		Motion motion = paperStrategy.getNextMove();
		assertEquals(Motion.Paper,motion);
	}
	
	@Test
	public void randomStrategy_should_return_random_motion()
	{
		Strategy randomStrategy = new RandomStrategy();
		for(int i =0;i < 10; i++)
		{
			Motion motion = randomStrategy.getNextMove();
			//System.out.println(motion);
			assertNotNull(motion);
		}	
	}
}
