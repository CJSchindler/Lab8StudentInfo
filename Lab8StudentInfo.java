//Lauren Shindo

package StudentInfo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Lab8StudentInfo {

	/**
	 * Provides information about students in a class when user requests it.
	 */
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);

		// arrays containing names, hometowns, and pet peeves of students
		String [] names = {"Ally", "Ben", "Charlene", "Dave", "Ella", "Frank", "Genevieve", "Horace"};
		String [] hometowns = {"Albany", "Boston", "Chicago", "Denver", "Evanston", "Frankfurt", "Galveston", "Houston"};
		String [] petPeeves = {"hangnails", "Bad drivers", "flies at a picnic", "nails on a chalkboard", "squeaky styrofoam", "dry toast", "papercuts", "hair in the sink"};
		String goAgain = "";
		
		System.out.print("Welcome to our Java class. ");
		
			
			System.out.print("Which student would you like to learn more about? ");
			// call the method to get valid integer
			int userNumber = getInt(scnr, "(Enter a number 1-8):", 1, 8);
			
			
			System.out.println("\nStudent " + userNumber + " is " + names[userNumber-1] + ".");
			System.out.print("\nWhat would you like to know about " + names[userNumber-1] + "? ");
			
			
			boolean userInputIsClear; // keeps track of whether input is clear for the following if/else block
			String userContinue; //keeps track of whether the user wants to continue with the program
			
			// loop to allow user to run through program again
			do {
			// loop to validate user input "hometown" or "pet peeve"
			do {
				System.out.println("Please enter \"hometown\" or \"pet peeve.\"");
				String userChoice = scnr.nextLine();

				// if "hometown" then print student's hometown
				if (userChoice.toLowerCase().equals("hometown")) {
					System.out.println("\n" + names[userNumber-1] + "'s " + userChoice + " is " + hometowns[userNumber-1] + ".");
					userInputIsClear = true;
				}
				// if "pet peeve" then print student's pet peeve
				else if (userChoice.toLowerCase().equals("pet peeve")) {
					System.out.println("\n" + names[userNumber-1] + "'s " + userChoice + " is " + petPeeves[userNumber-1] + ".");
					userInputIsClear = true;
				}
				// if input does not match either choice, then tell user, set "InputIsClear" to false so loop will start over
				else {
					System.out.print("Sorry, I didn't understand that. ");
					userInputIsClear = false;
				}
			
			} while (!userInputIsClear); //loop will repeat as long as user input is not clear
			
			// ask user if s/he wants to know more and get user response (which is called "goAgain")
			System.out.println("\nWould you like to know more about " + names[userNumber-1] + "? (y/n)");
			goAgain = scnr.nextLine();
		
		} while (goAgain.toLowerCase().startsWith("y")); // loop will repeat as long as "goAgain" starts with 'y'
		
		System.out.println("\nThanks, goodbye!");
			
		scnr.close();
	}
	
	/**
	 * Method to get valid integer input and catch exceptions
	 */
	public static int getInt(Scanner scnr, String prompt) {
		System.out.print(prompt);
		try {
			int num = scnr.nextInt();
			scnr.nextLine();
			return num;
		} catch (ArrayIndexOutOfBoundsException | IllegalArgumentException | InputMismatchException ex) {
			System.out.print("Enter a whole number 1-8.");
			scnr.nextLine();
			return getInt(scnr, prompt);
		}
	}
	
	
	/**
	 * Method to get valid integer between a min and max int value
	 */
	public static int getInt(Scanner scnr, String prompt, int min, int max) {
		boolean isValid = false;
		int number;
		do {
			number = getInt(scnr, prompt);
			
			if (number < min) {
				isValid = false;
				System.out.println("The number must be at least " + min);
			} else if (number > max) {
				isValid = false;
				System.out.println("The number must less than or equal to " + max);
			} else {
				isValid = true;
			}
			
		} while (!isValid);
		return number;
	}
	
	
	/**
	 * Method to get a string.
	 */
	public static String getString(Scanner scnr, String prompt) {
		// This approach uses exception handling.
		System.out.print(prompt);
		return scnr.nextLine();
	}
	


}
