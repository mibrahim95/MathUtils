package main;

import java.util.Scanner;

public class main {
	

	public static void main(String[] args) {
		 CommandHandler commHandler = new CommandHandler();
		  Scanner myScanner = new Scanner(System.in);  // Create a Scanner object
		    System.out.println("Please enter a list of numbers seperated by comma (,)");

		    String myNumbers = myScanner.nextLine();  // Read user input
		    commHandler.processCommand(myNumbers);
	}

}
