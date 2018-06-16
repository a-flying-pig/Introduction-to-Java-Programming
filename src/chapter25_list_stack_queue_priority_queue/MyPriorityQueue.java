package chapter25_list_stack_queue_priority_queue;

import chapter24.Heap;

public class MyPriorityQueue<E extends Comparable> {
	private Heap<E> heap = new Heap<>();
	
	public void enqueue(E e) {
		heap.add(e);
	}
	
	public E dequeue() {
		return heap.remove();
	}
	
	public int getSize() {
		return heap.getSize();
	}
}
