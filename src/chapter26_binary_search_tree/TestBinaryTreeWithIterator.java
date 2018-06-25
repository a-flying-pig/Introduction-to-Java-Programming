package chapter26_binary_search_tree;

import java.util.Iterator;

public class TestBinaryTreeWithIterator {
	public static void main(String[] args) {
		BinaryTree<String> tree = new BinaryTree<>();
		tree.insert("George");
		tree.insert("Michael");
		tree.insert("Tom");
		tree.insert("Adam");
		tree.insert("Jones");
		tree.insert("Peter");
		tree.insert("Daniel");
		Iterator<String> iterator = tree.inorderIterator();
		while (iterator.hasNext()) {
		 System.out.println((String)(iterator.next()).toUpperCase());
		}
	}
}
