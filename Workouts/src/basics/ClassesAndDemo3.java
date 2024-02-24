package basics;

public class ClassesAndDemo3 {
	public static void main(String[] args) {
		Fan fan=new Fan();
		fan.speed(10L);
		Dog tiger=new Dog();
		tiger.bite(new Stick());
		tiger.bite(new Stone());
		tiger.bite(new Gun());
	}
}
//Method OverLoading
//Dynamic Method Dispatch or Virtual Method Invocation
//polymorphism is - Data Changes - Behavior Changes
class Fan{
	public void speed(long l) {
		System.out.println("long method called....");
	}
	public void speed(int i) {
		System.out.println("int method called...");
	}
	public void speed(float f) {
		System.out.println("float method called...");
	}
	
}
//Why Polymorphism
class Dog{
	public void bite(Stone s) {
		System.out.println("dog is scared of stone...");
	}
	public void bite(Stick ss) {
		System.out.println("dog bites-stick.....");
	}
	public void bite(Gun gun) {
		System.out.println("never come back again.....");
	}
}
class Stone{}
class Stick{}
class Gun{}




