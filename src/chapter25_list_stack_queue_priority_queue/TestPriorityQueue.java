package chapter25_list_stack_queue_priority_queue;

public class TestPriorityQueue {
	public static void main(String[] args) {
		Patient patient1 = new Patient("John", 2);
		Patient patient2 = new Patient("Jim", 1);
		Patient patient3 = new Patient("Tim", 5);
		Patient patient4 = new Patient("Cindy", 7);
		
		MyPriorityQueue<Patient> priorityQueue = new MyPriorityQueue<>();
		priorityQueue.enqueue(patient1);
		priorityQueue.enqueue(patient2);
		priorityQueue.enqueue(patient3);
		priorityQueue.enqueue(patient4);
		
		while (priorityQueue.getSize() > 0) {
			System.out.println(priorityQueue.dequeue() + " ");
		}
	}
	
	static class Patient implements Comparable {

		private String name;
		private int priority;
		
		public Patient(String name, int priority) {
			// TODO Auto-generated constructor stub
			this.name = name;
			this.priority = priority;
		}
		
		@Override
		public int compareTo(Object o) {
			// TODO Auto-generated method stub
			return this.priority - ((Patient)o).priority;
		}
		
		@Override
		public String toString () {
			return name + "(priority:" + priority + ")";
		}
	}
}
