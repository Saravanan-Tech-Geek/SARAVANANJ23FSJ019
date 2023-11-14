package com.assignment;

public class StaticBlockEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Y.display();
	}

}
class Z{
	static {
		Y.display();
	}
}
class Y extends Z{
	static void display() {
		System.out.println("Java");
	}
}
