package com.jdayssol.game;

import com.jdayssol.strategy.Motion;
import com.jdayssol.strategy.Strategy;

/**
 * Class Player provides attributes name and strategy. 
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
	
	/**
	 * Return the next move of the player.
	 * @return
	 */
	public Motion nextMove()
	{
		return strategy.getNextMove();
	}
}
