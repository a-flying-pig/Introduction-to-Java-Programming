package capture22;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class TestMap {
	public static void main(String[] args) {
		// Create a HashMap
		Map<String, Integer> hashMap = new HashMap<>();
		hashMap.put("Smith", 30);
		hashMap.put("Anderson", 31);
		hashMap.put("Lewis", 29);
		hashMap.put("Cook", 29);
		
		System.out.println("Display entries in HashMap");
		System.out.println(hashMap + "\n");
		
		// Create a TreeMap from the previous HashMap
		Map<String, Integer> treeMap = 
				new TreeMap<>(hashMap);
		System.out.println("Display entries in ascending of key");
		System.out.println(treeMap);
		
		// Create a LinkedHashMap
		Map<String, Integer> linkedHashMap = 
				new LinkedHashMap<>(16, 0.75f, true);
		linkedHashMap.put("Smith", 30);
		linkedHashMap.put("Anderson", 31);
		linkedHashMap.put("Lewis", 29);
		linkedHashMap.put("Cook", 29);
		
		// Display the age for Lewis
		System.out.println("The age for " + "Lewis is " + 
				linkedHashMap.get("Lewis").intValue());
		
		System.out.println("\nDisplay entries in LinkedHashMap");
		System.out.println(linkedHashMap);
	}
}
