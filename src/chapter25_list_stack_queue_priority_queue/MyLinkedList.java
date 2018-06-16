package chapter25_list_stack_queue_priority_queue;



public class MyLinkedList<E> extends MyAbstractList<E> {
	
	private Node<E> head, tail;
	
	public MyLinkedList() {
		// TODO Auto-generated constructor stub
	}
	
	public MyLinkedList(E[] objects) {
		super(objects);
	}
	
	public E getFirst() {
		if (size == 0) {
			return null;
		} else {
			return head.element;
		}
	}
	
	public E getLast() {
		if (size == 0) {
			return null;
		} else {
			return tail.element;
		}
	}
	
	public void addFirst(E e) {
		Node<E> newNode = new Node<E>(e);
		newNode.next = head;
		head = newNode;
		//System.out.println("addFirst e= " + e + " Size =" + size);
		
		size++;
		if (tail == null) {
			tail = head;
		}
	}
	
	public void addLast(E e) {
		Node<E> newNode = new Node<E>(e);
		if (tail == null) {
			head = tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
		size++;
	}
	
	public E removeFirst() {
		if (size == 0) {
			return null;
		} else if (size == 1) {
			Node<E> temp = head;
			head = tail = null;
			size = 0;
			return temp.element;
		} else {
			Node<E> temp= head;
			head = head.next;
			size--;
			return temp.element;
		}
	}
	
	public E removeLast() {
		if (size == 0) {
			return null;
		} else if (size == 1) {
			Node<E> temp = head;
			head = tail = null;
			size = 0;
			return temp.element;
		} else {
			Node<E> current = head;
			for (int i = 1; i < size - 1; i++) {
				current = current.next;
			}
			Node<E> temp= tail;
			tail = current;
			tail.next = null;
			size--;
			return temp.element;
		}
	}

	@Override
	public void add(int index, E e) {
		//System.out.println("add() index:" + index + " E :" + e + " now size:" + size);
		// TODO Auto-generated method stub
		if (index < 0) System.out.println("ERROR: index can not below 0");// Error
		if (index == 0){
			//System.out.println("addFirst()" + " E :" + e);
			addFirst(e);
		}
		else if (index >= size - 1) addLast(e);
		else {
		Node<E> newNode = new Node<E>(e);
		Node<E> current = head;
		for (int i = 1; i < index; i++) {
			current = current.next;
		}
		Node<E> temp = current.next;
		current.next = newNode;
		newNode.next = temp;
		size++;
		}
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("[");
		Node<E> current = head;
		for (int i = 0; i < size ; i++) {
			//System.out.println("size: " + size);
			result.append(current.element);
			current = current.next;
			if (current != null) {
				result.append(", ");
			} else {
				result.append("]");
			}
		}
		return result.toString();
	}
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		head = tail = null;
		size = 0;
	}

	@Override
	public boolean contains(E e) {
		// TODO Auto-generated method stub
		Node<E> current = head;
		while (current != null) {
			if (current.element == e) return true;
		}
		return false;
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		if (index < 0 || index >= size) return null;
		else if (index == 0) return getFirst();
		else if (index == size -1) return getLast();
		else {
			Node<E> current = head;
			for (int i = 0; i < index; i++)
				current = current.next;
			return current.element;
		}
	}

	@Override
	public int indexOf(E e) {
		// TODO Auto-generated method stub
		int index = -1;
		if (head.element == e) index = 0;
		else {
			Node<E> current = head;
			for(int i = 1; i < size; i++) {
				current = current.next;
				index++;
				if (current.element == e) {
					return index;
				}
			}
		}
		return index;
	}

	@Override
	public int lastIndextOf(E e) {
		// TODO Auto-generated method stub
		int index = -1;
		if (head.element == e) index = 0;
		else {
			Node<E> current = head;
			for(int i = 1; i < size; i++) {
				current = current.next;
				if (current.element == e) {
					index = i;
				}
			}
		}
		return index;
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		if (index < 0 || index >= size) return null; // Out of range
		else if (index == 0) return removeFirst();
		else if (index == size -1) return removeLast();
		else {
			Node<E> current = head;
			for (int i = 1; i < index; i++)
				current = current.next;
			Node<E> temp = current.next;
			current.next = current.next.next;
			size--;
			return temp.element;
		}
	}

	@Override
	public Object set(int index, E e) {
		// TODO Auto-generated method stub
		if (index < 0 || index >= size) return null;
		else if (index == 0) {
			Node<E> temp = head;
			head.element = e;
			return temp.element;
		}
		else {
			Node<E> current = head;
			for (int i = 1; i < index; i++) 
				current = current.next;
			Node<E> temp = current.next;
			current.next.element = e;
			return temp.element;
		}
	}
	
	private static class Node<E> {
		E element;
		
		Node<E> next;
		
		public Node(E element) {
			this.element = element;
		}
	}

}
