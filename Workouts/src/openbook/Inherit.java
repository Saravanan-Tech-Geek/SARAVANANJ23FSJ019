package openbook;



class Question{
  static int a = 10;
}
class Question1 extends Question{
	 static int a = 40;
}
public class Inherit extends Question1{
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		a = 100;
		System.out.println(Question.a);
		System.out.println(Question1.a);
	}

}
