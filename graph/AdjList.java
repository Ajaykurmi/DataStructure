package graph;
import graphs.State;
public class AdjList {
	AdjListNode head;
	int headVal;
	State headState;	
	public AdjList(){
		head = null;
	}
	
	public AdjList(int headValue){
		head = null;
		this.headVal = headValue;
		this.headState = State.Unvisited;
	}
	
	public AdjList(AdjListNode node){
		head = node;
	}
	
	public AdjListNode getHead() {
		return head;
	}
	
	public void setHead(AdjListNode headD) {
		head=headD;
	}
	
}

