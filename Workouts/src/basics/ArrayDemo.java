package basics;

public class ArrayDemo {
	public static void main(String[] args) {
		//single dimensional array
		int[]arr= {10,20,30,40};//arrays are homogenous
		
		Object[] obj= {"aa",new Integer(10),123,new T()};//arrays can also be heterogenous - if it is object array
		
		//single dimensional array is always 1 row multiple columns
		
		//array processing
		System.out.println(arr.length);//length property
		//array is always read through index and index starts with zero
		
		System.out.println(arr[0]);//first column value
		
		arr[0]=999;
		
		System.out.println(arr[0]);//first column value
		
		//Arrays are by default pass by reference.
		
		met(arr[0]);
		System.out.println(arr[0]);
		
		//passing array
		//int temp[]=arr;
		int temparray[]=new int[5];
		System.arraycopy(arr, 0, temparray, 0, arr.length);
		met(arr);
		System.out.println(arr[0]);//this will print 2000 because the array object is referred
		System.out.println(temparray[0]);
		
	}
	//pass by value...
	public static void met(int a) {//this method is accepting a variable of type in
		a=1000;
	}
	//pass by reference
	public static void met(int a[]) {//this method accepts an array object of type int
		a[0]=2000;
	}
}
class T{
	
}