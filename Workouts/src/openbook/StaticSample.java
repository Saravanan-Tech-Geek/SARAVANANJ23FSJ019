package openbook;

public class StaticSample {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
//		Test obj = new Test(); //first obj // Asha homes - memory allocation
//		int result = obj.a;  
//		System.out.println(result);
//		
//		Test obj1 = new Test(); //second obj //Saravanan homes - memory allocation
//		int output = obj1.a;
//		System.out.println(output);
		
//		System.out.println(Test.collegename);
//		Test.metstatic();
		
		Test obj = new Test();
		
		
		
		
//		int i = 10; 10 value i varible store of type integer
	}
	
}

//Sample template House blueprint
class Test{
	int rollno = 0;
	//static block
	static {
		System.out.println("Static block of Test called...!!");
	}
	//instance block
	{
		System.out.println("Instance block called!!");
	}
	Test(){
		System.out.println("Test constrcutor called..!");
	}
	Test(int rollno){
		this.rollno = rollno;
		System.out.println("paramterized constructor" + rollno);
	}
	int a = 10; // instance variable - object scope
	static String collegename = "hindustan"; //class scope
	public void met() {
		System.out.println("met called");
	}
	public static void metstatic() {
		System.out.println("static met called");
	}
}
