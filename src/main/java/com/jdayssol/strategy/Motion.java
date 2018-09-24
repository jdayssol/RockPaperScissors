package com.jdayssol.strategy;

import com.jdayssol.game.GameResult;

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
	public RoundResult isWinningAgainst(Motion otherMotion) {
		RoundResult result = RoundResult.Tie;
		//int result;
		if (this == otherMotion)
			result = RoundResult.Tie;
		else if (otherMotion.winnerMotion() == this)
			result = RoundResult.Win;
		else
			result = RoundResult.Lose;
		return result;
	}

	public Motion winnerMotion() {
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
			throw new RuntimeException("Unexpected Motion switch result in  retrieveWinner()");
		}
		return winnerMotion;
	}
}
