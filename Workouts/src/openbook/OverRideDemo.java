package openbook;

public class OverRideDemo {
	public static void main(String[] args) {
		MySuper2 obj = new MySub();
		System.out.println(obj.i);
		obj.met();
	}
}

/**
 * Overriding rules. 1. The visibility cannot be reduced but can be
 * increased(public,protected,nomodifier,private)
 *  2. The signature cannot be
 * changed.
 *  3. The method name cannot be changed. 4. The parameters cannot be
 * changed. 5. You cannot throw exceptions which are not thrown by the parent
 * class
 * 
 * @author Hp
 *
 */
class MySuper1 {
	int i = 100;// there is no overriding for variables

	protected void met() {
		System.out.println("mysuper1 met called...");
	}
}

class MySuper2 extends MySuper1 {
	int i = 200;

	public void met() {
		System.out.println("mysuper2 met called....");
	}
}

class MySub extends MySuper2 {
	int i = 300;

	public void met() {
		System.out.println("mysub met called.....");
	}
}