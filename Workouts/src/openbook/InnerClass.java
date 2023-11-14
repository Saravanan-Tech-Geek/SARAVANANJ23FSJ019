package openbook;

public class InnerClass {
	public static void main(String[] args) {
		Outer obj = new Outer();
		obj.outerMethod();
		/*
		 * Rules 1. Outer class object cannot access inner class methods 2. But Inner
		 * classes can access outer class methods. 3. Outer class can create object of
		 * inner class
		 *
		 */
		// below code create objects of inner class

		@SuppressWarnings("unused")
		Outer.Inner inn1 = new Outer().new Inner();
		Outer.Inner inn2 = obj.new Inner();
		inn2.innerMethod();

		// below code create objects of static inner class

		Outer.StaticInner sinn = new Outer.StaticInner();
		sinn.staticInnerMethod();

	}
}

/*
 * Inner Class concept is used for better encapsulation.. Types of inner class
 * 1. Inner class non staic and Inner class static 2. Local Inner Class 3.
 * Anonymous Inner class
 */
class Outer {
	public void outerMethod() {
		// System.out.println(innerX);cannot access inner class variable or methods.

		// below code creates an object of inner class in outer class method
		Inner obj = new Inner();
		obj.innerMethod();
		System.out.println(obj.innerX);

		// below code creates an object of static inner class in outer class method
		Outer.StaticInner obj2 = new Outer.StaticInner();
		obj2.staticInnerMethod();
	}

	public static void staticOuterMethod() {
	}

	int x = 100;
	static int staticX = 100;

	class Inner {
		int innerX = 1000;

		public void innerMethod() {
			outerMethod();
			staticOuterMethod();
			System.out.println(x + ":" + staticX);
		}
	}
	

	static class StaticInner {
		public void staticInnerMethod() {
			// can only access static methods of outer class
			staticInnerMethod();
			System.out.println(staticX);// can only access static variables of outer class
		}
	}
}
