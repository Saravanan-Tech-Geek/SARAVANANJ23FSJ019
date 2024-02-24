package basics;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class GarbageDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runtime runtime = Runtime.getRuntime();
		System.out.println("Before thatha birth "+ runtime.freeMemory());
		GrandFather thatha = new GrandFather();
		System.out.println("After thatha birth "+ runtime.freeMemory());

//		SoftReference<GrandFather> soft = new SoftReference<GrandFather>(thatha);
		WeakReference<GrandFather> weak = new WeakReference<GrandFather>(thatha);
		thatha = null;
		System.out.println("After thatha death "+ runtime.freeMemory());
		
		// System.gc and runtime.gc - both are same
		// System.gc is static method ; while runtime.gc is non-static
		runtime.gc(); //Garbage collector will delete the thatha object from the memory.
		System.out.println("After doing proper rituals at thatha funreal "+ runtime.freeMemory());
		
//		thatha = soft.get();
//		System.out.println(thatha.getGold());
		
		thatha = weak.get();
		System.out.println(thatha.getGold());
		
	}

}

class GrandFather{
	String life = "";
	
	private String gold = "under the tree";
	
	public GrandFather() {
		for(int i =0 ; i < 100000 ; i++) {
			life = new String("life is so beautiful");
		}
	}
	
	protected String getGold() {
		return gold;
	}
    //finalize is a galaxy method which will call before object is deleted by garbage collector
	//finalize belongs to Object class so all classes can override it.
	@Override
	protected void finalize() throws Throwable {
		System.out.println("finalize method called");
		System.out.println("the gold is "+ gold);
	}
}
