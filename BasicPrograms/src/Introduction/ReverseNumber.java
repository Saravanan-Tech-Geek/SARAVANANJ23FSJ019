package Introduction;

import java.util.Scanner;

public class ReverseNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter number to reverse..:");
		try (Scanner sc = new Scanner(System.in)) {
			int number = sc.nextInt();
			int temp = number;
			String sum = "";
			while (temp > 0) {
				int reminder = temp % 10;
				sum += reminder;
				temp = temp / 10;
			}
			System.out.println("reversed number is..:" + Integer.parseInt(sum));
		}
	}

}
