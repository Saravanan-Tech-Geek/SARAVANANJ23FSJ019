package Multi_threading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadDemo1 {
	public static void main(String[] args) throws Exception {
		// Runnable is used to assign job for the thread
		// Runnable is a void function
		// where callable is a return function
		ExecutorService es = Executors.newFixedThreadPool(2);
		es.execute(() -> {
			System.out.println("Job for thread using Runnable interface run method");
		});
		Future<Person> fs = es.submit(() -> {
			System.out.println("Child thread called");
			return new Person();
		});
		es.execute(() -> {
			System.out.println("second thread...");
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
			}
			System.out.println("continuing second...finished...");
		});
		es.execute(() -> {
			System.out.println("third thread...");
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
			}
			System.out.println("continuing third...finished...");
		});
		Person p = fs.get();
		System.out.println(p);
		es.shutdown();
	}
}

class MyCallable implements Callable<Person> {

	@Override
	public Person call() throws Exception {
		System.out.println("callable method called");
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}
		return new Person();
	}

}

class MyRunnable implements Runnable {
	@Override
	public void run() {
		System.out.println("thread called..");
	}
}

class Person {

}