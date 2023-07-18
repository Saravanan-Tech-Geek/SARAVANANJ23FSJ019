package Tryouts;

public class ArrayReverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { -3, -6, 0, 7, 3, 5 };

		System.out.println("Original Array..: ");
		printArray(array);
		System.out.println("\nArray Reversed: ");
		reverse(array);
	}

	private static void reverse(int[] array) {
		int temp = 0;
		int i = 0, j = array.length - 1;
		while (i < j) {
			temp = array[i];
			array[i] = array[j];
			array[j] = temp;
			i++;
			j--;
		}
		printArray(array);
	}

	private static void printArray(int[] array) {
		for (int element : array) {
			System.out.print(element + " ");
		}

	}

}
