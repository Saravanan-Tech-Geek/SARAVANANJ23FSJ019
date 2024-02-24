package basics;

public class ArrayDemo2 {
	public static void main(String[] args) {
		int a[]=new int[5];
		
		int[][] twod= {
				{10,20,30},
				{100,200,300}
		};
		
		twod[0][0]=999;
		System.out.println(twod[0][0]);//10
		System.out.println(twod[1][1]);//200
		System.out.println(twod[1][2]);//200
		
		System.out.println(twod.length);//this returns number of rows
		System.out.println(twod[0].length);//this returns number of columns
		
		//uneven multi dimensional array
		
		String s[][]=new String[3][];
		s[0]=new String[4];
		s[1]=new String[3];
		s[2]=new String[1];
		s[0][1]="hello";
		
		for(String[] value : s) {
			for(String element : value) {
				System.out.println("S array" + element);
			}
		}
		
		System.out.println(s.length);//3 - no of rows
		System.out.println(s[0].length);//4 no of columns
		System.out.println(s[1].length);//3 no of columns
		
		//FOR LOOP
		
		for(int i=0;i<s.length;i++) {//s.length will return 3
			for(int j=0;j<s[i].length;j++) {
				System.out.print(s[i][j]+"\t");
			}
			System.out.println();
		}
		
		//jdk - for-each or enhanced for loop
		
		for(String i[]:s) {
			for(String x:i) {
				System.out.print(x+"\t");
			}
			System.out.println();
		}
	}
}
