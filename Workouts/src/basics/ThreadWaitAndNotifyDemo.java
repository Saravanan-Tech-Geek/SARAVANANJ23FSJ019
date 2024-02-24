package basics;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Thread.sleep - when sleep method is called on a thread inside a monitor, then another thread cannot enter the monitor
//wait() - when wait method is called on a thread inside a monitor, then another thread CAN enter the monitor
public class ThreadWaitAndNotifyDemo {

	public static void main(String[] args) {
		BoomerGun bofors=new BoomerGun();
		ExecutorService es=Executors.newFixedThreadPool(2);
		es.execute(()->{
			Thread.currentThread().setName("rajini");
			for(int i=0;i<5;i++) {
				bofors.fill();
			}
		});
		es.execute(()->{
			Thread.currentThread().setName("kamal");
			for(int i=0;i<5;i++) {
				bofors.shoot();
			}
		});
		es.shutdown();
	}

}

class BoomerGun{
	boolean flag;
	synchronized public void fill() {
		if(flag) {
			try {
				wait();
			}catch(Exception e) {
				
			}
		}
		String name = Thread.currentThread().getName();
		System.out.println(name + "fills the gun");
		flag = true;
		notify();
	}
	synchronized public void shoot() {
		if(!flag) {
			try {wait();}catch(Exception e) {}
		}
		String name = Thread.currentThread().getName();
		System.out.println(name + "shoot the gun..................");
		flag=false;
		notify();
	}
}
