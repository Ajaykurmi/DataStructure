package binarytree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class SetMapDemo {
	public static void main(String[] args)
	   {
	      String[] data = new String("nothing is as easy as it looks").split(" ");

	      HashSet hs = new HashSet();
	      LinkedHashSet lhs = new LinkedHashSet();
	      TreeSet ts = new TreeSet();

	      HashMap m = new HashMap();
	      TreeMap tm = new TreeMap();
	      LinkedHashMap lhm = new LinkedHashMap();

	      for (String x : data)
	      {
	         Integer freq = (Integer) m.get(x);
	         m.put(x, freq == null ? 1 : freq + 1);
	         tm.put(x, freq == null ? 1 : freq + 1);
	         lhm.put(x, freq == null ? 1 : freq + 1);

	         hs.add(x);
	         ts.add(x);
	         lhs.add(x);
	      }

	      /* this prints the HashSet */
	      System.out.println("Hash  set: " + hs);
	      System.out.println();

	      /* this prints the hashtable in sorted order*/
	      System.out.println("Tree set: " + ts);
	      System.out.println();

	      /* this prints the hashtable in the order items were inserted */
	      System.out.println("Linked set: " + lhs);
	      System.out.println();

	      System.out.println(m.size() + " distinct words detected:");
	      System.out.println();

	      System.out.println("Hash map: " + m);
	      System.out.println();

	      System.out.println("Tree map: " + tm);
	      System.out.println();

	      System.out.println("Linked map: " + lhm);
	      System.out.println();
	   }
}
