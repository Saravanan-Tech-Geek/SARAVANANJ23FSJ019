package Introduction;

import java.util.Scanner;

public class PrintANumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Enter a number...:");
		try (Scanner sc = new Scanner(System.in)) {
			int retrievedValue = sc.nextInt();
			System.out.println("Value entered by user.....:" + retrievedValue);
		}
	}

}
