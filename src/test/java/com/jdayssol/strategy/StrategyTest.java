package com.jdayssol.strategy;

import static org.junit.Assert.assertEquals;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import java.util.Random;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

public class StrategyTest {

	@Rule
	public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

	@Test
	public void paperStrategy_should_return_paper()
	{
		Strategy paperStrategy = new PaperStrategy();
		
		Motion motion = paperStrategy.retrieveMotion();
		
		assertEquals(Motion.Paper,motion);
	}
	
	@Test
	public void randomStrategy_should_return_random_motion()
	{
		
		class DeterministicRandom extends Random{
			private static final long serialVersionUID = 1L;
			int sequentialNum = 0;
	        public DeterministicRandom(){
	            super();
	        }
	        @Override
	        public int nextInt(int number){
	            return sequentialNum++;
	        }
	    }
		
		DeterministicRandom deterministicRandom = new DeterministicRandom();
		
		RandomStrategy myrandomStrategy = new RandomStrategy();
		myrandomStrategy.random = deterministicRandom;
		
		Motion motion = myrandomStrategy.retrieveMotion();
		assertEquals(Motion.Rock,motion);
		
		 motion = myrandomStrategy.retrieveMotion();
		assertEquals(Motion.Paper,motion);
		
		 motion = myrandomStrategy.retrieveMotion();
		assertEquals(Motion.Scissors,motion);
	}
	
	@Test
	public void userStrategy_should_return_rock()
	{
		systemInMock.provideLines("R");
		Strategy userStrategy = new UserStrategy();
		
		Motion motion = userStrategy.retrieveMotion();
		
		assertEquals(Motion.Rock,motion);
	}
}
