package com.jdayssol.strategy;

/**
 * Play the motion Paper everytime.
 */
public class PaperStrategy implements Strategy {

	@Override
	public Motion getNextMove() {
		return Motion.Paper;
	}

}
