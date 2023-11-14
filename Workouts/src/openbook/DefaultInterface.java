package openbook;

public class DefaultInterface {
	public static void main(String[] args) {
		SampleDriver obj = new SampleDriver();
		obj.met();
	}
}
/*
 * Since Both interface Head & Tail contains Default methods of Same name and Signature
 * Child class implementing both interface may face ambiguity
 * In that case, it can be avoided by two ways
 * 1. Create your own implementation for that method
 * 2. Call with the (Interface.super.methodname) e.g. Head.super.met();
 */
interface Head{
	default void met() {
		System.out.println("Head met method");
	}
}
interface Tail{
	default void met() {
		System.out.println("Tail met method");
	}
}

class SampleDriver implements Head,Tail{
	
	public void met() {
		System.out.println("SampleDriver method implementation");
		Head.super.met();
		Tail.super.met();
	}
}
