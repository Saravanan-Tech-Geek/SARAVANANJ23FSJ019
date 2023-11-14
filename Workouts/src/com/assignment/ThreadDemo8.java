package com.assignment;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class ThreadDemo8 {
	public static void main(String[] args) {
		ExecutorService es=Executors.newFixedThreadPool(2);
		CinemaHall1 satyam=new CinemaHall1();
		CinemaHall1 rohini=new CinemaHall1();
		es.execute(()->{
			synchronized(Toilet1.class) {
				Thread.currentThread().setName("kamal");
				satyam.sulab.useToilet();
			}
		});
		es.execute(()->{
			synchronized(Toilet1.class) {
				Thread.currentThread().setName("rajini");
				rohini.sulab.useToilet();
			}
		});
		
		es.shutdown();		
	}
}
class Toilet1{
	public Toilet1() {
		System.out.println("toilet1 object created...");
	}
	public void useToilet() {
		Thread t=Thread.currentThread();
		String name=t.getName();
		System.out.println(name+" is using the toilet..");
		try {Thread.sleep(5000);}catch(Exception e) {}
		System.out.println(name+" has come out of toilet...");
	}
}
class CinemaHall1{
	static Toilet1 sulab=new Toilet1();
}