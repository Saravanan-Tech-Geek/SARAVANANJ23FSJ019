package com.assignment;

public class ArrayClass {
	public static void main(String[] args) {
		//int a = 20; // a is a type of integer
		
		//int[] ranjith = new int[5]; // array size
		int[] ranjith;
		
		ranjith = new int[5];
		// Ranjith - array name - variable
		// ranjith is a type of integer array -- int[] leftside
		// new int[5] - five values adopt
		
		ranjith[0] = 3;
		ranjith[1] = 6;
		ranjith[2] = 9;
		ranjith[3] = 12;
		ranjith[4] = 15;
		
		for(int elementValue:ranjith) {
			System.out.print(elementValue+ " ");
		}
	}
}
