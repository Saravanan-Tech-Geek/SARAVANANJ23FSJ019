package com.assignment;

import java.util.Scanner;

interface HCF {
	public int findGCD(int n1, int n2);
}

class B implements HCF {
	public int findGCD(int n1, int n2) {
		while (n1 != 0 && n2 != 0) {
			if (n1 > n2) {
				n1 = n1 % n2;
			} else {
				n2 = n2 % n1;
			}
		}
		if (n1 != 0) {
			return n1;
		} else {
			return n2;
		}
	}
}

public class GCD {
	public static void main(String[] args) {
		B a = new B(); // Create an object of class B
		// Read two numbers from the keyboard
		Scanner sc = new Scanner(System.in);
		int p1 = sc.nextInt();
		int p2 = sc.nextInt();
		System.out.print(a.findGCD(p1, p2));
		sc.close();
	}
}