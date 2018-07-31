package co.grandcircus.lab13;

import java.util.Scanner;

public class HumanPlayer extends Player {
	
	private Scanner scanner = new Scanner(System.in);
	
	public HumanPlayer(String name, Scanner scanner) {
		super(name);
}
	@Override
	public Roshambo generateRoshambo() {
		String choice = Validator.getStringMatchingRegex(scanner, "Would you like to play rock, paper or scissors?", "rock|paper|scissors");
		//
		if (choice.equals("rock")) {
			return Roshambo.ROCK;
		} else if (choice.equals("paper")) {
			return Roshambo.PAPER;
		} else  {
			return Roshambo.SCISSORS;
		}
	}
}