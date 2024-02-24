package basics;

public class ClassDemo5 {
	public static void main(String[] args) {
		MyParent obj=new MyChild();
		
		MyParent.statMet();
		MyChild.statMet();
		
		MyParent childobj=new MyChild();
		childobj.statMet();
	}
}
class MyParent{
	public MyParent(int i,int j) {
		System.out.println("myparent cons called...");
	}
	public static void statMet() {
		System.out.println("stat met of parent....");
	}
}
class MyChild extends MyParent{
	public MyChild() {
		super(10,20);
		System.out.println("mychild cons called...");
		
	}
	public static void statMet() {
		System.out.println("stat met of child....");
	}
}










