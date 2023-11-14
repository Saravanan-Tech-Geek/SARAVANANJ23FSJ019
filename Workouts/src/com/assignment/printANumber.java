package com.assignment;

import java.util.Scanner;

public class printANumber {
	public static void main(int[] args) {
		Scanner reader=new Scanner(System.in);
		System.out.println("enter a number:");
		int number=reader.nextInt();
		System.out.println("you entered:"+number);
		reader.close();
	}

}
