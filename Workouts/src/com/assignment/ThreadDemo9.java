package com.assignment;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class ThreadDemo9 {
	public static void main(String[] args) {
		ExecutorService es=Executors.newFixedThreadPool(2);
		CinemaHall2 satyam=new CinemaHall2();
		es.execute(()->{
				Thread.currentThread().setName("kamal");
				satyam.bookTicket(1000);
				satyam.giveChange();
		});
		es.execute(()->{		
				Thread.currentThread().setName("rajini");
				satyam.bookTicket(500);
				satyam.giveChange();			
		});
		
		es.shutdown();	
	}
}
class CinemaHall2{
	int amt;
	synchronized public void bookTicket(int amt) {
		this.amt=amt;
		String name=Thread.currentThread().getName();
		System.out.println(name+ " is booking the ticket...and amount given is..:"+amt);
	}
	synchronized public void giveChange() {
		String name=Thread.currentThread().getName();
		System.out.println(name+" got change of...:"+(amt-100));
	}
}