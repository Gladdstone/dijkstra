import java.util.Scanner;

/**
 * Created by JosephFarrell on 11/19/2017.
 */
public class dijkstra {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // read number of nodes
        int nodeCount = scan.nextInt();
        if(nodeCount < 0 || nodeCount > 20) {
            System.out.println("Node count error");
        }

        // read number of edges
        int edgeCount = scan.nextInt();
        if(edgeCount < 0 || edgeCount > (nodeCount * nodeCount)) {
            System.out.println("Edge count error");
        }
    }

}
