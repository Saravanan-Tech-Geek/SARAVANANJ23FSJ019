package basics;

public class LambdaAndMethoRefDemo {
	public LambdaAndMethoRefDemo() {
		System.out.println("constructor logic assigned...");
	}
	public static void main(String[] args) {
		MyFunc1 obj=()->System.out.println("logic for met method....");
		accept(obj);
		
		MyFunc2 obj2=(i,j)->{System.out.println(i+":"+j);System.out.println("aa");};
		
		obj2.met(10,new Emp());
		
		MyFunc3 obj3=(s)->new Emp();
		System.out.println(obj3.met("hello"));
		
		//METHOD REFERENCING
		MyFunc2 objmr=LambdaAndMethoRefDemo::mymet;
		objmr.met(10,new Emp());
		
		MyFunc1 objmr1=LambdaAndMethoRefDemo::new;
		objmr1.met();
	}
	public void mymet() {
		System.out.println("mymet logic....");
	}
	public static void mymet(int i,Emp e) {
		System.out.println(i+":"+e);
	}
	static void accept(MyFunc1 f1) {
		f1.met();
	}
}
class Emp{}
interface MyFunc1{
	public void met();
}
interface MyFunc2{
	public void met(int i,Emp e);
}
interface MyFunc3{
	public Emp met(String s);
}






