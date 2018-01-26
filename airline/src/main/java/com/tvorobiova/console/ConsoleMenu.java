package com.tvorobiova.console;

import com.tvorobiova.airline.Airline;

public class ConsoleMenu {

	public static void main(String[] args) {
		int keyValue;
		AirlineLoader loader = AirlineLoader.getInstance();
		Airline airline = loader.loadDefaultAirline();
		while (true) {
			System.out.println("==================================");
			System.out.println("|              MENU              |");
			System.out.println("==================================");
			System.out.println("| Options:                       |");
			System.out.println("| 1. Print all aircraft          |");
			System.out.println("| 2. Print total capacity        |");
			System.out.println("| 3. Print carrying capacity     |");
			System.out.println("| 4. Find aircraft by fuel range |");
			System.out.println("| 5. Print current capacity      |");
			System.out.println("| 6. Exit                        |");
			System.out.println("==================================");
			keyValue = KeyIn.inInt(" Select option: ");

			switch (keyValue) {
			case 1:
				airline.printAllAircrafts();
				break;
			case 2:
				System.out.println("Total capacity: " + airline.calculateTotalCapacity());
				break;
			case 3:
				System.out.println("Carrying capacity: " + airline.calculateCarryingCapacity());
				break;
			case 4:
				int rangeStart = KeyIn.inInt("Enter range start: ");
				int rangeEnd = KeyIn.inInt("Please enter range end: ");
				if (rangeEnd < rangeStart) {
					System.out.println("Start of range should be less then end");
				} else {
					airline.find(rangeStart, rangeEnd);
				}
				break;
			case 5:
				System.out.println("Current capacity: " + airline.calculateCurrentCapacity());
				break;
			case 6:
				System.out.println("Thanks for using our application. Good luck!");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid selection");
				break; // This break is not really necessary
			}
		}
	}
}

// **********************************************************
// **********************************************************
// Program: Keyin
// Reference: Session 20
// Topics:
// 1. Using the read() method of the ImputStream class
// in the java.io package
// 2. Developing a class for performing basic console
// input of character and numeric types
// **********************************************************
// **********************************************************

class KeyIn {

	// *******************************
	// support methods
	// *******************************
	// Method to display the user's prompt string
	public static void printPrompt(String prompt) {
		System.out.print(prompt + " ");
		System.out.flush();
	}

	// Method to make sure no data is available in the
	// input stream
	public static void inputFlush() {
		int dummy;
		int bAvail;

		try {
			while ((System.in.available()) != 0)
				dummy = System.in.read();
		} catch (java.io.IOException e) {
			System.out.println("Input error");
		}
	}

	// ********************************
	// data input methods for
	// string, int, char, and double
	// ********************************
	public static String inString(String prompt) {
		inputFlush();
		printPrompt(prompt);
		return inString();
	}

	public static String inString() {
		int aChar;
		String s = "";
		boolean finished = false;

		while (!finished) {
			try {
				aChar = System.in.read();
				if (aChar < 0 || (char) aChar == '\n')
					finished = true;
				else if ((char) aChar != '\r')
					s = s + (char) aChar; // Enter into string
			}

			catch (java.io.IOException e) {
				System.out.println("Input error");
				finished = true;
			}
		}
		return s;
	}

	public static int inInt(String prompt) {
		while (true) {
			inputFlush();
			printPrompt(prompt);
			try {
				return Integer.valueOf(inString().trim()).intValue();
			}

			catch (NumberFormatException e) {
				System.out.println("Invalid input. Not an integer");
			}
		}
	}

	public static char inChar(String prompt) {
		int aChar = 0;

		inputFlush();
		printPrompt(prompt);

		try {
			aChar = System.in.read();
		}

		catch (java.io.IOException e) {
			System.out.println("Input error");
		}
		inputFlush();
		return (char) aChar;
	}

	public static double inDouble(String prompt) {
		while (true) {
			inputFlush();
			printPrompt(prompt);
			try {
				return Double.valueOf(inString().trim()).doubleValue();
			}

			catch (NumberFormatException e) {
				System.out.println("Invalid input. Not a floating point number");
			}
		}
	}
}