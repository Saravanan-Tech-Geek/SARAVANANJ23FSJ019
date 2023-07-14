package Introduction;

import java.util.Scanner;

public class MultiplyTwoNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter a first number...:");
			int retrievedValueOne = sc.nextInt();
			System.out.println("Enter a second number...:");
			int retrievedValueTwo = sc.nextInt();
			int multiply = retrievedValueOne * retrievedValueTwo;
			System.out.println("After Multiplication.....:" + multiply);
		}
	}

}
