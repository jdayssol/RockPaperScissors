package com.jdayssol.strategy;

import java.util.Random;

/**
 * Play a random move. Use Random.nextInt to generate random.
 */
public class RandomStrategy implements Strategy {

	@Override
	public Motion getNextMove() {
		Random rand = new Random();
		int nbRandom = rand.nextInt(3);
		Motion motion = Motion.values()[nbRandom];
		return motion;
	}

	@Override
	public String getName() {
		return "Random Strategy";
	}

}
