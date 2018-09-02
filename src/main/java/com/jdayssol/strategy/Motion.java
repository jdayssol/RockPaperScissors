package com.jdayssol.strategy;

/**
 *  Motion is an enumeration which proposes 3 moves: rock/paper/scissors. 
 *  It also provides a function to return the result of the game between two motions.
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
		int result;
		if(this == motion2) result=0;		
		else if(this == Rock && motion2 == Scissors 
			|| this == Paper && motion2 == Rock 
			|| this == Scissors && motion2 == Paper)
			result=1;
		else result=-1;
		
		return result;
	}
}
