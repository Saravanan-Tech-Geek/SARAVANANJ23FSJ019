package com.assignment;

import java.util.Scanner;

public class Basic2 {
	public static void main(String[] args) {
		Scanner var=new Scanner(System.in);
		System.out.println("enetr value for i..:");
		int i=var.nextInt();
		System.out.println("enter value for j..:");
		int j=var.nextInt();
		int mul=i*j;
		System.out.println("the multiplication of i and j is..:"+mul);
		var.close();
	}

}
