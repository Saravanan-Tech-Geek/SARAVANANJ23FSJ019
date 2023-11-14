package collections_reference;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ComparableAndComparator {
	public static void main(String[] args) {
		List<Employee> mylist = new LinkedList<>();
		// hang him not, leave him
		mylist.add(new Employee("rahim"));
		mylist.add(new Employee("kamil"));
		mylist.add(new Employee("aadhil"));
		mylist.add(new Employee("sajid"));
		mylist.add(new Employee("sachin"));

		System.out.println(mylist);

		Collections.sort(mylist);
		System.out.println(mylist);

		// Collections.sort(mylist,(o1,o2)->{return o2.compareTo(o1);});
		Collections.sort(mylist, new MyComparator());
		System.out.println(mylist);
	}
}

class MyComparator implements Comparator<Employee> {
	@Override
	public int compare(Employee o1, Employee o2) {
		return o2.compareTo(o1);
	}
}

class Employee implements Comparable<Employee> {
	String name;

	public Employee(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name;
	}

	@Override
	public int compareTo(Employee o) {
		return this.name.compareTo(o.name);
	}
}