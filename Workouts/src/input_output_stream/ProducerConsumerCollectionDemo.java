package input_output_stream;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducerConsumerCollectionDemo {
	// concurrent util package
	// blocking queue, delayed queue, arraylist queue
	// these queue's are used to replace the collection
	// At Normal collection, one thread can write to an arraylist and another thread
	// can read from arraylist. Without using wait , notify and synchronized
	// blocking queue will do that automatically
	public static void main(String[] args) {
		BlockingQueue<String> bq = new ArrayBlockingQueue<>(2000);

		ExecutorService es = Executors.newFixedThreadPool(2);

		es.execute(() -> {
			Thread.currentThread().setName("Producer");
			System.out.println("Producer thread started!!");
			try {
				Thread.sleep(5000);
				bq.put("hello1");
				Thread.sleep(5000);
				bq.put("hello12");
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		es.execute(() -> {
			Thread.currentThread().setName("consumer");
			System.out.println("Consumer thread started!!");
			try {
				System.out.println("reading...1"+ bq.take());
				System.out.println("reading...2"+ bq.take());
			} catch (Exception e) {
				e.printStackTrace();
			}
		});


		es.shutdown();
	}

}
