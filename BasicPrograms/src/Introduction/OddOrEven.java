package Introduction;

import java.util.Scanner;

public class OddOrEven {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Enter a value to check odd or even..:");
			
			int valueToBeChecked = sc.nextInt();
			
			if(valueToBeChecked % 2 == 0) {
				System.out.println("entered value is even");
			} else {
				System.out.println("entered value is odd");
			}
		}
	}

}
