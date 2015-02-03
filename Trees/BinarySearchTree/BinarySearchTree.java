package BinarySearchTree;

public class BinarySearchTree<T extends Comparable<T> > 
extends BinaryTree<T> {

	public BinarySearchTree(T item) {
		super(item);
	} // constructor

	public BinarySearchTree() {
		super();
	} // no-arg constructor

	public void insert(final T item) {
		if (root == null)
			root = new Vertex(item);
		else
			insert(item, root);
	} // insert()

	protected void insert(final T item, final Vertex current) {
		if (current.value.compareTo(item) > 0) // new node smaller, go left
			if (current.left == null)
				current.left = new Vertex(item);
			else
				insert(item, current.left);
		else // new node bigger or same, go right
			if (current.right == null)
				current.right = new Vertex(item);
			else
				insert(item, current.right);
	} // insert()

	public void visit(T current) {
		System.out.println("Vertex: " + current);
	} // visit()

	// unit test driver
	public static void main(String[] args) {
		BinarySearchTree<String> bst = new BinarySearchTree<String>();
		for (String s: args)
			bst.insert(s);
		bst.inorder();
		System.out.println("Tree contains " + bst.size() + " vertices.");
	} // main()
} // class BinarySearchTree<T>