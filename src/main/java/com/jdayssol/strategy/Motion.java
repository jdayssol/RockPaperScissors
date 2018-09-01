package com.jdayssol.strategy;

/**
 * Motion is a enumeration which propose 3 moves : rock / paper / scissors.
 * It also offer a method to return the result between two motions.
 * @author Asus
 *
 */
public enum Motion {

	Rock,Paper,Scissors;
	
	/**
	 * Return the result : 0 = tie, 1 = Player win, -1 = Other player win.
	 * @param motion2: the motion of the other player.
	 * @return
	 */
	public int getResult(Motion motion2)
	{
		if(this == motion2) return 0;		
		if(this == Rock && motion2 == Scissors 
			|| this == Paper && motion2 == Rock 
			|| this == Scissors && motion2 == Paper)
		return 1;
		else return -1;
	}
}
