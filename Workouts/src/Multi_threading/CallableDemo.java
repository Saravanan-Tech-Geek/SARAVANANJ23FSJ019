package Multi_threading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {
	public static void main(String[] args)throws Exception {
		ExecutorService es=Executors.newFixedThreadPool(2);
		
		//es.execute(new MyRunnable());//this is used for runnable
		Future<Person> future= es.submit(()->{
			System.out.println("callable child thread....");
			return new Person();
		});
		es.execute(()->{System.out.println("another thread...");
			try{Thread.sleep(2000);}catch(Exception e) {}
			System.out.println("continuing...finished...");
		});
		Person p=future.get();
		System.out.println(p);
		
		
		es.shutdown();
	}
}
class MyCallable1 implements Callable<Person1>{
	@Override
	public Person1 call() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("child thread called...");
		try {Thread.sleep(5000);}catch(Exception e) {}
		return new Person1();
	}
}
class Person1{}
class MyRunnable1 implements Runnable{
	@Override
	public void run() {
		System.out.println("thread called..");
	}
}
