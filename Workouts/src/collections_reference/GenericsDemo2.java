package collections_reference;

import java.util.ArrayList;
import java.util.List;

public class GenericsDemo2<T> {
	public static void main(String[] args) {
		GenericsDemo2<String> obj=new GenericsDemo2<String>();
		obj.accept('a');
		obj.accept(20);
		obj.accept("a");
		//obj.getGet(new Person2());
	}
	
//	public void accept(Character c) {
//		System.out.println(c);
//	}
//	public void accept(Integer i) {
//		System.out.println(i);
//	}
//	public void accept(Object o) {
//		Integer i=(Integer)o;
//	}
	public <E> void accept(E obj) {//generic method
		//Integer i=(Integer)obj;
		System.out.println("Generic type safe method...:"+obj);
	}
	
//	public <E> void accept2(E[] obj) {
//		
//	}
//	public <E> E get(E obj) {
//		return obj;
//	}
//	
//	public <E extends SuperPerson> E getGet(E obj){
//		//extends is used when declaring for return or type
//		//super is used when you are accepting or adding some object
//		List<? super SuperPerson> list=new ArrayList<>();
//		list.add(new Person2());
//		return null;
//	}
}
class SuperPerson{}
class Person1{}
class Person2 extends SuperPerson{}
