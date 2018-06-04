package chapter22;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class CountOccurrenceOfWords {
	public static void main(String[] args) {
		// Set text in a string
		String text = "Good morning, Have a good class. " + 
		"Have a good visit. Have fun!";
		
		// Create a HashMap to hold words as key and count as value
		Map<String, Integer> hashMap = new HashMap<>();
		String[] words = text.split("[ \n\t\t.,;:!?(){]");
		for(String string: words) {
			String key = string.toLowerCase();
			
			if (key.length() > 0) {
				if (hashMap.get(key) == null) {
					hashMap.put(key, 1);
				} else {
					int value = hashMap.get(key);
					value++;
					hashMap.put(key, value);
				}
			}
		}
		
		// Create a TreeMap to sort the words
		Map<String, Integer> treeMap = 
				new TreeMap<>(hashMap);
		
		// Get all entries into a set
		Set<Map.Entry<String, Integer>> entrySet = treeMap.entrySet();
		
		// Get key and value from each entry
		for (Map.Entry<String, Integer> entry: entrySet) {
			System.out.println(entry.getValue() + "\t" + entry.getKey());
		}
		
	}
}
