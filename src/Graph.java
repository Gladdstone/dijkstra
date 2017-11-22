import java.util.ArrayList;

public class Graph {
	
	private final Node[] nodeArr;
	private final int nodeCount;
	private final Edge[] edgeArr;
	private final int edgeCount;
	
	public Graph(Edge[] edgeArr) {
		this.edgeArr = edgeArr;
		
		this.nodeCount = calcNodes(edgeArr);
		this.nodeArr = new Node[this.nodeCount];
		
		for(int i = 0; i < this.nodeCount; i++) {
			this.nodeArr[i] = new Node();
		}
		
		this.edgeCount = edgeArr.length;
		
		for(int addEdge = 0; addEdge < this.edgeCount; addEdge++) {
		this.nodeArr[edgeArr[addEdge].getSource()].getEdgeList().add(edgeArr[addEdge]);
			this.nodeArr[edgeArr[addEdge].getDestination()].getEdgeList().add(edgeArr[addEdge]);
		}
	}
	
	private int calcNodes(Edge[] edgeArr) {
		int nodeCount = 0;
		
		for(Edge e : edgeArr) {
			if(e.getDestination() > nodeCount) {
				nodeCount = e.getDestination();
			}
			if(e.getSource() > nodeCount) {
				nodeCount = e.getSource();
			}
		}
		
		nodeCount++;
		
		return nodeCount;
	}
	
	public void calcShortestDistance() {
		this.nodeArr[0].setDistance(0);
		int nextNode = 0;
		
		for(int i = 0; i < this.nodeArr.length; i++) {
			ArrayList<Edge> currentEdges = this.nodeArr[nextNode].getEdgeList();
			
			for(int joinedEdge = 0; joinedEdge < currentEdges.size(); joinedEdge++) {
				int neighbourIndex = currentEdges.get(joinedEdge).getNeighbourIndex(nextNode);
				
				if(!this.nodeArr[neighbourIndex].isVisited()) {
					int tentative = this.nodeArr[nextNode].getDistance() + currentEdges.get(joinedEdge).getWeight();
					
					if(tentative < nodeArr[neighbourIndex].getDistance()) {
						nodeArr[neighbourIndex].setDistance(tentative);
					} 
				}
				
			}
			
			nodeArr[nextNode].setVisited(true);
			nextNode = getNodeShortestDistance();
		}
	}
	
	private int getNodeShortestDistance() {
		int storedIndex = 0;
		int storedDistance = Integer.MAX_VALUE;
		
		for(int i = 0; i < this.nodeArr.length; i++) {
			int currentDistance = this.nodeArr[i].getDistance();
			
			if(!this.nodeArr[i].isVisited() && currentDistance < storedDistance) {
				storedDistance = currentDistance;
				storedIndex = i;
			}
		}
		
		return storedIndex;
	}
	
	public void printResult() {
		String output = "Number of nodes: " + this.nodeCount;
		output += "\nNumber of edges: " + this.edgeCount;
		
		for(int i = 0; i < this.nodeArr.length; i++) {
			output += ("\nThe shortest distance from node 0 to node " + i + " is " + nodeArr[i].getDistance());
		}
		
		System.out.println(output);
	}
	
	public Node[] getNodes() {
		return nodeArr;
	}
	
	public int getNodeCount() {
		return nodeCount;
	}
	
	public Edge[] getEdges() {
		return edgeArr;
	}
	
	public int getEdgeCount() {
		return edgeCount;
	}
	
}