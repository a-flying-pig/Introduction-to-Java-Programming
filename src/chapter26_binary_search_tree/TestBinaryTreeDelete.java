package chapter26_binary_search_tree;


public class TestBinaryTreeDelete {
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
		printTree(tree);
		
		System.out.println("After delete George: ");
		tree.delete("George");
		printTree(tree);
		
		System.out.println("After delete Adam: ");
		tree.delete("Adam");
		printTree(tree);
		
		System.out.println("After delete Michael: ");
		tree.delete("Michael");
		printTree(tree);
	}
	
	public static void printTree(BinaryTree<String> tree) {
		// Traverse tree
		System.out.print("Inorder (sorted): ");
		tree.inorder();
		System.out.print("\nPostorder: ");
		tree.postorder();
		System.out.print("\nPreorder: ");
		tree.preorder();
		System.out.print("\nThe number of nodes is " + tree.getSize());
		System.out.println();
	}
}
