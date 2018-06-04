package chapter22;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class SetListPerformanceTest {
	public static void main(String[] args) {
		// Create a hash set, and test its performance
		Collection<Integer> set1 = new HashSet<>();
		System.out.println("Time for hash set is " + 
		    getTestTime(set1, 500000) + " milliseconds");
		
		// Create a linked hash set, and test its performance
		Collection<Integer> set2 = new LinkedHashSet<>();
		System.out.println("Time for linked hash set is " + 
			getTestTime(set2, 500000) + " milliseconds");
		
		// Create a tree set, and test its performance
		Collection<Integer> set3 = new TreeSet<>();
		System.out.println("Time for tree set is " + 
			getTestTime(set3, 500000) + " milliseconds");
		
		// Create an array list, and test its performance
		Collection<Integer> list1 = new ArrayList<>();
		System.out.println("Time for array list is " +
			getTestTime(list1, 60000) + " milliseconds");
		
		// Create a linked list, and test its performance
		Collection<Integer> list2 = new LinkedList<>();
		System.out.println("Time for linked list is " + 
			getTestTime(list2, 60000) + " milliseconds");
	}

	public static long getTestTime(Collection<Integer> c, int size) {
		// TODO Auto-generated method stub
		long startTime = System.currentTimeMillis();
		// Add number 0, 1, 2. .... size - 1 to the array list
		java.util.List<Integer> list = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			list.add(i);
		}
		
		Collections.shuffle(list); // Shuffle the array list
		for(int elemant: list)
			c.add(elemant);
		Collections.shuffle(list); // Shuffle the array list
		
		// Remove the element from the container
		for(int element: list)
			c.remove(element);
		
		long endTime = System.currentTimeMillis();
		
		return endTime - startTime; // Return the execution time 
	}
	
}
