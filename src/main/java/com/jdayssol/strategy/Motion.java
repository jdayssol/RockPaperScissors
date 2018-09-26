package com.jdayssol.strategy;

/**
 * Motion is an enumeration which proposes 3 moves: rock / paper / scissors.
 * It also provides a function to return the result of the game between two motions.
 */
public enum Motion {

	Rock, Paper, Scissors;

	public Result isWinningAgainst(Motion otherMotion) {
		Result result = Result.Tie;
		if (this == otherMotion)
			result = Result.Tie;
		else if (otherMotion.winner() == this)
			result = Result.Win;
		else
			result = Result.Lose;
		return result;
	}

	private Motion winner() {
		Motion winnerMotion;
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
			throw new RuntimeException("Unexpected Motion switch result in  winner()");
		}
		return winnerMotion;
	}
}
