package string_revision;

public class EnumDemo {
	public static void main(String[] args) {
		System.out.println(MyConstants.pi);
		System.out.println(MyEnumConstants.apple.getPrice());
		test(MyEnumConstants.apple);
	}

	public static void test(MyEnumConstants en) {
		switch(en) {
		case apple:
			System.out.println("Its an apple....: "+en.getPrice());
			break;
		case grape:
			System.out.println("Its a grape..: "+en.getPrice());
			break;
		case orange:
			System.out.println("Its a orange..: "+en.getPrice());
			break;
		default:
			System.out.println("Nothing");
			break;
		}
	}

	interface MyConstants {
		public static float pi = 3.14f;
	}

    enum MyEnumConstants{
	apple(50),mango(30),grape(20),orange(80);
	int price;
	private MyEnumConstants(int price) {
		this.price = price;
	}
	public int getPrice() {
		return this.price;
	}
}

}