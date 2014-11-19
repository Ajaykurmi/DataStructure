package hashmapprogram;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

	public static void main(String[] args) {
		
		HashMapTest hasm = new HashMapTest();
		hasm.checkArraySubset();
	}
	
	public void checkArraySubset(){
		int[] arr1 = {11,1,13,21,3,7};
		int[] arr2 = {11,3,7,1};
		Map map = new HashMap();
		/* below operation takes o(n) time*/
		for(int i=0;i<arr1.length;i++){  
			map.put(arr1[i], arr1[i]);  
		}
		
		boolean isSubset = true;
		for(int i=0;i<arr2.length;i++){
			int key = 0;
			if(map.containsKey(arr2[i])){
				key = (int) map.get(arr2[i]);		
			}
			if(arr2[i]!=key){
				isSubset =false;
				break;
			}
		}
		
		if(isSubset) {
			System.out.print("Array 2 is subset of array 1");
		} else {
			System.out.print("Array 2 is not a subset of array 1");
		}
		
	}

}
