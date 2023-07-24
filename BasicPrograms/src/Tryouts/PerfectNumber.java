package Tryouts;

import java.util.Scanner;

public class PerfectNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter a number..: ");
		int OriginalNumber = sc.nextInt();
		int result = isPerfect(OriginalNumber);
		if (result == OriginalNumber) {
			System.out.println("Entered number " + OriginalNumber + " is a Perfect Number");
		} else {
			System.out.println("Entered number " + OriginalNumber + " is not a Perfect Number");
		}
		sc.close();
	}

	private static int isPerfect(int originalNumber) {
		int sum = 0;
		int temp = originalNumber;
		for (int i = 1; i <= temp / 2; i++) {
			if (temp % i == 0) {
				sum = sum + i;
			}
		}
		return sum;
	}

}
