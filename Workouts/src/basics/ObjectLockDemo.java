package basics;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ObjectLockDemo {
	public static void main(String[] args) {
		ReservationCounter rs = new ReservationCounter();
		ExecutorService es = Executors.newFixedThreadPool(2);
		es.execute(() -> {
			Thread.currentThread().setName("Rajni");
			synchronized (rs) {
				rs.bookticket(1000);
				rs.getChange();

			}

		});
		es.execute(() -> {
			Thread.currentThread().setName("Kamal");
			synchronized (rs) {
				rs.bookticket(500);
				rs.getChange();

			}

		});
		es.shutdown();
	}
}

class ReservationCounter {
	int amount;

	public void bookticket(int amount) {
		String name = Thread.currentThread().getName();
		this.amount = amount;
		System.out.println(name + "booked the ticket with the amount " + amount);
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
		}
	}

	public void getChange() {
		String name = Thread.currentThread().getName();
		System.out.println("Change give to " + name + " balance amount " + (amount - 100));
	}
}
