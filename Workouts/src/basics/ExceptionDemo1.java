package basics;

public class ExceptionDemo1 {
	public static void main(String[] args) {
		System.out.println("before exception...");
		try {
			int i=1/Integer.parseInt(args[0]);
		}catch(ArithmeticException e) {
			System.out.println("handling division by zero problem...");
		}catch(NumberFormatException ne) {
			System.out.println("handling alphabet entry problem...");
		}
//		}catch(Exception ee) {
//			System.out.println("handle all other exceptions...");
//		}
		finally {
			System.out.println("finally called....");
		}
		System.out.println("after exception...");
	}
}








