package basics;

import java.util.Scanner;

public class DatatypesDemo {
	// Declaring variables
	// variables are of 4 types in java - number, floating, char, boolean
	// number types - byte, short,int,long
	// float types - float,double
	// char
	// boolean - true or false
	public static void main(String[] args) {
		// number types
		byte b = 10;// 8 bit storage - -128 to + 127 is the range
		short s = 20;// 16 bit storage - 32768 to + 32767 is the range
		int i = 30;// 32 bit storage - 2147483648 + 2147483648 is the range
		long l = 40;// 64 bit storage - 9,223,372,036,854,775,808 to + 9,223,372,036,854,775,807

		byte bb = -128;
		short ss = 32767;
		int ii = 2147_483647;
		long ll = 9_223_372_036_854_775_807L;

		// float types
		float f = 3.14f;// 32 bit
		double d = 9_223_372_036_854_775_807.2343D;// 64 bit

		// char
		char c = 97;
		c = 'a';// 16 bit

		// boolean
		boolean boo = true;// either true or false and not 0/1.

		// complex type

		String str = "hello world";// there is not size limit and its a object

		// dif between var and object - var wont have properties and methods where as
		// object has them

		// wrapper

		Byte by = 10;
		Short sh = 20;
		Integer in = 30;
		Long lo = 40L;

		Boolean bo = true;
		Character ch = 'a';
		Float fl = 3.14f;
		Double dou = 2323.23D;
		// though wrapper classes are there from jdk1, still they could not be used the
		// above way
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.compare(30, 20));
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter first number..:");
		String st1 = scan.next();
		System.out.println("Please enter second number..:");
		String st2 = scan.next();
		System.out.println(st1 + st2);
		int x = Integer.parseInt(st1);
		int y = Integer.parseInt(st2);
		System.out.println(x + y);

		// TYPE CASTING

		byte bite = 100;
		int intnum = bite;// auto type promotion has happened

		bite = (byte) intnum;// 32 bit cannot be stored in 8 bit - so need to do explicit casting

		byte bite2 = 1;

		byte bite3 = (byte) (bite * bite2);// +,-,*,/,% - the result will be always of type int

		float flo = 3.14f;
		int myint = (int) flo;
		flo = myint;// a int can get into float but not vice versa

		char cha = 'a';
		cha = 65535;// 0 TO 65535; - 2 TO THE POWER OF 16

		// SIGNED DATA TYPES CAN CONTAINT MINUS AND PLUS VALUES -
		// BYTE,SHORT,INT,LONG,FLOAT,DOUBLE
		// UNSIGNED DATA TYPE CAN ONLY CONTAIN PLUS VALUES - EX: CHAR - 16 BIT - 0 TO
		// 65535

		int sss = cha;
		cha = (char) sss;// you cannot give int to a character

		sss = 257;
		bite = (byte) 259;
		System.out.println(bite);// the result will be 1 - divides the number by 256 and it will return the
									// reminder

	}
}
