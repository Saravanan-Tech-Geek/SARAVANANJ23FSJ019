package basics;

// we can also do this way to assign value to static
//public class ClassDemo6 {
//	static int x=10;
//	public ClassDemo6(int x) {
//		this.x=x;
//	}
//		// TODO Auto-generated constructor stub
//	
//	public static void main(String[] args) {
//		//this is a key word - refers to current object
//		//this keyword you cannot use in static methods - because static is loaded by jvm
//		//and you cannot refer JVM in java
//		//this.x=10;
//		ClassDemo6 o=new ClassDemo6(90);
//		o.met();
//	}
//	void met() {
//		//this.x=20;
//		met(this);
//	}
//	
//	void met(ClassDemo6 obj) {
//		System.out.println(obj.x);
//	}
//}

// right way of doing this
public class ClassDemo6 {
	static int x=10;
	public ClassDemo6(int x) {
		ClassDemo6.x=x;
	}
		// TODO Auto-generated constructor stub
	
	public static void main(String[] args) {
		//this is a key word - refers to current object
		//this keyword you cannot use in static methods - because static is loaded by jvm
		//and you cannot refer JVM in java
		//this.x=10;
		ClassDemo6 o=new ClassDemo6(90);
		o.met();
	}
	void met() {
		//this.x=20;
		met(this);
	}
	
	void met(ClassDemo6 obj) {
		System.out.println(ClassDemo6.x);
	}
}









