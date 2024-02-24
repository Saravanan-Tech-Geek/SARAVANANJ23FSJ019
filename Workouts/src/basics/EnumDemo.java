package basics;

public class EnumDemo {
	public static void main(String[] args) {
		met(MyCons.pi);
		met2(MyEnum.java);
		MyEnum m[]=MyEnum.values();
		for(MyEnum mm:m) {
			System.out.println(mm+":"+mm.getPrice());
		}
	}
	public static void met(float f) {
		System.out.println(f);
	}
	public static void met2(MyEnum me) {
		System.out.println(me+":"+me.met()+":"+me.getPrice());
	}
}
enum MyEnum{
	java(2000),uiux(1000),python(500),c(500);
	int price;
	MyEnum(int price) {
		this.price=price;
	}
	int met() {
		return 100;
	}
	int getPrice() {
		return this.price;
	}
}
interface MyCons{
	final static float pi=3.14f;
}