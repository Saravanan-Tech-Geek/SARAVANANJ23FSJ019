package Introduction;

public class PrintAsciiValue {
	public static void main(String[] args) {
		char ch = 'S';
		int asciiValueInNumber = (int)ch;
		System.out.println("Numerical respresentation of character \'S\' is:" + asciiValueInNumber);
	
		char chs = 'H';
		int ascii = chs;
		// You can also cast char to int
		int castAscii = (int) chs;
		System.out.println("The ASCII value of " + ch + " is: " + ascii); 
		System.out.println("The ASCII value of " + ch + " is: " + castAscii);
	}

}
