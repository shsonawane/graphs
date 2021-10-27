package dungeon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

// ref: https://algorithms.tutorialhorizon.com/kruskals-algorithm-minimum-spanning-tree-mst-complete-java-implementation/
class Graph<T> {

  private final List<Edge<T>> edges;

  Graph() {
    this.edges = new ArrayList<>();
  }

  private Graph<T> kruskal(List<Edge<T>> edges) {
    //create subset of edges to keep track of parent and child vertices
    Map<T, T> parent = new HashMap<>();
    for (Edge<T> e : edges) {
      parent.put(e.getSource(), e.getSource());
      parent.put(e.getDestination(), e.getDestination());
    }
    Graph<T> mstGraph = new Graph<>();
    for (Edge<T> edge : edges) {
      // check if adding this edge creates a cycle
      T xSet = find(parent, edge.getSource());
      T ySet = find(parent, edge.getDestination());
      if (!xSet.equals(ySet)) {
        // add to mst if source and destination are not equal. If equal the cycle is created.
        // add it to our final result
        mstGraph.addEdge(edge.getSource(), edge.getDestination());
        union(parent, xSet, ySet);
      }
    }
    return mstGraph;
  }

  private T find(Map<T, T> parent, T vertex) {
    //chain of parent pointers from x upwards through the tree
    // until an element is reached whose parent is itself
    if (parent.get(vertex) != vertex) {
      return find(parent, parent.get(vertex));
    }
    return vertex;
  }

  private void union(Map<T, T> parent, T x, T y) {
    T xSetParent = find(parent, x);
    T ySetParent = find(parent, y);
    //make x as parent of y
    parent.put(ySetParent, xSetParent);
  }

  List<Edge<T>> getEdges() {
    return Collections.unmodifiableList(this.edges);
  }

  void addEdge(T source, T destination) {
    Edge<T> edge = new Edge<>(source, destination);
    edges.add(edge); //add to edge list
  }

  Graph<T> generateKruskalMST() {
    return kruskal(this.edges);
  }

  Graph<T> generateKruskalMST(Random random) {
    List<Edge<T>> edges = new ArrayList<>(this.edges);
    Collections.shuffle(edges, random);
    return this.kruskal(edges);
  }

  @Override
  public String toString() {
    return String.format("Graph{%s}", edges);
  }
}