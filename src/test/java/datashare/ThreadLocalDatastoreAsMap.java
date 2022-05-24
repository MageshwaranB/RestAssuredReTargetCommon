package datashare;

import java.util.LinkedHashMap;
import java.util.Map;

public class ThreadLocalDatastoreAsMap {
	
	private ThreadLocalDatastoreAsMap() {
	};
	
	

/*
 * In the below line, we're creating a threadlocal and in that we've have initialized
 * with an empty linkedhashmap
 */
	private static ThreadLocal<LinkedHashMap<String, Object>> dataMap=
						ThreadLocal.withInitial(()->new LinkedHashMap<String, Object>());
	
	public static void setValue(String key, Object value) {
		/*
		 * We can't directly use the methods of Map since we created only
		 * ThreadLocal which in turn initialize the Map, so first retrieve the map using get()
		 * and then we can make use of methods of Map 
		 */
		dataMap.get().put(key, value);
	}
	
	public static Object getValue(String key) {
		return dataMap.get().get(key);
	}
}
