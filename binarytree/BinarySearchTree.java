package binarytree;

import java.util.Scanner;

public class BinarySearchTree {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		BST bst = new BST();
		System.out.println("Binary Search Tree Test\n");
		int[] btreeValues = { 7, 1, 9, 8, 10, 0, 3, 2, 5, 4, 6 };
		for (int i = 0; i < btreeValues.length; i++) {
			bst.insert(btreeValues[i]);
		}
		System.out.println("\nPost order : ");
		bst.postorder();
		System.out.println("\nPre order : ");
		bst.preorder();
		System.out.println("\nIn order : ");
		bst.inorder();

		bst.searchValue(15);

		/*
		 * char ch; do{ System.out.println("\nBinary Search Tree Operations\n");
		 * System.out.println("1. insert"); System.out.println("2. delete");
		 * System.out.println("3. Search");
		 * System.out.println("4. count Nodes");
		 * System.out.println("5. Check Empty");
		 * 
		 * 
		 * int choice = scan.nextInt(); switch(choice) { case 1:
		 * System.out.println("Enter integer element to insert");
		 * bst.insert(scan.nextInt()); break; case 2 :
		 * System.out.println("Enter integer element to delete"); bst.delete(
		 * scan.nextInt() ); break; case 3 :
		 * System.out.println("Enter integer element to search");
		 * System.out.println("Search result : "+ bst.search( scan.nextInt() ));
		 * break; case 4 : System.out.println("Nodes = "+ bst.countNodes());
		 * break; case 5 : System.out.println("Empty status = "+ bst.isEmpty());
		 * break; default : System.out.println("Wrong Entry \n "); break; } /*
		 * Display tree
		 */
		/*
		 * System.out.print("\nPost order : "); bst.postorder();
		 * System.out.print("\nPre order : "); bst.preorder();
		 * System.out.print("\nIn order : "); bst.inorder();
		 * 
		 * System.out.println("\nDo you want to continue (Type y or n) \n"); ch
		 * = scan.next().charAt(0); } while(ch == 'Y'|| ch == 'y');
		 */
	}

}
