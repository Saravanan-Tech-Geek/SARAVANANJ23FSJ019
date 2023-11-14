package stream_demo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class StreamDemo1 {
	
	// The map operation is one of the intermediate operations 
	//that you can perform on a stream. It is used to transform the elements 
	//of a stream from one form to another by applying a given function to each element. 
	//The map operation produces a new stream where each element of the original stream 
	//is replaced with the result of applying the function to that element.

   //The map operation takes a Function as an argument, 
	//which specifies how each element should be transformed. 
	//This function is typically expressed as a lambda expression or a method reference. 
	
	public static void main(String[] args) {
		// Creating a Stream - there are several ways to create a stream
		//1. From collections
		List<Integer> numbers = Arrays.asList(1,2,3,4,5);
		//Stream<Integer> stream = numbers.stream();
		int sum = numbers.stream()
								.filter(n-> n%2 == 0) //filter even number
								.mapToInt(Integer::intValue) //Map to primitive int
								.sum(); //calculate the sum
		
		System.out.println("sum of even number: " +  sum);
		
		//2. From an array
		int[] intArray = {1,2,3,4,5,6};
		IntStream intStream = Arrays.stream(intArray);
		
		//3. From range of values
		IntStream range = IntStream.range(1, 7);
		range.forEach(System.out::print);
	}

}
