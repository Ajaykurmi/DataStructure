package graph;


public class Graph {
	int v;
	AdjList array[];
	
	public Graph(int vValue) {
		v = vValue;
		array = new AdjList[vValue];
		for(int i=0;i<vValue;i++){
			array[i]  = new AdjList(i);		 
		}
	}

	

	public void setData(int vValue) {
		v = vValue;
	}

	public int getData() {
		return v;
	}
}
