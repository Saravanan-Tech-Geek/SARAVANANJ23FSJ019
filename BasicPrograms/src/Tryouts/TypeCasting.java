package Tryouts;

public class TypeCasting {

	public static void main(String[] args) {
		short a = 12;
		byte b = (byte)a;
		System.out.println("Explicit byte conversion...:" + b);
		
		byte c = 127;
		short d = c;
		System.out.println("auto casting...:" + d);
		
		short e = (short) (a + d);
		
		int f = a + d;
		
		System.out.println(e);
		System.out.println(f);
		
		int g = e;
		
		long l = g;
		System.out.println(l);
		
		int s = 234;
		int t = 345;
		
		float m = s + t ;
		System.out.println(m);
		
		float q = 123.00f;
		float u = 654.12f;
		double k = q + u;
		System.out.println(k);
		
		char z = (char) s;
		System.out.println(z);
		
		int y = z;
		System.out.println(y);
	}

}
