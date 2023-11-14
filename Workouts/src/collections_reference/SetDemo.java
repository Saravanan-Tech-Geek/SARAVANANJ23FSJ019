package collections_reference;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;


//SET Collections - HashSet & TreeSet
/**
 * SET Follows TIM - The insertion and Merge Algorithm
 * Allow unique elements 
 * Doesn't maintain orders
 * HashSet - has initial capacity and load capacity
 * e.g Initial capacity - 10 , it won't shrink or expand the load capacity e.g 3 until elements reached 20
 * SET has no Collections.sort 
 * It has iterator, listIterator and elements
 */

//Tree SET - By default sorted 
// won't allow duplicates 
//doesn't have initial capacity and load capacity 
// has comparator 

public class SetDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> set = new HashSet<>();
		set.add("ddd");
		set.add("zzz");
		set.add("ccc");
		set.add("ttt");
		set.add("aaa");
		set.add("bbb");
		set.add("xxx");
		
		System.out.println(set);
		System.out.println(set.contains("ddd"));
		System.out.println(set.isEmpty());
		set.remove("ccc");
		//Collections.sort(set);
		
		System.out.println("-----Iterator------");
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		System.out.println("----Tree Set----");
		Set<String> set1 = new TreeSet<>();
		set1.add("ddd");
		set1.add("zzz");
		set1.add("ccc");
		set1.add("ttt");
		set1.add("aaa");
		set1.add("bbb");
		set1.add("xxx");
		
		System.out.println(set1);
		
	}

}
