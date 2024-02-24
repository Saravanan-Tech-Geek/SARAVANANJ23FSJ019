package collections_reference;

import java.util.ArrayList;
import java.util.List;

public class GenericsDemo {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("Sara");
		list.add("raju");
		list.add("somu");
		met(list);
		System.out.println(list);
	}

	private static <E> void met(List<E> list) {
//		list.add(10);
//		list.add(12);
//		list.add(10.5);
	}
	
}
