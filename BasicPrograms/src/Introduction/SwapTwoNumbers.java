package Introduction;

public class SwapTwoNumbers {
	public static void main(String[] args) {
		//swapping without third variable
		int x = 20;
		int y = 10;
		System.out.println("--Before swap--");
		System.out.println("x value = " + x);
		System.out.println("y value = " + y);
		x = x + y;
		y = x - y;
		x = x - y;
		System.out.println("--After swap--");
		System.out.println("x value = " + x);
		System.out.println("y value = " + y);
		
		float first = 2.50f, second = 4.50f;
		System.out.println("--Before swap--");
		System.out.println("First number = " + first);
		System.out.println("Second number = " + second);
		// Value of first is assigned to temporary
		float temporary = first;
		// Value of second is assigned to first
		first = second;
		// Value of temporary (which contains the initial value of first) is assigned to second
		second = temporary;
		System.out.println("--After swap--");
		System.out.println("First number = " + first);
		System.out.println("Second number = " + second);
	}
}