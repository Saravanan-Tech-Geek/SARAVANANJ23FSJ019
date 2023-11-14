package collections_reference;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class PropertiesDemo {

	public static void main(String[] args) throws Exception {
		// Properties legacy collection - works as map
		// Main advantage is to use localization and internationalization
		// For key - value pairs like dictionaries we can use properties
		// Data loading from a file is major advantage of Properties collections which makes the difference comparing with Hashmap  
		// Collections.sort is not available
		// Streams not available
		Properties prop = new Properties();
		// adding values using put method
//		prop.put("a1", "jaga");
//		prop.put("a2", "bharani");
//		prop.put("a3", "suresh");

		// using load method we are loading datas from a file
		prop.load(new FileInputStream("data.properties"));

		System.out.println(prop);

		Set set = prop.entrySet();
		Iterator iter = set.iterator();
		while (iter.hasNext()) {
			Map.Entry<Object, Object> me = (Map.Entry<Object, Object>) iter.next();
			System.out.println(me.getKey() + ":" + me.getValue());
		}
	}

}
