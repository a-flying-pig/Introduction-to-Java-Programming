package chapter25_list_stack_queue_priority_queue;

public class MyArrayList<E> extends MyAbstractList<E> {
	public static final int INITIAL_CAPACITY = 16;
	@SuppressWarnings("unchecked")
	private E[] data = (E[]) new Object[INITIAL_CAPACITY];
	
	/** Create a default list */
	public MyArrayList() {
	}
	
	/** Create a list from an array of objects */
	public MyArrayList(E[] objects) {
		for (E e: objects)
			add(e); // Warning: don't use super(objects)!
	}
	
	/** Add a new element at the specified index in this list */
	@Override
	public void add(int index, E e) {
		// TODO Auto-generated method stub
		ensureCapacity();
		// Move the elements to the right after the specified index
		for (int i = size -1; i >= index; i--)
			data[i + 1] = data[i];
		
		// Insert new element to data[index]
		data[index] = e;
		
		// Increase new element to data[index]	
		size++;
	}

	/** Create a new larger array, double the current size + 1 */
	private void ensureCapacity() {
		if (size >= data.length) {
			E[] newData = (E[])new Object[size * 2 + 1];
			System.arraycopy(data, 0, newData, 0, size);
			data = newData;
		}
	}

	/** Clear the list */
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		data = (E[]) new Object[INITIAL_CAPACITY];
		size = 0;
	}

	/** Return true if this list contains the element */
	@Override
	public boolean contains(E e) {
		// TODO Auto-generated method stub
		for (E e2: data)
			if (e2.equals(e)) return true;
		return false;
	}

	/** Return the element from this list at the specified index */
	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		if (index >= size) throw new IndexOutOfBoundsException();
		return (E)data[index];
	}

	/** Return the index of the first matching element in this list.
	 * Return -1 if no match. 
	 */
	@Override
	public int indexOf(E e) {
		// TODO Auto-generated method stub
		for (int i = 0; i < size; i++) 
			if (e.equals(data[i])) return i;
		return -1;
	}

	/** Return the index of the last matching element in this list.
	 * Return -1 if no match.
	 */
	@Override
	public int lastIndextOf(E e) {
		for (int i = size -1; i >= 0; i--) 
			if (e.equals(data[i])) return i;
		return -1;
	}

	/** Remove the element at the specified position in this list
	 * Shift any subsequent elements to the left.
	 * Return the elements that was removed from the list.
	 */
	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		if (index >= size) throw new IndexOutOfBoundsException();
		E e = data[index];
		
		// Shift data to the left
		for (int j = index; j < size - 1; j++)
			data[j] = data[j + 1];
		data[size - 1] = null; // This element is now null
		
		// Decrement size
		size--;
		return e;
	}

	/** Replace the element at the sepcified position in this list
	 * witch the specified element.
	 */
	@Override
	public Object set(int index, E e) {
		// TODO Auto-generated method stub
		if (index >= size) throw new IndexOutOfBoundsException();
		E oldElement = data[index];
		data[index] = e;
		return oldElement;
	}
	
	/** Override toString() to return elements in the list */
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("[");
		
		for (int i = 0; i < size; i++) {
			result.append(data[i]);
			if (i < size -1) result.append(", ");
		}
		return result.toString() + "]";
	}
	
	/** Trims the capacity to current size */
	public void trimToSize() {
		if (size != data.length) {
			// If size == capacity, no need to trim
			E[] newData = (E[])new Object[size];
			System.arraycopy(data, 0, newData, 0, size);
			data = newData;
		}
	}

}
