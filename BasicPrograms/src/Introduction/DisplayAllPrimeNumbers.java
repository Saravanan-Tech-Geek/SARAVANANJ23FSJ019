package Introduction;

import java.util.Scanner;

public class DisplayAllPrimeNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter number to get prime number until the given number...:");
		try (Scanner sc = new Scanner(System.in)) {
			int number = sc.nextInt();
			for (int i = 1; i < number; i++) {
				if (isPrime(i)) {
					System.out.print(i + " ");
				}
			}
		}

	}

	private static boolean isPrime(int n) {
		if (n == 1 || n == 0) {
			return false;
		}
		for (int i = 2; i <= n / 2; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

}
