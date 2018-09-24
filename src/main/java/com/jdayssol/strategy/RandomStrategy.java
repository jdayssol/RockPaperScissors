package com.jdayssol.strategy;

import java.util.Random;

/**
 * Play a random move. Use Random.nextInt to generate random.
 */
public class RandomStrategy implements Strategy {

	Random rand = new Random();
	@Override
	public Motion getNextMove() {
		int nbRandom = rand.nextInt(3);
		Motion motion = Motion.values()[nbRandom];
		return motion;
	}

	@Override
	public String getName() {
		return "Random Strategy";
	}


}
