package com.jdayssol.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import com.jdayssol.strategy.Motion;
import com.jdayssol.strategy.PaperStrategy;
import com.jdayssol.strategy.RandomStrategy;
import com.jdayssol.strategy.Strategy;
import com.jdayssol.strategy.UserStrategy;

public class StrategyTest {

	@Rule
	public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

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
		Motion motion = randomStrategy.getNextMove();
		assertNotNull(motion);
	}
	
	@Test
	public void userStrategy_should_return_rock()
	{
		systemInMock.provideLines("R");
		Strategy userStrategy = new UserStrategy();
		Motion motion = userStrategy.getNextMove();
		assertEquals(Motion.Rock,motion);
	}
}
