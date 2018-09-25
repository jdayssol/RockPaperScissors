package com.jdayssol.game;

/**
 * POJO class to access easily to the game information
 * @author JDayssol
 *
 */
public class GameInformation {
	
	private String playerOneName;
	private String strategyOneName;
	private String playerTwoName;
	private String strategyTwoName;
	private int numberOfGames;
	private int playerOneNumberOfWin;
	private int playerTwoNumberOfWin;
	private int numberOfTie;
	
	public GameInformation(String playerOneName, String strategyOneName, String playerTwoName, String strategyTwoName,
			int numberOfGames) {
		super();
		this.playerOneName = playerOneName;
		this.strategyOneName = strategyOneName;
		this.playerTwoName = playerTwoName;
		this.strategyTwoName = strategyTwoName;
		this.numberOfGames = numberOfGames;
	}

	public GameInformation(String playerOneName, String strategyOneName, String playerTwoName, String strategyTwoName,
			int numberOfGames, int playerOneNumberOfWin, int playerTwoNumberOfWin, int numberOfTie) {
		super();
		this.playerOneName = playerOneName;
		this.strategyOneName = strategyOneName;
		this.playerTwoName = playerTwoName;
		this.strategyTwoName = strategyTwoName;
		this.numberOfGames = numberOfGames;
		this.playerOneNumberOfWin = playerOneNumberOfWin;
		this.playerTwoNumberOfWin = playerTwoNumberOfWin;
		this.numberOfTie = numberOfTie;
	}

	public String getPlayerOneName() {
		return playerOneName;
	}

	public String getStrategyOneName() {
		return strategyOneName;
	}

	public String getPlayerTwoName() {
		return playerTwoName;
	}

	public String getStrategyTwoName() {
		return strategyTwoName;
	}

	public int getNumberOfGames() {
		return numberOfGames;
	}

	public int getPlayerOneNumberOfWin() {
		return playerOneNumberOfWin;
	}

	public int getPlayerTwoNumberOfWin() {
		return playerTwoNumberOfWin;
	}

	public int getNumberOfTie() {
		return numberOfTie;
	}
	
}
