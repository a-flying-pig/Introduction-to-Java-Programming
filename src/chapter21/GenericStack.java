package chapter21;

import java.util.ArrayList;

public class GenericStack<E> {
  private ArrayList<E> list = new ArrayList<>();
  
  public int getSize() {
	return list.size();
  }
 
  public E peek() {
	return list.get(getSize() - 1);
  }
  
  public void push(E o) {
	list.add(o);
}
  public E pop() {
	E o = list.get(getSize() -1);
	list.remove(getSize() - 1);
	return o;
}
  public boolean isEmpty() {
	return list.isEmpty();
  }
  
  @Override
  public String toString() {
	  StringBuilder result = new  StringBuilder("[");
	  for (int i = 0; i < list.size(); i++) {
		result.append(list.get(i));
		if (i < list.size() - 1) {
			result.append(", ");
		}
	}
	  result.append("]");
	  return result.toString();
  }
}
