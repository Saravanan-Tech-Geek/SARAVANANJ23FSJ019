package Tryouts;

import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number or word to check palindrome..:");
		String word = sc.nextLine();
		String reverseWord = "";
		int length = word.length();
		for (int i = length - 1; i >= 0; i--) {
			reverseWord = reverseWord + word.charAt(i);
		}
		sc.close();
		if (reverseWord.toLowerCase().equals(word.toLowerCase())) {
			System.out.println(word + " is a palindrome");
		} else {
			System.out.println(word + " is not a palindrome");
		}
	}

}
