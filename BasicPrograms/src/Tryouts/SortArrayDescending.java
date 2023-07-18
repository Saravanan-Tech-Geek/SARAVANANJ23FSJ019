package Tryouts;

public class SortArrayDescending {

	static int arrayLength;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { -3, -6, 0, 7, 3, 5 };

		arrayLength = array.length;
		System.out.println("Original Array..: ");
		printArray(array);
		System.out.println("\nSorted Descending Array..: ");
		sortDescArray(array);
	}

	private static void sortDescArray(int[] array) {
		int temp = 0;
		for (int i = 0; i < arrayLength; i++) {
			for(int j = i+1; j < arrayLength;j++) {
				if(array[i] < array[j]) {
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		printArray(array);
	}

	private static void printArray(int[] array) {
		for (int element : array) {
			System.out.print(element + " ");
		}

	}

}
