package chapter26_binary_search_tree;

import java.util.Iterator;

public interface Tree<E extends Comparable<E>> {

	/** Return true if the element is in the tree */
	public boolean search(E e);
	
	public boolean insert(E e);
	
	public boolean delete(E e);
	
	public void inorder();
	
	public void postorder();
	
	public void preorder();
	
	public int getSize();
	
	public boolean isEmpty();
	
	public Iterator<E> iterator();
}
