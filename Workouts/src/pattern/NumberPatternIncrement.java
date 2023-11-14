package pattern;

public class NumberPatternIncrement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int count;
		for(int i = 0 ; i < n ; i++) {
			count =  i + 1;
			for(int j = 0 ; j < n ; j++) {
				System.out.print(count++ + " ");
			}
			System.out.println();
		}
	}

}
