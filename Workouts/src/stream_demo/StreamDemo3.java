package stream_demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StreamDemo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");

		// Gandhi way
		Iterator<String> iter = list.iterator();
		while (iter.hasNext()) {
			String s = iter.next();
			if (s.equals("c")) {
				System.out.println("Yeh!! I found the c");
			}
		}

		list.stream().findAny().of("C").ifPresent((i) -> {
			System.out.println("I found the C using streams");
		});

		list.stream().forEach(System.out::println);

		list.stream().parallel().forEachOrdered(System.out::print);

		// RAHUL GANDHI WAY
		list.stream().findAny().of("c").ifPresent(i -> System.out.println("I found c....in a new way YO YO"));
		System.out.println("WITHOUT PARALLEL");
		list.stream().forEach(i -> System.out.print(i + "\t"));
		System.out.println();
		list.stream().forEachOrdered(i -> System.out.print(i + "\t"));
		System.out.println("\nPARALLEL");
		list.stream().parallel().forEach(i -> System.out.print(i + "\t"));
		System.out.println();
		list.stream().parallel().forEachOrdered(i -> System.out.print(i + "\t"));
	}

}
