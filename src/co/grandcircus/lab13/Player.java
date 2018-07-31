package co.grandcircus.lab13;

public abstract class Player {
	private String name;
	// Constructor (no return type, 
	public Player(String name) {
		this.name = name;
	}
	// Getter
	public String getName() {
		return name;
	}
	// return one of ROCK, PAPER, SCISSORS
	abstract public Roshambo generateRoshambo();
	
	public String toString() {
		return "Player " + name;
	}
}
