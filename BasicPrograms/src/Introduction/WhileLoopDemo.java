package Introduction;

import java.util.Scanner;

public class WhileLoopDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 0;
		int number;
		
	 System.out.println("enter number less than 10..:" );
	 try (Scanner sc = new Scanner(System.in)) {
		number = sc.nextInt();
	}
	 while( number <= 10) {
		 sum = sum + number;
		 number++;
	 }
	 System.out.format("sum of numbers from while loop is: %d",sum);
	}

}
