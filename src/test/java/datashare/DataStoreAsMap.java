package datashare;

import java.util.LinkedHashMap;

public class DataStoreAsMap {
	/*
	 * Creating a private constructor which holds all the global variables in the form
	 * of map
	 * By creating a private constructor, we will not be able to create object for it
	 */
	private DataStoreAsMap() {
		
	};
	
	private static LinkedHashMap<String, Object> dataMap=new LinkedHashMap<>();
	
	public static void setValue(String key, Object value) {
		dataMap.put(key, value);
	}
	
	public static Object getValue(String key) {
		return dataMap.get(key);
	}
	
}
