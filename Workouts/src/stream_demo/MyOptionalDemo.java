package stream_demo;

import java.util.Optional;

public class MyOptionalDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s = new String[5];
		s[0] = "HELLO";
		// Gandhi way
		if (s[0] != null) {
			System.out.println(s[0].toLowerCase());
		} else {
			System.out.println("Array index contains null value");
		}
		// rahul Gandhi way
		String result = Optional.ofNullable(s[1]).orElse("DEFAULT");
		System.out.println(result.toLowerCase());

		// this will work only it is not null
		Optional.of(s[0]).ifPresent(t -> System.out.println(t));

//	    Optional.of(s[1]).ifPresentOrElse(System.out::print,
//		()->{System.out.print("run run run run");});

		Optional.ofNullable(s[1]).ifPresentOrElse(MyOptionalDemo::print, () -> {
			System.out.println("run run run");
		});
	}

	static void print(String s) {
		System.out.println(s);
	}

}
