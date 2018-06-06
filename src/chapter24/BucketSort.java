package chapter24;

import java.util.ArrayList;

public class BucketSort {

	public static void  main(String[] args) {
		int[] numbers = {1, 3, 5, 2, 7, 0};
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");		
		}
		System.out.println();
		bucketSort(numbers);
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");		
		}
	}
	
	public static void bucketSort(int[] list) {
		ArrayList<Integer>[] buckets = (ArrayList<Integer>[])new ArrayList[8];
		
		// Distribute the elements from list to buckets
		for (int i = 0; i < list.length; i++) {
			int key = list[i];
			if (buckets[key] == null) 
				buckets[key] = new ArrayList<>();
			buckets[key].add(list[i]);
		}
		
		// Now move the elements from the buckets back to list
		int k = 0; // k is an index for list
		for (int i = 0; i < buckets.length; i++) {
			if (buckets[i] != null) {
				for (int j = 0; j < buckets[i].size(); j++) 
					list[k++] = buckets[i].get(j);
			}
		}
	}
}
