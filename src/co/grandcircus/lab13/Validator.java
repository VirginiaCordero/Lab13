package co.grandcircus.lab13;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Validator {
	
	/**
	 * Get any valid integer.
	 */
	public static int getInt(Scanner scanner, String prompt) {
		// This approach uses exception handling.
		System.out.print(prompt);
		try {
			int num = scanner.nextInt();
			scanner.nextLine();
			return num;
		} catch (InputMismatchException e) {
			System.out.println("Enter a whole number, using digits.");
			scanner.nextLine();
			return getInt(scanner, prompt);
		}
	}

	/**
	 * Get any valid double.
	 */
	public static double getDouble(Scanner scanner, String prompt) {
		// This approach use "hasNext" look ahead.
		boolean isValid = false;
		do {
			System.out.print(prompt);
			isValid = scanner.hasNextDouble();
			if (!isValid) {
				scanner.nextLine();
				System.out.println("Enter a number, in digits.");
			}
		} while (!isValid);
		
		double number = scanner.nextDouble();
		scanner.nextLine();
		return number;
	}
	
	/**
	 * Get any string.
	 */
	public static String getString(Scanner scanner, String prompt) {
		// This approach uses exception handling.
		System.out.print(prompt);
		String choice = scanner.nextLine();
		return choice;
	}
	
	/**
	 * Get any valid integer between min and max.
	 */
	public static int getInt(Scanner scanner, String prompt, int min, int max) {
		boolean isValid = false;
		int number;
		do {
			number = getInt(scanner, prompt);
			
			if (number < min) {
				isValid = false;
				System.out.println("The number must be at least " + min);
			} else if (number > max) {
				isValid = false;
				System.out.println("The number must not be larger than " + max);
			} else {
				isValid = true;
			}
			
		} while (!isValid);
		return number;
	}
	
	/**
	 * Get any valid double between min and max.
	 */
	public static double getDouble(Scanner scanner, String prompt, double min, double max) {
		boolean isValid = false;
		double number;
		do {
			number = getDouble(scanner, prompt);
			
			if (number < min) {
				isValid = false;
				System.out.println("The number must be at least " + min);
			} else if (number > max) {
				isValid = false;
				System.out.println("The number must not be larger than " + max);
			} else {
				isValid = true;
			}
			
		} while (!isValid);
		return number;
	}
	
	/**
	 * Get a string of input from the user that must match the given regex.
	 */
	public static String getStringMatchingRegex(Scanner scanner, String prompt, String regex) {
		boolean isValid = false;
		String input;
		do {
			input = getString(scanner, prompt);
			
			if (input.matches(regex)) {
				isValid = true;
			} else {
				System.out.println("Input must match the appropriate format.");
				isValid = false;
			}
			
		} while (!isValid);
		return input;
	}

	/**
	 * Get a date from user input in the format mm/dd/yyyy
	 */
	public static Date getDate(Scanner scanner, String prompt) {
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		format.setLenient(false); // <-- date format must match
		boolean isValid = false;
		Date date = null;
		String input;
		do {
			// Step 1: get the raw string
			input = getString(scanner, prompt);
			// Step 2: convert it to a date
			try {
				// format.parse throws a ParseException, which is a checked exception and MUST be caught.
				date = format.parse(input);
				// If exception doesn't occur, it's valid.
				isValid = true;
			} catch (ParseException ex) {
				// If exception occurs, it's invalid.
				isValid = false;
				System.out.println("Enter a valid date in format mm/dd/yyyy.");
			}
			
		} while (!isValid);
		return date;
	}

}
