package pattern;

public class TrianglePattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		for (int i = 1; i <= n; i++) {
			for (int k = 1; k <= n-i ; k++) {
				System.out.print(" ");
			}
			for(int j = 1; j <= i ; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("------------");
		int m = 5;
		for (int i = 1; i <= m; i++) {
			for (int k = 1; k <= m-i ; k++) {
				System.out.print(" ");
			}
			for(int j = 1; j <= i ; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

}
