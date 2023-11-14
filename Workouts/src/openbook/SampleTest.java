package openbook;

public class SampleTest {
	public static void main(String[] args) {
		int n = 5;
		int sum = 0;
		for(int i=0 ;i <= n*2 ;i++){
			  if(i % 2 == 0 && i % 3 == 0){
			    sum += i;
			  }
			}
			System.out.print(sum);

	}
}
