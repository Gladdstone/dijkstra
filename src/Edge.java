import java.util.ArrayList;
import java.util.Scanner;


public class Edge {
	
	private final int source;
	private final int destination;
	private final int weight;

	public Edge(int source, int destination, int weight) {
		this.source = source;
		this.destination = destination;
		this.weight = weight;
	}

	public int getSource() {
		return source;
	}

	public int getDestination() {
		return destination;
	}

	public int getWeight() {
		return weight;
	}
	
	public int getNeighbourIndex(int nodeIndex) {
		if(this.source == nodeIndex) {
			return this.destination;
		}
		else {
			return this.source;
		}
	}

}