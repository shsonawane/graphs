# Generic Graphs

Generic implementation of unweighted graphs data structure in Java.

# Usage
- Import graph file as below
```
import Graph;
```
- Create graph object.
```
Graph<String> graph = new Graph<>();
graph.addEdge("A", "B");
graph.addEdge("C", "B");
graph.addEdge("D", "E");
graph.addEdge("E", "C");
graph.addEdge("B", "D");
```
- genarate MST using kruskal algorithm.
```
Graph<String> mst = graph.generateKruskalMST();
```
