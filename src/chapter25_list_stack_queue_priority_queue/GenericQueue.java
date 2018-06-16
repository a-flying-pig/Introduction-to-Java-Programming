package chapter25_list_stack_queue_priority_queue;

import java.util.LinkedList;

public class GenericQueue<E> {
	private LinkedList<E> list = new LinkedList<>();
	
	public void enqueue(E e) {
		list.addLast(e);
	}
	
	public E dequeue() {
		return list.removeFirst();
	}
	
	public int getSize() {
		return list.size();
	}
	
	public String toString() {
		return "Queue: " + list.toString();
	}
}
