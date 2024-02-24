package basics;

public class ExceptionDemo3 {
	public static void main(String[] args) {
		try {
			meet(0);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	void met() {
		try {
			clone();
		}catch(Throwable t) {
			
		}
	}
	static void meet(int i)throws Exception {
		if(i==0) {
			throw new Exception();
		}
	}
}












