package graph;
import graphs.State;
public class AdjListNode {
	int dest;
	AdjListNode next;
	State state;
	
	public AdjListNode(){
		dest = 0;
		next =null;
		state=State.Unvisited;
	}
	
	public AdjListNode(int destData){
		dest = destData;
		next =null;
		state=State.Unvisited;
	}
	
	public boolean checkEmpty(){
		return next==null;
	}
	
	public int getDest(){
		return dest;
	}
	
	public void setDest(int destval){
		dest = destval;
	}
	
	public AdjListNode getNext()  {
		return next;
	}
	
	public void setNext(AdjListNode nextnode)  {
		next=nextnode;
	}
	
	public int getData(){
		return dest;
	}
}
