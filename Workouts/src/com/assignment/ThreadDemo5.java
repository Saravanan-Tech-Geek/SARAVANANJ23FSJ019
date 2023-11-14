package com.assignment;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadDemo5 {
	public ThreadDemo5() {
		ExecutorService es=Executors.newFixedThreadPool(1);
		es.execute(()->{System.out.println("child thread called....");});
		es.shutdown();
	}
	public static void main(String[] args) {
		new ThreadDemo5();
		for(int i=0;i<5;i++) {
			System.out.println(i);
			try {Thread.sleep(1000);}catch(Exception e) {}
		}
	}
}