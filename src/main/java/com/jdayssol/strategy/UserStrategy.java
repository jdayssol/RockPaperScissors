package com.jdayssol.strategy;

import com.jdayssol.utility.InputScanner;

/**
 * Play the user choice move.
 */
public class UserStrategy implements Strategy {

	@Override
	public Motion getNextMove() {
		System.out.println("Type your move : R (Rock) / P (Paper) / S (Scissors)");
		String choice;
		Motion motion = null;
		do {
			choice = InputScanner.getInstance().nextLine();
			if (!(choice.equalsIgnoreCase("R") || choice.equalsIgnoreCase("P") || choice.equalsIgnoreCase("S"))) {
				System.out.println("Wrong input, try again please");
			}
		} while (!(choice.equalsIgnoreCase("R") || choice.equalsIgnoreCase("P") || choice.equalsIgnoreCase("S")));

		switch (choice) {
		case "R":
			motion = Motion.Rock;
			break;
		case "P":
			motion = Motion.Paper;
			break;
		case "S":
			motion = Motion.Scissors;
			break;
		default:
			throw new RuntimeException("Unexpected switch result getNextMove()");
		}
		return motion;
	}

	@Override
	public String getName() {
		return "User Strategy";
	}

}
