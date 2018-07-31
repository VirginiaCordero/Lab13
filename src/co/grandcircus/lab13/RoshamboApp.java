package co.grandcircus.lab13;

import java.util.Scanner;

public class RoshamboApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		RandomPlayer randomPlayer = new RandomPlayer("ann");
		RockPlayer computerPlayer = new RockPlayer("bob");

		boolean shouldContinue = true;
		
		while (shouldContinue  == true) {	
			System.out.println("Welcome to Rock Paper Scissors");
			System.out.println("Enter your name:");
			String userName = scanner.nextLine();
			HumanPlayer humanPlayer = new HumanPlayer(userName, scanner);
			Roshambo userHand, opponantHand;
			userHand = humanPlayer.generateRoshambo();
			String oppoChoice = Validator.getStringMatchingRegex(scanner, "Would you like to play against ann or bob?",
					"ann|bob");
			if (oppoChoice.equals("ann")) {
				opponantHand = randomPlayer.generateRoshambo();
			} else {
				//if (oppoChoice.equals("bob")) {
				opponantHand = computerPlayer.generateRoshambo();
			}
			if (userHand.equals(opponantHand)) {
				System.out.println("This is a draw");
			} else if (userHand.equals(Roshambo.ROCK) && opponantHand.equals(Roshambo.PAPER)) {
				System.out.println(oppoChoice + " wins.");
			} else if (userHand.equals(Roshambo.PAPER) && opponantHand.equals(Roshambo.ROCK)) {
				System.out.println(userName + " wins.");
			} else if (userHand.equals(Roshambo.SCISSORS) && opponantHand.equals(Roshambo.PAPER)) {
				System.out.println(userName + " wins.");
			} else if (userHand.equals(Roshambo.ROCK) && opponantHand.equals(Roshambo.SCISSORS)) {
				System.out.println(userName + " wins.");
			} else if (userHand.equals(Roshambo.PAPER) && opponantHand.equals(Roshambo.SCISSORS)) {
				System.out.println(oppoChoice + " wins");
			} else if (userHand.equals(Roshambo.SCISSORS) && opponantHand.equals(Roshambo.ROCK))
				System.out.println(oppoChoice + " wins.");
			System.out.println(oppoChoice + " chose : " + opponantHand);
			System.out.println("you chose : " + userHand);
		
			System.out.println("Do you want to play again? (y/n)");
			String userAnswer = scanner.nextLine();
			if (userAnswer.equals("n")) {
				System.out.println("Thanks for playing, come back soon!");
				shouldContinue = false;
			}	
		}
		scanner.close();
	}
}
