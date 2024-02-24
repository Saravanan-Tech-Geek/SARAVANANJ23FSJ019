package basics;

public class ExceptionDemo4 {
	public static void main(String[] args) {
		try {
			met(0);
		}catch(CustomException ce) {
			ce.printStackTrace();
		}
	}
	static void met(int i)throws CustomException {
		if(i==0) {
			throw new CustomException("the i value is zero....");
		}
	}
}
class CustomException extends Exception{
	String msg;
	public CustomException(String msg) {
		this.msg=msg;
	}
	@Override
	public String toString() {
		return "Exception is...:"+this.msg;
	}
}






