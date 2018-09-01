package com.jdayssol.game;

import com.jdayssol.strategy.Motion;
import com.jdayssol.strategy.Strategy;

/**
 * Class Player provide attributes name and strategy. 
 */
public class Player {

	private String name;
	private Strategy strategy;
	
	public Player(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}
	
	public Motion play()
	{
		return strategy.getNextMove();
	}
}
