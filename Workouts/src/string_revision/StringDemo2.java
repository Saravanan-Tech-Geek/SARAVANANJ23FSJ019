package string_revision;

public class StringDemo2 {
	public static void main(String[] args) {
		/*
		% - denoting the start of the format
		[flag] plus or minus to denote the padding - gives right side padding and + gives left side
		note: no need to give plus sign
		[width] - the width of the data
		. - precision
		s- string and d- integer f- float
		*/
		System.out.printf("The amount is %d and %s",90,"saro");
		System.out.println();
		System.out.printf("The amount is %f",23.454345);
		System.out.println();
		System.out.printf("The amount is %.2f",23.454345);
		
		System.out.println();
		System.out.printf("%-20s %s\n","column1","column2");
		System.out.printf("%-20s %s\n","Saravanan","Java");
				
		String s1=String.format("%-20s %s\n","column1","column2");
		System.out.print(s1);
		String s2=String.format("%-20s %s\n","Saro","JavaFS");
		System.out.println(s2);
		
	}
}
