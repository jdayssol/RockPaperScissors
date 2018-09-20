package com.jdayssol.strategy;

import java.util.HashMap;
import com.jdayssol.utility.InputScanner;

/**
 * Play the user choice move.
 */
public class UserStrategy implements Strategy {

	HashMap<String, Motion> motions = new HashMap<String, Motion>();

	public UserStrategy() {
		motions.put("R", Motion.Rock);
		motions.put("P", Motion.Paper);
		motions.put("S", Motion.Scissors);
	}

	@Override
	public Motion getNextMove() {
		System.out.println("Type your move : R (Rock) / P (Paper) / S (Scissors)");
		String choice;
		do {
			choice = InputScanner.getInstance().nextLine();
			if (!motions.containsKey(choice)) {
				System.out.println("Wrong input, try again please");
			}
		} while (!motions.containsKey(choice));
		return motions.get(choice);
	}

	@Override
	public String getName() {
		return "User Strategy";
	}
}
