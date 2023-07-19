package Tryouts;

public class StudentResultsInTwoDimesnionalArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] studentMarks = { 
				{ 90, 70, 50, 60, 80 }, 
				{ 60, 40, 70, 90, 70 }, 
				{ 70, 70, 50, 60, 50 } };

		int finalResult = 0;
		for(int[] student : studentMarks) {
			for(int studentmarks : student) {
				finalResult += studentmarks;
			}
		}
		System.out.println("total marks...:"+ finalResult);
		
		int result = 0;
		for (int i = 0; i < studentMarks.length; i++) {
			for (int j = 0; j < studentMarks[i].length; j++) {
				result += studentMarks[i][j];
			}
			System.out.println("Student " + i + " result is..." + result);
			result = 0;
		}
	}

}
