package stream_demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class StreamDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Item> myList = new ArrayList<>();
		myList.add(new Item("rice", 80));
		myList.add(new Item("daal", 50));
		myList.add(new Item("groundnut", 120));
		myList.add(new Item("oil", 160));

		// Display all items using foreach and lambda

		myList.stream().forEach((v) -> {
			System.out.println("####" + v);
		});

		// Display all elements using Foreach and method reference

		myList.stream().forEach(System.out::println);
		
		myList.stream().forEach(new MyConsumer1());

		// Display the items whose price is less than 100
		long count = myList.stream().filter(t -> t.price < 100).count();
		System.out.println("Count of item price less than 100: " + count);

		// Sorted list
		List<Item> sortedList = myList.stream().sorted().collect(Collectors.toList());
		System.out.println("Sorted list: " + sortedList);

		// reverse ordered list
		List<Item> reverseList = myList.stream().sorted((o1, o2) -> {
			return o2.compareTo(o1);
		}).collect(Collectors.toList());
		System.out.println("Reverse ordered list: " + reverseList);

		// Pick up all the items whose price is greater than 100 and store it in another
		// list
		List<Item> newList = myList.stream().filter(n -> n.price > 100).collect(Collectors.toList());
		System.out.println("newList" + newList);

		// Pick up all the items whose price is greater than 100 and store it in another
		// list with just name of the item
		List<String> nameList = myList.stream().filter(n -> n.price > 100).map(n -> n.name)
				.collect(Collectors.toList());
		System.out.println("nameList" + nameList);

		// Read the Item objects and find the average price and returns a optional
		// object
		OptionalDouble d = myList.stream().mapToDouble(t -> t.price).average();
		System.out.println("Double" + d + ":" + d.getAsDouble());

		double d2 = myList.stream().mapToDouble(t -> t.price).average().orElse(0);
		System.out.println(d);

		// Read a collection and return a collection with square of each number in given
		// collection
		List<Integer> numbers = List.of(1, 2, 3, 4, 5);
		List<Integer> sqaureNumbers = numbers.stream().map(n -> n * n).toList();
		System.out.println("Square numbers: " + sqaureNumbers);

		// list the items using parallel stream without ordering
		new Thread(() -> myList.parallelStream().forEach((t) -> {
			System.out.println("$$" + t);
		})).start();
		// list the items using parallel stream with ordering
		new Thread(() -> myList.parallelStream().forEach((t) -> {
			System.out.println("@@" + t);
		})).start();
		//Basic example for Parallel Stream - forEach and ForEachOrdered
		List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5);

		// Using forEach with a parallel stream (order is not guaranteed)
		numbers1.parallelStream().forEach(number -> {
		    System.out.println("order not guaranteed :"+number);
		});
		
		List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5);

		// Using forEachOrdered with a parallel stream (order is guaranteed)
		numbers2.parallelStream().forEachOrdered(number -> {
		    System.out.println("order gauranteed : "+number );
		});

	}

}

class MyConsumer1 implements Consumer<Item>{

	@Override
	public void accept(Item t) {
		System.out.println("consumer impl..: "+t.name);
	}
	
}

class Item implements Comparable<Item> {
	String name;
	int price;

	public Item(String name, int price) {
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name + ":" + this.price;
	}

	@Override
	public int compareTo(Item o) {

		return this.name.compareTo(o.name);
	}

}