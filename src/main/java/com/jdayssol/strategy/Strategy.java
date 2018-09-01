package com.jdayssol.strategy;

/**
 * Interface Strategy will return the next Motion they will play.
 * The variety of strategy can easily increase: since Strategy is a interface,
 * you can create another Strategy using this interface.
 */
public interface Strategy {

	public Motion getNextMove();
}
