package binarytree;

import java.util.HashMap;

public class TestCollison {
	public static void main(String[] args) 
  	{
  		
  		HashMap map = new HashMap();
  		Person p1 = new Person(1,"ABC");
   		Person p2 = new Person(2,"DEF");
  		Person p3 = new Person(1,"XYZ");
  		Person p4 = new Person(1,"PQR");
  		Person p5 = new Person(1,"PQR");
  		System.out.println("Adding Entries ....");	
  		map.put(p1,"ONE");
  		map.put(p2,"TWO");
      	map.put(p3,"THREE");
  		map.put(p4,"FOUR");
  		map.put(p5,"FIVE");
  		//map.put(1,"Ajay");
  		//map.put(1,"Ajaay");
  
  		System.out.println("\nComplete Map entries \n" + map);
  
  		System.out.println("\nAccessing non-collided key");	
  		System.out.println("Value = "+map.get(p2));
  		System.out.println("\nAccessing collided key");	
  		System.out.println("Value = " + map.get(p1));
  		
  	/*	System.out.println("Mapping other example");
  		HashMap map1 = new HashMap();
  		map1.put(1,"ONE");
  		map1.put(2,"TWO");
  		map1.put(3,"THREE");
  		map1.put(1,"FOUR");
  		map1.put(1,"FIVE");
  		map1.put(1,"Ajay");
  		System.out.println("\nComplete Map entries \n" + map1);*/
  	}
}
