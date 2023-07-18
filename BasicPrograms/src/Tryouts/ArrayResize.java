package Tryouts;

import java.util.Arrays;

public class ArrayResize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,2,3,4,5};
		
		int[] newarray = new int[3];
		
		System.arraycopy(array, 0, newarray, 0, 3);
		
		array = null;
		
		System.out.println("resized array..:"+ Arrays.toString(newarray));
		
		
		int[] sampleArray = {2,4,6,8,10};
		int resize = 8;
		int[] obtainedArray = Arrays.copyOf(sampleArray, resize);
	
		System.out.println("resized array..:"+ Arrays.toString(obtainedArray));
		
	
	}

}
