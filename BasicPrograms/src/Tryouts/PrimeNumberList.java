package Tryouts;

import java.util.Scanner;

public class PrimeNumberList {
	static int number;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number to generate prime number list until given number:");
		number = sc.nextInt();
		for (int i = 0; i <= number; i++) {
			if (isPrime(i)) {
				System.out.print(i + " ");
			}
		}
		sc.close();
	}

	private static boolean isPrime(int n) {
		if (n == 0 || n == 1) {
			return false;
		}
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;

	}

}
