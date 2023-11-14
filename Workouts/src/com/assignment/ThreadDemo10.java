package com.assignment;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class ThreadDemo10 {
	public static void main(String[] args) {
		ExecutorService es=Executors.newFixedThreadPool(4);
		CinemaHall3 satyam=new CinemaHall3();
		CinemaHall3 vip=new CinemaHall3();
		
		es.execute(()->{
			//synchronized(satyam) {
				Thread.currentThread().setName("kamal");
				satyam.bookTicket(1000);
				satyam.giveChange();
			//}
		});
		es.execute(()->{
			//synchronized(vip) {
				Thread.currentThread().setName("kamal vip");
				vip.bookTicket(2000);
				vip.giveChange();
			//}
		});
		
		es.execute(()->{	
			//synchronized(satyam) {
				Thread.currentThread().setName("rajini");
				satyam.bookTicket(500);
				satyam.giveChange();
			//}
		});
		es.execute(()->{
			//synchronized(vip) {
				Thread.currentThread().setName("rajini vip");
				vip.bookTicket(1000);
				vip.giveChange();
			//}
		});
		
		es.shutdown();	
	}
}
class CinemaHall3{
	int amt;
	synchronized public void bookTicket(int amt) {
		this.amt=amt;
		String name=Thread.currentThread().getName();
		System.out.println(name+ " is booking the ticket...and amount given is..:"+amt);
		try {Thread.sleep(1000);}catch(Exception e) {}
	}
	synchronized public void giveChange() {
		String name=Thread.currentThread().getName();
		System.out.println(name+" got change of...:"+(amt-100));
	}
}
