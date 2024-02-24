package basics;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//ONE OBJECT - MULTIPLE THREADS - DIFFERENCE JOBS
//THEATRE - TOILET EXAMPLE
//CLASS LOCK...
public class ClassLockDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService es = Executors.newFixedThreadPool(2);
		es.execute(() -> {
			Thread.currentThread().setName("Rajni");
			synchronized (Toilet.class) {
				Theater.toilet.useToilet();
			}

		});
		es.execute(() -> {
			Thread.currentThread().setName("Kamal");
			synchronized (Toilet.class) {
				Theater.toilet.useToilet();
			}
		});
		es.shutdown();
	}

}

class Theater {
	static Toilet toilet = new Toilet();
}

class Toilet {
	public void useToilet() {
		String name = Thread.currentThread().getName();
		System.out.println(name + " is inside the toilet");
		System.out.println(name + " is using the toilet");
		System.out.println(name + " came out of the toilet");
	}
}