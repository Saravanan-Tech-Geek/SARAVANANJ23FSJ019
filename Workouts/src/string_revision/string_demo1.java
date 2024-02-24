package string_revision;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class string_demo1 {
	public static void main(String[] args) {
		// String is immutable
//		String s = "Sa";
//		String temp = s;
//
//		s = s + "ravanan";
//		System.out.println("String s: " + s);
//		System.out.println("String temp: " + temp);
//
//		String s1 = new String("Sa");
//		String temp1 = s1;
//
//		s1 = s1 + "ravanan";
//		System.out.println("String s1: " + s1);
//		System.out.println("String temp1: " + temp1);
//
//		// StringBuilder or StringBuffer is mutable
//
//		StringBuilder sbb = new StringBuilder("Hello");
//		StringBuilder sbbtemp = sbb;
//		sbb.append("world");
//		System.out.println(sbb);
//		System.out.println(sbbtemp);
//
//		timeTest();
		concurrenyTest();

	}

	public static void timeTest() {
		// StringBuffer - Synchronized
		StringBuffer sb = new StringBuffer("Buffer");
		long l1 = System.currentTimeMillis();
		for (int i = 0; i < 2000; i++) {
			sb.append("java" + i);
		}
		long l2 = System.currentTimeMillis();
		System.out.println("Buffer time.synchronized.:" + (l2 - l1) + "..MS..slow");

		// StringBuilder - (non-synchronized)
		StringBuilder sbbb = new StringBuilder("Buffer");
		l1 = System.currentTimeMillis();
		for (int i = 0; i < 2000; i++) {
			sbbb.append("java" + i);
		}
		l2 = System.currentTimeMillis();
		System.out.println("Builder time.non synchronized.:" + (l2 - l1) + "..MS..fast");
	}

	public static void concurrenyTest() {
		StringBuffer sbf = new StringBuffer("Buffer");
		//StringBuilder sbb = new StringBuilder("Builder");
		ExecutorService es = Executors.newFixedThreadPool(2);
		es.execute(() -> {
			for (int i = 0; i < 2; i++) {
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
				}
				System.out.println(sbf.append("java" + i));

			}
		});
		es.execute(() -> {
			for (int i = 0; i < 2; i++) {
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
				}
				System.out.println(sbf.append("sara" + i));

			}
		});
		es.shutdown();
	}

}
