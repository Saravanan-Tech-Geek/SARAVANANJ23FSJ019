package Introduction;

import java.util.Scanner;

public class AreaOfCircle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter a side value to find area of sqaure...:");
		try (Scanner sc = new Scanner(System.in)) {
			int radius = sc.nextInt();
			AreaOfCircle obj = new AreaOfCircle();
			double circleArea = obj.findAreaOfCircle(radius);
			System.out.println("Area of circle for given radius is..:" + circleArea);
			double circleCircumference = obj.findAreaOfCirumference(radius);
			System.out.println("Area of circle for given radius is..:" + circleCircumference);
		}
	}

	double findAreaOfCircle(int radius) {
		return Math.PI * radius * radius;
	}

	double findAreaOfCirumference(int radius) {
		return 2 * Math.PI * radius;
	}

}
