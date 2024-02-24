package basics;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkAndJoinDemo {
	
	public static void main(String[] args) {
		String str[] = {"chennai","banglore","chennai","chennai","Hyderabad","chennai","chennai","Salem","Madurai"};
		int count = 0;
//		for(String s: str) {
//	
//			if(s.equals("chennai")) {
//				count++;
//			}
//		}
		
		ForkJoinPool fjp = ForkJoinPool.commonPool();
		int i1 = fjp.invoke(new MyTask(str, 0, 3));
		int i2 = fjp.invoke(new MyTask(str, 3, 6));
		int i3 = fjp.invoke(new MyTask(str, 6, 9));
		
		count = i1+ i2 + i3;
		
		System.out.println("chennai repeated "+ count);
	}
}

class MyTask extends RecursiveTask<Integer>{
	String array[];
	int start;
	int end;

	public MyTask(String[] array, int start, int end) {
		this.array = array;
		this.start = start;
		this.end = end;
	}


	@Override
	protected Integer compute() {
		int count = 0;
		for(int i = start ; i < end ; i++) {
			if(array[i].equals("chennai")) {
				++count;
			}
		}
		return count;
	}
	
}
