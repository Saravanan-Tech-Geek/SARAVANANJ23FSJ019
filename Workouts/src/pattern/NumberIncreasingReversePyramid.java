package pattern;

public class NumberIncreasingReversePyramid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		for(int i = 1 ; i <= n ; i++) {
			for(int j = n ; j >= i ; j--) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
		System.out.println("###########");
		int m = 5;
		for(int i = m ; i >= 1 ; i--) {
			for(int j = 1 ; j <= i ; j++) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}

}
