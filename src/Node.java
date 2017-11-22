import java.util.ArrayList;

public class Node {
	
	private int distance = Integer.MAX_VALUE;
	private boolean visited;
	private ArrayList<Edge> edgeList = new ArrayList<Edge>();
	
	public int getDistance() {
		return distance;
	}
	
	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	public boolean isVisited() {
		return visited;
	}
	
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
	public ArrayList<Edge> getEdgeList() {
		return edgeList;
	}
	
	public void setEdgeList(ArrayList<Edge> edgeList) {
		this.edgeList = edgeList;
	}
	
}