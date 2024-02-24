package basics;

public class RecursionDemo {
	public static void main(String[] args) {
		int result=met(4);
		System.out.println(result);
	}
	
	static int met(int i) {
		if(i==0) {
			return 1;
		}
		int result=i+met(i-1);
		return result;
	}
}
