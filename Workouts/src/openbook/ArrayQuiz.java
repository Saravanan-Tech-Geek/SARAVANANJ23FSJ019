package openbook;

public class ArrayQuiz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = {1,0,1};
		for(int i= 0 ; i<A.length;i++) {
			A[i] = A[A[i]+ 3 % A.length];
		}
		for(int i=0;i<A.length;i++) {
			System.out.println(A[i]);
		}
	}

}
