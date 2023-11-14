package openbook;

/*
 * In Java, when you create an object of a child class that extends a parent class, 
 * the following order of execution occurs:
 * First, the static block of the parent class is executed (if there is one).
 * Next, the static block of the child class is executed (if there is one).
 * Then, the instance block of the parent class is executed (if there is one).
 * After that, the constructor of the parent class is executed.
 * Finally, the instance block and constructor of the child class are executed.
 */

class Parent {
	// Static block of the parent class
	static {
		System.out.println("Static block in Parent");
	}

	// Instance block of the parent class
	{
		System.out.println("Instance block in Parent");
	}

	// Constructor of the parent class
	public Parent() {
		System.out.println("Constructor in Parent");
	}
}

class Child extends Parent {
	// Static block of the child class
	static {
		System.out.println("Static block in Child");
	}

	// Instance block of the child class
	{
		System.out.println("Instance block in Child");
	}

	// Constructor of the child class
	public Child() {
		System.out.println("Constructor in Child");
	}
}

public class StaticBlockExplanation { //Driver Class
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Child child = new Child();

	}
}
