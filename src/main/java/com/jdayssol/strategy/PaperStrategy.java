package com.jdayssol.strategy;

/**
 * Play the motion Paper everytime.
 */
public class PaperStrategy implements Strategy {

	public Motion getNextMove() {
		return Motion.Paper;
	}

	public String getName() {
		return "PaperStrategy";
	}

}
