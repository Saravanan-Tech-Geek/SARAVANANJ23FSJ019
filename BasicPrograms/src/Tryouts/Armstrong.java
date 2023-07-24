package Tryouts;

import java.util.Scanner;

public class Armstrong {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter a number..: ");
		int OriginalNumber = sc.nextInt();
		if (isArmstrong(OriginalNumber)) {
			System.out.println("Entered number " + OriginalNumber + " is a Armstrong Number");
		} else {
			System.out.println("Entered number " + OriginalNumber + " is not a Armstrong Number");
		}
		sc.close();
	}

	private static boolean isArmstrong(int OriginalNumber) {
		if (OriginalNumber == 0) {
			return false;
		}
		int temp = OriginalNumber;
		int result = 0;
		while (temp != 0) {
			int reminder = temp % 10;
			result += Math.pow(reminder, 3);
			temp /= 10;
		}
		if (result == OriginalNumber) {
			return true;
		}
		return false;
	}

}
