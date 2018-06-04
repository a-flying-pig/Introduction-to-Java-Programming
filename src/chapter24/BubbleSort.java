package chapter24;

public class BubbleSort {
    /** Bubble sort method */
	public static void bubbleSort (int[] list) {
		boolean needNextPass = true;
		
		for (int k = 1; k < list.length && needNextPass ; k++) {
			
			// Array may be sorted and next pass not needed
			needNextPass = false;
			for (int i = 0; i < list.length - k; i++) {
				System.out.print("\n");
				System.out.print("list" + "[" + i + "]" + "=" + list[i] + " ");
				System.out.print("list" + "[" + (i + 1) + "]" + "=" + list[i + 1] + "\n");
				if (list[i] > list[i + 1]) {
					System.out.print("swap two number ");
					int temp = list[i + 1];
					list[i + 1] = list[i];
					list[i] = temp;
					System.out.print("list" + "[" + i + "]" + "=" + list[i] + " ");
					System.out.print("list" + "[" + (i + 1) + "]" + "=" + list[i + 1] + "\n");
					needNextPass = true; // Next pass still needed
				}
			}
		}
	}
	
	/** A test method */
	public static void main(String[] args) {
		int [] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] +  " ");
		}
		System.out.print("\n");
		bubbleSort(list);
		for (int i: list) {
			System.out.print(i + " ");
		}
		System.out.print("\n");
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] +  " ");
		}
	}
}
