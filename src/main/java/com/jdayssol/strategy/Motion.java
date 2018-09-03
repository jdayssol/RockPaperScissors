package com.jdayssol.strategy;

/**
 * Motion is an enumeration which proposes 3 moves: rock / paper / scissors.
 * It also provides a function to return the result of the game between two motions.
 */
public enum Motion {

	Rock, Paper, Scissors;

	/**
	 * Return the result of the game
	 * @param otherMotion : the motion of the other player.
	 * @return 0 = tie, 1 = Player win, 2 = Other player win.
	 */
	public int getResult(Motion otherMotion) {
		int result;
		if (this == otherMotion)
			result = 0;
		else if (this == otherMotion.getWinner())
			result = 1;
		else
			result = 2;
		return result;
	}

	public Motion getWinner() {
		Motion winnerMotion = null;
		switch (this) {
		case Rock:
			winnerMotion = Motion.Paper;
			break;
		case Paper:
			winnerMotion = Motion.Scissors;
			break;
		case Scissors:
			winnerMotion = Motion.Rock;
			break;
		default:
			throw new RuntimeException("Unexpected Motion switch result in getWinner()");
		}
		return winnerMotion;
	}
}
