package com.jdayssol.strategy;

/**
 * Play the motion Paper every time.
 */
public class PaperStrategy implements Strategy {

	@Override
	public Motion getNextMove() {
		return Motion.Paper;
	}

	@Override
	public String getName() {
		return "PaperStrategy";
	}

}
