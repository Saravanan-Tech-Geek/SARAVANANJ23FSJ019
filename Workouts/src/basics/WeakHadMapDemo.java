package basics;

import java.util.HashMap;
import java.util.WeakHashMap;

public class WeakHadMapDemo {
	public static void main(String[] args) {
		// HashMap<String, String> hm = new HashMap<>();

		WeakHashMap<String,String> hm = new WeakHashMap<>();
		
		String key1 = new String("a1");
		String key2 = new String("a2");
		
		hm.put(key1, "jaga");
		hm.put(key2, "barani");
		
		System.out.println("Printing after map creation"+ hm);
		
		key1 = null;
		
		System.out.println("Printing after Key1 is null"+ hm);
		
		System.gc();
		
		System.out.println("Printing after GC is invoked"+ hm);

		

	}
}
