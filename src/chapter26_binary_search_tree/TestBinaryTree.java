package chapter26_binary_search_tree;

import java.util.ArrayList;

public class TestBinaryTree {
	public static void main(String[] args) {
		// Create a BinaryTree
		
		BinaryTree<String> tree = new BinaryTree<>(); 
		tree.insert("George");
		tree.insert("Michael");
		tree.insert("Tom");
		tree.insert("Adam");
		tree.insert("Jones");
		tree.insert("Peter");
		tree.insert("Daniel");
		
		// Traverse tree
		System.out.print("Inorder (sorted): ");
		tree.inorder();
		System.out.print("\nPostorder: ");
		tree.postorder();
		System.out.print("\nPreorder: ");
		tree.preorder();
		System.out.print("\nThe number of nodes is " + tree.getSize());
		
		// Search for an element
		System.out.print("\nIs Peter in the tree? " + 
		tree.search("Peter"));
		
		// Get a path from the root to Peter
		System.out.print("\n A path from the root to Peter is: ");
		ArrayList<BinaryTree.TreeNode<String>> path = tree.patch("Peter");
		
/*		for (BinaryTree.TreeNode<String> treeNode: path)  
			System.out.print(treeNode.element + " ");*/
		for (int i = 0; i < path.size() && path != null; i++) 
			System.out.print(path.get(i).element + " ");
		
		Integer[] numbers = {2, 4, 3, 1, 8, 5, 6, 7};
		BinaryTree<Integer> intTree = new BinaryTree<>(numbers);
		System.out.print("\nInorder (sorted): ");
		intTree.inorder();
	}

}
