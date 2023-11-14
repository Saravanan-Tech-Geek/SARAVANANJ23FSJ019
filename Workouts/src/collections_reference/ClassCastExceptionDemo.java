package collections_reference;

public class ClassCastExceptionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Question: can't we make Arrays heterogeneous ?
		// Answer: it will throw "java.lang.ClassCastException" - refer below code
		Object a[] = new Object[4];
		a[0] = "hello";
		a[1] = 123;
		a[2] = 12.23;
		
		for (int i = 0; i < a.length; i++) {
			//System.out.println((int)a[i]);
			System.out.println(a[i]);
		}
		
	}

}
