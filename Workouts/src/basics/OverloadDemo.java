package basics;

public class OverloadDemo {
	public static void main(String[] args) {
		Greeting obj = new Greeting();
		obj.welcome(1);
		obj.welcome("sam");
		obj.welcome(2);
		Greeting.welcome(12.4);
	}
}

class Greeting {
	void welcome(int i) {
		System.out.println("welcome");
	}
	void welcome(String s) {
		System.out.println("Sara");
	}
	static void welcome(double d) {
		System.out.println("double");
	}
}