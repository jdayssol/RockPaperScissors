package com.jdayssol.game;

import com.jdayssol.strategy.RoundResult;

public class GameResults {
	private int[] results = new int[3];
	
	protected void storeResult(RoundResult result)
	{
		results[result.ordinal()]++;
	}

	protected int retrieveResult(GameResult result)
	{
		return results[result.ordinal()];
	}
	
	protected int retrieveTotal()
	{
		return retrieveResult(GameResult.Tie) + retrieveResult(GameResult.PlayerOne) + retrieveResult(GameResult.PlayerTwo);
	}
}
