package binarytree;

public class BSTNode {
	BSTNode left, right;
	int data;

	/* constructor */
	public BSTNode() {
		left = null;
		right = null;
		data = 0;
	}

	/* constructor with one argument */
	public BSTNode(int n) {
		left = null;
		right = null;
		data = n;
	}

	/* function to set left node */
	public void setLeft(BSTNode n) {
		left = n;
	}

	/* function to set right node */
	public void setRight(BSTNode n) {
		right = n;
	}

	/* get left */
	public BSTNode getLeft() {
		return left;
	}

	/* get right */
	public BSTNode getRigth() {
		return right;
	}

	/* get data */
	public int getData() {
		return data;
	}

}
