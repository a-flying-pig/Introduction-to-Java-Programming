package chapter26_binary_search_tree;

import java.util.Iterator;


public abstract class AbstractTree <E extends Comparable<E>> 
	implements Tree<E>{
	/** Inorder traversal from the root */
	public void inorder() {
		
	}
	
	public void postorder() {
		
	}
	
	public void preorder() {
		
	}
	
	public boolean isEmpty() {
		return getSize() == 0;
	}
	
	/** Return an Iterator to traverse elements in the tree */
	public Iterator<E> iterator() {
		return null;
	}
}
