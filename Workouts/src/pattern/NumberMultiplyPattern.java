package pattern;

public class NumberMultiplyPattern {

	public static void main(String[] args) {
		int n = 5;
		// TODO Auto-generated method stub
		for(int i = 1 ; i<= n ; i++) {
			for(int j = 1 ; j<= n; j++) {
				if(i*j < 10) {
					System.out.print(0);
				}
				System.out.print(i * j + " ");
			}
			System.out.println();
		}
	}
}
