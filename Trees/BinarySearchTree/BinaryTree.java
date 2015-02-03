package BinarySearchTree;

public abstract class BinaryTree<T> {
	protected Vertex root;

	public BinaryTree() {
		root = null;
	} // no-arg constructor

	public BinaryTree(T item) {
		root = new Vertex(item, null, null);
	} // constructor

	public abstract void insert(T item);

	public void inorder() {
		root.inorder();
	} // inorder

	public void preorder() {
		root.preorder();
	} // preorder

	public void postorder() {
		root.postorder();
	} // postorder

	public abstract void visit(T current);

	public int size() {
		return root.size();
	} // size()

	protected class Vertex {
		// p.o.d. class
		T value;
		Vertex left;
		Vertex right;

		Vertex(T value,
				Vertex left,
				Vertex right) {
			this.value = value;
			this.left = left;
			this.right = right;
		} // constructor

		Vertex(T value) {
			this(value, null, null);
		} // constructor


		public void inorder() {
			if (left != null)
				left.inorder();
			visit(value);
			if (right != null)
				right.inorder();
		} // inorder()

		public void postorder() {
			if (left != null)
				left.postorder();
			if (right != null)
				right.postorder();
			visit(value);
		} // postorder()

		public void preorder() {
			visit(value);
			if (left != null)
				left.preorder();
			if (right != null)
				right.preorder();
		} // preorder()

		public int size() {
			int size = 1;
			if (left != null)
				size += left.size();
			if (right != null)
				size += right.size();
			return size;
		} // size()

	} // class Vertex

} // class BinaryTree