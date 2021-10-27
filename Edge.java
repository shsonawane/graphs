package dungeon;
class Edge<T> {
  final private T source;
  final private T destination;

  Edge(T source, T destination) {
    this.source = source;
    this.destination = destination;
  }

  T getSource() {
    return this.source;
  }

  T getDestination() {
    return this.destination;
  }

  @Override
  public String toString() {
    return new StringBuilder().append("Edge{")
            .append("source=").append(source)
            .append(", destination=").append(destination)
            .append('}').toString();
  }

}