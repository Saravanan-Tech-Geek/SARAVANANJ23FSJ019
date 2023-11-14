package openbook;

import java.io.File;

public class QuestionPrint {
	 public static void main(String[] args) {
//		try {
//			PrintWriter obj = new PrintWriter(System.out);
//			obj.write('4'+'2');
//			obj.close();
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		 File obj = new File("Java/course/july/2023");
		 System.out.println(obj.getPath());
	}
}
