package binarytree;

public class BST extends BSTNode {
	private BSTNode root;

	/* constructor */
	public BST() {
		root = null;
	}

	/* function to get root value */
	public BSTNode getRoot() {
		return root;
	}

	/* function to check if tree is empty */
	public boolean isEmpty() {
		return root == null;
	}

	/* function to insert data */
	public void insert(int data) {
		root = insert(root, data);
	}

	/* function to insert data recursively */
	private BSTNode insert(BSTNode node, int data) {
		if (node == null)
			node = new BSTNode(data);
		else {
			if (data <= node.getData())
				node.left = insert(node.left, data);
			else
				node.right = insert(node.right, data);
		}
		return node;
	}

	/* function to delete data */
	public void delete(int k) {
		if (isEmpty()) {
			System.out.println("Tree is empty");
		} else if (search(k) == false) {
			System.out.println("Element not found!");
		} else {
			root = delete(root, k);
			System.out.println("Element deleted successfully");
		}
	}

	/* delete node */
	private BSTNode delete(BSTNode root, int k) {
		BSTNode p, p2, n;
		if (root.getData() == k) {
			BSTNode lt, rt;
			lt = root.getLeft();
			rt = root.getRigth();
			if (lt == null && rt == null) {
				return null;
			} else if (lt == null) {
				p = rt;
				return p;
			} else if (rt == null) {
				p = lt;
				return p;
			} else {
				p2 = rt;
				p = rt;
				while (p.getLeft() != null)
					p = p.getLeft();
				p.setLeft(lt);
				return p2;
			}
		}

		if (k < root.getData()) {
			n = delete(root.getLeft(), k);
			root.setLeft(n);
		} else {
			n = delete(root.getRigth(), k);
			root.setRight(n);
		}
		return root;
	}

	/* function to search for an element */
	public boolean search(int val) {
		return search(root, val);
	}

	/* function to search for a element recursively */
	private boolean search(BSTNode r, int val) {
		boolean found = false;
		while ((r != null) && !found) {
			int rval = r.getData();
			if (val < rval)
				r = r.getLeft();
			else if (val > rval)
				r = r.getRigth();
			else {
				found = true;
				break;
			}
		}
		return found;
	}

	/* function for inorder traversal */
	public void inorder() {
		inorder(root);
	}

	private void inorder(BSTNode r) {
		if (r != null) {
			inorder(r.getLeft());
			System.out.println(r.getData() + " ");
			inorder(r.getRigth());
		}
	}

	/* function for preorder traversal */
	public void preorder() {
		preorder(root);
	}

	private void preorder(BSTNode r) {
		if (r != null) {
			System.out.println(r.getData() + " ");
			preorder(r.getLeft());
			preorder(r.getRigth());
		}
	}

	/* function for post order traversal */

	public void postorder() {
		postorder(root);
	}

	private void postorder(BSTNode r) {
		if (r != null) {
			postorder(r.getLeft());
			postorder(r.getRigth());
			System.out.println(r.getData() + " ");
		}
	}

	public void searchValue(int ajval) {
		if (searchValue(root, ajval)) {
			System.out.println("item found");
		} else {
			System.out.println("item not found");
		}

	}

	private boolean searchValue(BSTNode node, int ajval) {
		if (node == null)
			return false;
		while (node != null) {
			if (node.getData() == ajval)
				return true;
			if (ajval > node.getData())
				node = node.getRigth();
			else
				node = node.getLeft();
		}

		return false;
	}

	/* function to count number of nodes */
	public int countNodes() {
		return countNodes(root);
	}

	/* function to count number of nodes */
	private int countNodes(BSTNode r) {
		if (r == null)
			return 0;
		else {
			int l = 1;
			l += countNodes(r.getLeft());
			l += countNodes(r.getRigth());
			return l;
		}
	}

	public int getDepth() {
		int depth = 0;
		return getDepth(root);
	}

	public int getDepth(BSTNode r) {
		if (r == null)
			return 0;
		else {
			int leftD;
			int rightD;
			leftD = getDepth(r.getLeft());
			rightD = getDepth(r.getRigth());

			if (leftD > rightD)
				return (leftD + 1);
			else
				return (rightD + 1);
		}
	}

	/* print tree */
	public void printTree() {
		printTree(root);
	}

	private void printTree(BSTNode r) {
		if (r != null) {
			System.out.println(r.getData());
			printTree(r.getLeft());
			printTree(r.getRigth());
		}
	}
}
