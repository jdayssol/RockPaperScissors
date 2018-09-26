package com.jdayssol.game;

import com.jdayssol.strategy.Motion;
import com.jdayssol.strategy.Strategy;

/**
 * Class Player provides attributes name and strategy. 
 */
public class Player {

	private String name;
	private Strategy strategy;
	
	public Player(String name, Strategy strategy) {
		super();
		this.name = name;
		this.strategy = strategy;
	}

	public String getName() {
		return name;
	}

	public Strategy getStrategy() {
		return strategy;
	}

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}
	
	public Motion play()
	{
		return strategy.retrieveMotion();
	}
}
