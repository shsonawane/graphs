package dungeon;

import java.util.Random;

import dungeon.Graph;

// ref: https://algorithms.tutorialhorizon.com/kruskals-algorithm-minimum-spanning-tree-mst-complete-java-implementation/
public class GraphDriver {
  public static void main(String[] args) {
    Graph<String> graph = new Graph<>();
    graph.addEdge("A", "B");
    graph.addEdge("C", "B");
    graph.addEdge("D", "E");
    graph.addEdge("E", "C");
    graph.addEdge("B", "D");
    Graph<String> mst = graph.generateKruskalMST(new Random());
    int i=0;
    for (Edge<String> edge: mst.getEdges()) {
      System.out.println("Edge-" + ++i + " source: " + edge.getSource() +
              " destination: " + edge.getDestination());
    }

    Graph<Integer> graph2 = new Graph<>();
    graph2.addEdge(1, 2);
    graph2.addEdge(1, 3);
    graph2.addEdge(3, 4);
    graph2.addEdge(2, 4);

    Graph<Integer> mst2 = graph2.generateKruskalMST(new Random());
    i=0;
    for (Edge<Integer> edge: mst2.getEdges()) {
      System.out.println("Edge-" + ++i + " source: " + edge.getSource() +
              " destination: " + edge.getDestination());
    }
  }

}