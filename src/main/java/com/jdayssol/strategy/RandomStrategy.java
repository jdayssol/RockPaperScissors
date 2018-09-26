package com.jdayssol.strategy;

import java.util.Random;

/**
 * Play a random move. Use Random.nextInt to generate random.
 */
public class RandomStrategy implements Strategy {

	protected Random random = new Random(); // Random need to use the same seed to maintain a good random algorithm.
	
	@Override
	public Motion retrieveMotion() {
		Motion motion = Motion.values()[getNextRandomNumber(random)];
		return motion;
	}

	protected int getNextRandomNumber(Random random){
		return random.nextInt(3);
	}
	
	@Override
	public String getName() {
		return "Random Strategy";
	}


}
