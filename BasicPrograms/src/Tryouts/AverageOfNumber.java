package Tryouts;

import java.util.Scanner;

public class AverageOfNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 0;
		System.out.print("Enter how many numbers you wish to calculate average...:");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		System.out.println("Enter numbers to store...:");
		for(int i=0; i < n ; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		for(int j : arr) {
			sum += j;
		}
		System.out.println("average of entered numbers..: "+ (sum/n));
		
	}

}
