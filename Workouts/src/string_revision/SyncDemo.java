package string_revision;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SyncDemo {
	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(2);
		es.execute(()->{
			SyncTest.syncTestMet();
		});
		es.execute(()->{
			SyncTest.syncTestMet();
		});
		es.shutdown();
	}
}

class SyncTest{
	public synchronized static void syncTestMet() {
		System.out.println("called");
		try {Thread.sleep(2000);}catch(Exception e){}
		System.out.println("finished");
	}
}