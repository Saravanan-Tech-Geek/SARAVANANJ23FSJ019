package Introduction;

import java.util.Scanner;

class CheckPrime {
	public static void main(String args[]) {
		int temp;
		boolean isPrime = true;
		System.out.print("Enter number to check prime or not...:");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.close();
		for (int i = 2; i <= num / 2; i++) {
			temp = num % i;
			if (temp == 0) {
				isPrime = false;
				break;
			}
		}
		//If isPrime is true then
		if(isPrime)
			System.out.println(num + " is a prime number");
		else
			System.out.println(num + " is not a prime number");

	}
}