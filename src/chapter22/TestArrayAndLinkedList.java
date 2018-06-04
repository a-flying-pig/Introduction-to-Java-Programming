package chapter22;

import java.awt.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class TestArrayAndLinkedList {
	public static void main(String[] args) {
		java.util.List<Integer> arryList = new ArrayList<>();
		arryList.add(1); // 1 is autoboxed to new Integer(1)
		arryList.add(2);
		arryList.add(3);
		arryList.add(1);
		arryList.add(4);
		arryList.add(0, 10);
		arryList.add(3, 30);
		
		System.out.println("A list of intergers in the array list: ");
		System.out.println(arryList);
		
		LinkedList<Object> linkedList = new LinkedList<>(arryList);
		linkedList.add(1, "red");
		linkedList.removeLast();
		linkedList.addFirst("green");
		
		System.out.println("Display the linked list forward:");
		ListIterator<Object> listIterator = linkedList.listIterator(0);
		while (listIterator.hasNext()) {
			System.out.print(listIterator.next() + " ");
		}
		System.out.println();
		
		System.out.println("Display the linked list backward:");
		listIterator = linkedList.listIterator(linkedList.size());
		while (listIterator.hasPrevious()) {
			System.out.print(listIterator.previous() + " ");
		}
	}
}
