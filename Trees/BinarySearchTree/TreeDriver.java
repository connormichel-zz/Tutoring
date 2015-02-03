package BinarySearchTree;

import java.util.Random;

public class TreeDriver {

	public static void main(String[] args){
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();

		Random rand = new Random();
		for(int i = 0; i<10; i++){
			int temp = rand.nextInt(100);
			tree.insert(temp);
		}
		System.out.println("Binary tree in order traversal: ");
		tree.inorder();
		System.out.println("\nBinary tree post order traversal: ");
		tree.postorder();
		System.out.println("\nBinary tree pre order traversal: ");
		tree.preorder();
	}

}
