package openbook;

public class InnerClassRef {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

/*
 * Inner class 
- Normal Inner class
- Static Inner class
 */

// Rule
/*
 * Outer class cannot access Inner class 
 * Inner class can access Outer class variables and methods
 */
class OutterDemo { // Appa property
	int x = 10;
	static int y = 20;

	public void outermet() {
		System.out.println("outer normal method");
	}

	public static void outerstaticmet() {
		System.out.println("outer static method");
	}
	
	class InnerDemo{ // Child na use pannikuran
		int innerValue = 999;
		
		public void innerMethod() {
			System.out.println(x);
			System.out.println(y);
			outermet();
			outerstaticmet();
		}
		
	}
	
	static class InnerStaticDemo{
		public void InnerStaticmethod() {
			// can only access static methods of outer class
			System.out.println(y);
			//System.out.println(x);
			outerstaticmet();
			//outermet();
		}
	}
}
