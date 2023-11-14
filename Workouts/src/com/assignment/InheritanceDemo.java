package com.assignment;

public class InheritanceDemo {
	public static void main(String[] args) {
		MountBike mountBikeObj = new MountBike();
		mountBikeObj.displayEngineDataUsingInnerClassObj();
	}

}

class Bike {
	private int engineData = 20;
	Bike() {
		System.out.println("Bike cons called");
	}
	class Engine{
		public void displayEngineData() {
			System.out.println("Engine datas:" + engineData);
		}
	}
}

class MountBike extends Bike{
	MountBike() {
		System.out.println("Mountbike cons called");
	}
	public void displayEngineDataUsingInnerClassObj() {
		Engine engineObj = new Engine();
		engineObj.displayEngineData();
	}
}