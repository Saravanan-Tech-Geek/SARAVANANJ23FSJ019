package com.assignment;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class ThreadDemo7 {
	public static void main(String[] args) {
		ExecutorService es=Executors.newFixedThreadPool(2);
		CinemaHall satyam=new CinemaHall();
		es.execute(()->{
			Thread.currentThread().setName("kamal");
			satyam.sulab.useToilet();
		});
		es.execute(()->{
			Thread.currentThread().setName("rajini");
			satyam.sulab.useToilet();
		});
		
		es.shutdown();		
	}
}
class Toilet{
	public void useToilet() {
		Thread t=Thread.currentThread();
		String name=t.getName();
		System.out.println(name+" is using the toilet..");
		try {Thread.sleep(5000);}catch(Exception e) {}
		System.out.println(name+" has come out of toilet...");
	}
}
class CinemaHall{
	Toilet sulab=new Toilet();
}