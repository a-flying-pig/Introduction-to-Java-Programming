package chapter26_binary_search_tree;

import javax.swing.JApplet;

public class DisplayBinaryTree extends JApplet {
	public DisplayBinaryTree() {
		add(new TreeControl(new BinaryTree<Integer>()));
	}

}
