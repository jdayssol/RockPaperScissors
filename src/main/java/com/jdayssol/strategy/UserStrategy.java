package com.jdayssol.strategy;

import java.util.HashMap;
import com.jdayssol.utility.InputScanner;

/**
 * Play the user choice move.
 */
public class UserStrategy implements Strategy {

	private final HashMap<String,Motion> motions = new HashMap<String,Motion>()
	{
		private static final long serialVersionUID = 1L;
		{
			put("R", Motion.Rock);
			put("P", Motion.Paper);
			put("S", Motion.Scissors);
		}
	};


	@Override
	public Motion retrieveNextMove() {
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
