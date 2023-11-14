package collections_reference;

import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Vector;

// Vector is a legacy class in java
// All methods in Vector are synchronized , thus it makes thread safe
// Enumeration is available only in Vector and Hashtable

public class VectorDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector<String> v = new Vector<>();
		v.add("sara");
		v.add("bharani");
		v.add("jaga");
		System.out.println("-----vector elements printing");
		System.out.println(v);
		System.out.println("-------Sorting--------");
		Collections.sort(v);
		System.out.println(v);
		
		System.out.println("-------Sorting using comparator--------");
		// o2.compareTo(o1) prints value in descending order
		Collections.sort(v,(o1,o2)->{return o2.compareTo(o1);});
		System.out.println(v);
		
		System.out.println("-------Iterator--------");
		Iterator<String> iter = v.iterator();
		//v.add("Muthu"); - after creating iterator obj if we try to add new elements to
		// vector it will throw concurrentModificationException
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println("-------List Iterator--------");
		ListIterator<String> listiter = v.listIterator();
		while(listiter.hasNext()) {
			System.out.println(listiter.next());
		}
		System.out.println("-------List Iterator hasPrevious--------");
		while(listiter.hasPrevious()) {
			System.out.println(listiter.previous());
		}
		System.out.println("------Enumeration---------");
		
		//java.util.ConcurrentModificationException - can be avoided in Enumeration
		
		Enumeration<String> e = v.elements();
		v.add("Muthu");
		while(e.hasMoreElements()) {
			System.out.println(e.nextElement());
		}
		
		System.out.println("--------Streams-----");
		v.stream().forEach(System.out::println);
		
		
	}

}
