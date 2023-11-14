package openbook;

import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScannerDate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter a date (yyyy-MM-dd): ");
		String userInput = scanner.nextLine();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;

		try {
			date = dateFormat.parse(userInput);
		} catch (java.text.ParseException e) {
			System.out.println("Invalid date format. Please enter a date in the format yyyy-MM-dd.");
			// Handle the parsing error as needed
		}
		if (date != null) {
			System.out.println("You entered the date: " + dateFormat.format(date));
			// Do something with the parsed date
		} else {
			System.out.println("Unable to parse the date. Please try again.");
			// Handle the parsing error as needed
		}
		scanner.close();

	}

}
