package com.jdayssol.strategy;

/**
 * Interface Strategy provides a function that will return the next Motion.
 * Since Strategy is an interface,you can create a lot of strategies using this interface without modifying the rest of the program.
 */
public interface Strategy {

	public Motion getNextMove();
}
