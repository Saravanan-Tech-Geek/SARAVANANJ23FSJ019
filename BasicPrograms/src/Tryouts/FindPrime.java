package Tryouts;

import java.util.Scanner;

public class FindPrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Enter number to check prime or not...:");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.close();
		boolean output = isPrime(num);
		if (output == true) {
			System.out.println("Entered number " + num + " is a prime number");
		} else {
			System.out.println("Entered number " + num + " is a not prime number");
		}

	}

	public static boolean isPrime(int num) {
		if (num == 0 || num == 1)
			return false;
		for (int i = 2; i <= num / 2; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

}
