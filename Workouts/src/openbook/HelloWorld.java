package openbook;

import java.util.Scanner;

public class HelloWorld {

	public static void main(String[] params) {
		// TODO Auto-generated method stub
		System.out.println("Program starts...!");
		Scanner sc = new Scanner(System.in);
		System.out.println("enter number");
		int n = sc.nextInt();
		System.out.println("enter string");
		String s = sc.nextLine();
		System.out.println("entered int " + n);
		System.out.println("entered string" + s);
		sc.close();
	}

}