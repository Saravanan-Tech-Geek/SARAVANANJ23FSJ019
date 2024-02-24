package basics;

//OVERRIDING
public class ClassDemo4 {
	public static void main(String[] args) {
		Parent p=new Parent();
		p.met();
		System.out.println(p.x);//this will print 100 because it is reading direct parent object
		
		Child c=new Child();
		c.met();
		System.out.println(c.x);//this will print 999 because it is reading direct child object
		
		Parent cp=new Child();
		cp.met();
		System.out.println(cp.x);//this will print 100 because there is no concept of overriding in var
	}
}
class Parent{
	//final and super
	
	int x=100;
	//final - if you declare the method as final then the method cannot be overriden
	//final - if you declare a variable with final then the value cannot be changed
	//final - if you declare a class as final then the class cannot be inherited
	protected void met() {//throws Exception{
		System.out.println("parent met called...");
	}
}
class Child extends Parent{
	//int x=999;
	/*
	 * Rules pertaining to method overriding
	 * 1. the name and signature should be same.
	 * 2. the return type should be same.
	 * 3. you cannot reduce the visibility but you can increase the visibility
	 * 4. You cannot throw an exception which is not thrown in the super class method
	 * 5. Properties cannot be overriden in java
	 */
	//overriding
	public void met() {//throws Exception {//return type of the overriden method cannot be changed
		System.out.println("child met called...."+super.x);	
	}
}







