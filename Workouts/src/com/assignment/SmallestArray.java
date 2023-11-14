package com.assignment;

import java.util.Arrays;

public class SmallestArray {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		int smallest = Integer.MAX_VALUE;
		int[] A = { 2, 6, 5, 7, 11 };
		int[] B = { 2, 4, 6, 8, 10 };

		Arrays.sort(B);

		for (int num : A) {
			if (!contains(B, num) && num < smallest) {
				smallest = num;
			}

		}

		System.out.println(smallest);

	}

	private static boolean contains(int[] B, int num) {
		for (int elem : B) {
			if (elem == num) {
				return true;
			}
		}
		return false;
	}

}
