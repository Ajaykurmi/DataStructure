package binarytree;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

import com.sun.corba.se.impl.encoding.OSFCodeSetRegistry.Entry;

public class TreeTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BST bst = new BST();
		System.out.println("Binary Search Tree Test\n");
		int[] btreeValues = { 3, 2, 1, 4, 9, 10, 8 };
		for (int i = 0; i < btreeValues.length; i++) {
			bst.insert(btreeValues[i]);
		}
		getVerticleHeightUsingHash(bst);
		/* start hashing implementations */
	/*
		String[] colors = { "white", "pink", "red", "green", "red", "orange",
				"Aa", "BB" };

		HashSet hs = new HashSet();

		for (int i = 0; i < colors.length; i++)
			hs.add(colors[i]);

		System.out.println(hs);

		System.out.println("Does it contain green?  " + hs.contains("green"));

		Iterator itr = hs.iterator();

		while (itr.hasNext())
			System.out.print(itr.next() + " ");
		System.out.println();
*/
		
		/*String[] data = new String("Nothing is as easy as it looks").split(" ");

		HashMap hm = new HashMap();

		for (String key : data)
		{
			Integer freq = (Integer) hm.get(key);
			if(freq == null) freq = 1; else freq ++;
			hm.put(key, freq);
		}
		System.out.println(hm); */
		
		/*URL url = new URL("http://andrew.cmu.edu/course/15-121/dictionary.txt");
		Scanner sc = new Scanner(url.openStream());

		HashSet<String> dict = new HashSet<String>();

		while (sc.hasNext())
			dict.add(sc.next());
		sc.close();

		sc = new Scanner(new File("Spellchecker.java"));
		while (sc.hasNextLine()) {
			String[] tokens = sc.nextLine().split("\\W");
			for (String token : tokens)
				if (token.length() > 1 && !dict.contains(token.toLowerCase()))
					System.out.println(token);
		}*/
		// for(String str : hs)
		// System.out.print(str +" ");
		/*
		 * System.out.println(); /* end hashing implementations
		 */

		// getVerticleHeight(bst);
		// treeDepth(bst);
		// compareTree(bst);
		// System.out.println("Print Tree Values");
		// bst.inorder();
		// createTreeMirror(bst.getRoot());
		// System.out.println("Print Tree Values after mirror");
		// bst.inorder();
		// System.out.println("Paths of the tree");
		// printAllPathofTree(bst);
		// System.out.println("\nPost order : ");
		// bst.postorder();
		// System.out.println("\nPre order : ");
		// bst.preorder();
		// System.out.println("\nIn order : ");
		// bst.inorder();

	}

	/* get the verticle path of binary tree */
	
	public static void getVerticleHeightUsingHash(BST bst) {
		Map m1 = new HashMap();
		//HashMap map = new HashMap();
		createHasMap(bst.getRoot(),m1,0);
		System.out.println(" Map Elements");
	    System.out.println(m1);
	   
	    
	    Iterator mapIter = m1.keySet().iterator();
	   
	    System.out.println("mapIter");
	   // System.out.println(mapIter);
	   
	    while (mapIter.hasNext()) {
	    	int key = (int) mapIter.next();
	    	LinkedList list = (LinkedList) m1.get(key);
	    	
	    	printList(list);
	    	 
        } 
	}
	
	private static void printList(LinkedList list2) {
		Iterator x = list2.listIterator();
		while (x.hasNext()) {
			BSTNode mm = (BSTNode) x.next();
	        System.out.print(mm.getData()+"\t");
		}
		//for (BSTNode node : list2) {
			//System.out.print(node.getData());
			//System.out.print(" ");
		//}
		System.out.println("\n");
	}

	/*private void printList(LinkedList<TreeNode> list) {
		for (TreeNode node : list) {
			System.out.print(node.getData());
			System.out.print(" ");
		}
		System.out.println("\n");
	}*/
	
	public static void createHasMap(BSTNode node, Map m1,int h){
		if(node!=null){
			
			 //Vector l = m1[h];
			  //  l.push_back(root->value);
			   // list[index] = l;
			LinkedList result = new LinkedList();
			if(m1.containsKey(h))
				result = (LinkedList) m1.get(h);
			result.add(node);
			m1.put(h, result);
			
			
			//m1.put(h, node.getData());
			System.out.println("val "+h+" "+node.getData());
			createHasMap(node.getLeft(), m1, h-1);
			createHasMap(node.getRigth(), m1, h+1);
		}
	}
	

	
	public static void getVerticleHeight(BST bst) {
		int[] minMax = { 0, 0 }; // index 0 for min and index 1 for max value
		minMax = getMinMaxHorizontalDistance(bst.getRoot(), minMax, 0);
		System.out.println("Min " + minMax[0]);
		System.out.println("Max " + minMax[1]);
		

		for (int i = minMax[0]; i <= minMax[1]; i++) {
			printVerticlePath(bst.getRoot(), i, 0);
			System.out.println("");
		}
	}

	public static void printVerticlePath(BSTNode node, int lvl, int hd) {
		if (node != null) {
			if (lvl == hd) {
				System.out.print(node.getData() + " ");
			}
			printVerticlePath(node.getLeft(), lvl, (hd - 1));
			printVerticlePath(node.getRigth(), lvl, (hd + 1));
		}

	}

	public static int[] getMinMaxHorizontalDistance(BSTNode node, int[] minMax,
			int hd) {
		if (node == null)
			return null;
		// if(node.getLeft()==null && node.getRigth()==null)
		// return minMax;
		// if()
		if (hd > minMax[1])
			minMax[1] = hd;

		if (hd < minMax[0])
			minMax[0] = hd;

		getMinMaxHorizontalDistance(node.getLeft(), minMax, (hd - 1));
		getMinMaxHorizontalDistance(node.getRigth(), minMax, (hd + 1));
		return minMax;
	}

	/* determine if a binary tree is height-balanced? */
	// public static void

	public static void treeDepth(BST bst) {
		System.out.println("Height of tree " + bst.getDepth());
	}

	public static void searchValue(BST bst1) {
		bst1.searchValue(15);
		// creating another tree for comparing

	}

	/* function transfer a tree into its mirror tree */
	public static void createTreeMirror(BSTNode bst) {
		if (bst != null) {
			createTreeMirror(bst.getLeft());
			createTreeMirror(bst.getRigth());
			BSTNode temp;
			temp = bst.getLeft();
			bst.setLeft(bst.getRigth());
			bst.setRight(temp);
		}
	}

	/* function to print path of tree from root node */
	public static void printAllPathofTree(BST bst) {
		int[] paths = new int[1000];
		getPathOfTree(bst.getRoot(), paths, 0);
	}

	public static void getPathOfTree(BSTNode bst, int[] paths, int len) {
		if (bst != null) {
			paths[len] = bst.getData();
			len++;

			if (bst.getLeft() == null && bst.getRigth() == null) {
				printPathArray(paths, len);
			} else {
				getPathOfTree(bst.getLeft(), paths, len);

				getPathOfTree(bst.getRigth(), paths, len);
			}
		}
	}

	/* print path array */
	public static void printPathArray(int[] pathar, int len) {
		System.out.println("\nPath: ");
		for (int i = 0; i < len; i++) {
			System.out.print(pathar[i] + "\t");
		}
	}

	/* Tree Comparisons functions */
	public static void compareTree(BST bst1) {
		BST bst2 = new BST();
		int[] btreeValues = { 3, 2, 1, 4, 9 };
		for (int i = 0; i < btreeValues.length; i++) {
			bst2.insert(btreeValues[i]);
		}

		// check two tree identical or not
		if (checkTwoTreeIdentical(bst1.getRoot(), bst2.getRoot())) {
			System.out.println("Trees are identical");
		} else {
			System.out.println("Trees are not identical");
		}
	}

	/* function recursively check two tree identical or not */
	public static boolean checkTwoTreeIdentical(BSTNode bst1, BSTNode bst2) {
		if (bst1 == null && bst2 == null)
			return true;
		else if (bst1 == null || bst2 == null) {
			return false;
		}
		if ((bst1.getData() == bst2.getData())
				&& checkTwoTreeIdentical(bst1.getLeft(), bst2.getLeft())
				&& checkTwoTreeIdentical(bst1.getRigth(), bst2.getRigth())) {
			return true;
		}
		return false;
	}

}
