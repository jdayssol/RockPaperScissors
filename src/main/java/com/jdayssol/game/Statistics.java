package com.jdayssol.game;

import com.jdayssol.strategy.RoundResult;

public class Statistics {
	private int[] statistics = new int[3];
	
	protected void storeStatistic(RoundResult result)
	{
		statistics[result.ordinal()]++;
	}

	protected int retrieveStatistics(Statistic statistic)
	{
		return statistics[statistic.ordinal()];
	}
	
	protected int retrieveTotal()
	{
		return retrieveStatistics(Statistic.Tie) + retrieveStatistics(Statistic.PlayerOne) + retrieveStatistics(Statistic.PlayerTwo);
	}
}
