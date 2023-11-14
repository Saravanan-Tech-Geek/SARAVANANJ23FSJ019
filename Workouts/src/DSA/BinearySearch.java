package DSA;

public class BinearySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] sampleArray = {3,5,7,45,12,33,56,87,10};
		int key = 12;
		
		int result = binearsearch(sampleArray,key);
		
		System.out.println(result);
		
	}

	private static int binearsearch(int[] arr, int key) {
		int low = 0 ;
		int mid = 0;
		int high = arr.length - 1;
		
		while(low <= high) {
			mid = (low + high) / 2 ;
			if(key == arr[mid]) {
				return mid;
			}else if(key < arr[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

}
