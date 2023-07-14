package Introduction;

import java.util.Scanner;

public class AreaOfSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter a side value to find area of sqaure...:");
		try (Scanner sc = new Scanner(System.in)) {
			int side = sc.nextInt();
			AreaOfSquare obj = new AreaOfSquare();
			int result = obj.findAreaOfSqaure(side);
			System.out.println("Area of Sqaure for given side is..:" + result);
		}
	}

	int findAreaOfSqaure(int side) {
		return side * side;
	}

}
