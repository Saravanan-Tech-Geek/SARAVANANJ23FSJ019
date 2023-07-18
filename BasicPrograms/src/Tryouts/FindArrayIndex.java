package Tryouts;

import java.util.Arrays;

public class FindArrayIndex {

	public static void main(String[] args) {
		int[] array = { 1, 2, 34, 5, 6, 7, 8 };
		System.out.println("Index position of 34 is: " + findIndex(array, 34));

		int[] newArray = { 1, 2, 3, 4, 5, 6 };
		int result = methodBineary(newArray, 6);
		System.out.println("Index position of 6 using binear search is: " + result);

	}

	private static int methodBineary(int[] array, int temp) {
		int index = Arrays.binarySearch(array, temp);
		return index < 0 ? -1 : index;
	}

	private static int findIndex(int[] arr, int temp) {

		if (arr == null) {
			return -1;
		}
		int length = arr.length;
		int i = 0;
		while (i < length) {
			if (arr[i] == temp) {
				return i;
			} else {
				i += 1;
			}
		}

		return -1;
	}

}
