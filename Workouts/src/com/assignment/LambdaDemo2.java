package com.assignment;

public class LambdaDemo2 {
	public static void main(String[] args) {
		//Gandhi way
		FuncInter2 obj=new FuncInterImpl2();
		System.out.println(obj.met("hello",100,new Employee()));
		
		//Indira Gandhi way
		
		FuncInter2 obj1=new FuncInter2() {			
			@Override
			public String met(String s,int i,Employee e) {
				return "met anonymous method called..."+s+":"+i+":"+e;
			}
		};
		System.out.println(obj1.met("anonymous",999,new Employee()));
		
		//Rahul Gandhi way
		FuncInter2 obj2=(str,num,emp)->{return "met lambda method called..."+str+":"+num+":"+emp;};
		System.out.println(obj2.met("lambda",888,new Employee()));
		
		//Priyanka Gandhi way
		FuncInter2 obj3=LambdaDemo2::business2;
		System.out.println(obj3.met("method referencing",777,new Employee()));
		
	}
	public void business() {
		System.out.println("some business method called on behalf of met");
	}
	
	public static String business2(String s,int n,Employee em) {
		return "met method ref method called..."+s+":"+n+":"+em;
	}
}
class Employee{
	int i=6;
}
interface FuncInter2{
	public String met(String s,int i,Employee e);
	//public void met();
}
//Gandhi way
class FuncInterImpl2 implements FuncInter2{
	@Override
	public String met(String s,int i,Employee e) {
		return "met method called..."+s+":"+i+":"+e.i;
	}
}

