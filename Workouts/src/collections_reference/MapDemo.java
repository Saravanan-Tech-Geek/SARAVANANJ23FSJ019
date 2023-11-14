package collections_reference;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


/*
 * Map - HashMap & TreeMap 
 * Has put method ( no add method)
 * Has key-value pairs
 */
public class MapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,String> map = new HashMap<String,String>();
		map.put("a1", "ramu");
		map.put("a2","somu");
		
		System.out.println(map);
		
		Set<Map.Entry<String,String>> set = map.entrySet();
		Iterator<Map.Entry<String,String>> iter= set.iterator();
		while(iter.hasNext()) {
			Map.Entry<String, String> me = iter.next();
			System.out.println(me.getKey()+ " " + me.getValue());
		}
		
	}

}
