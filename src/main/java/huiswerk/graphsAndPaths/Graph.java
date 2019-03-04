package huiswerk.graphsAndPaths;

import java.util.*;

public class Graph {
    private HashMap<String, Vertex> vertexMap = new HashMap<>();

    public void addVertex(String vertexName) {
        if (vertexMap.get(vertexName) != null) {
            throw new Error("There is already a vertex with that name!");
        }

        vertexMap.put(vertexName, new Vertex(vertexName));
    }

    public static final double INFINITY = Double.MAX_VALUE;

    public void addEdgeBetweenVertex(String vertexName, String adjVertexName, double edgeCost) {
        if (vertexMap.get(vertexName) == null || vertexMap.get(adjVertexName) == null) {
            throw new Error("Cannot add an edge between the vertexes because one of the vertexes does not exist.");
        }

        Vertex vertexA = vertexMap.get(vertexName);
        Vertex vertexB = vertexMap.get(adjVertexName);
        Edge edge = new Edge(vertexB, edgeCost);
        vertexA.addEdge(edge);
    }

    public String toString() {
        StringBuilder arrayToString = new StringBuilder();

        for (Map.Entry<String, Vertex> entry : vertexMap.entrySet()) {
            Vertex vertex = entry.getValue();
            for (Edge edge : vertex.getAdjEdges()) {
                arrayToString.append(String.format("[%s] --{%s]--> [%s]", vertex.getName(),
                        edge.getCost(), edge.getDest().getName())).append(System.getProperty("line.separator"));
            }
        }

        return arrayToString.toString();
    }

    public static void main(String[] args) {
        Graph graph = new Graph();


        graph.addVertex("1");
        graph.addVertex("2");
        graph.addVertex("3");
        graph.addVertex("4");

        graph.addEdgeBetweenVertex("1", "2", 2);
        graph.addEdgeBetweenVertex("1", "3", 3);
        graph.addEdgeBetweenVertex("1", "4", 4);
        System.out.println(graph.toString());
    }
}

// Used to signal violations of preconditions for
// various shortest path algorithms.
class GraphException extends RuntimeException {
    public GraphException(String name) {
        super(name);
    }
}


class Edge {
    public Vertex dest; // Second vertex in edge
    public double cost;

    public Edge(Vertex dest, double cost) {
        this.dest = dest;
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    public Vertex getDest() {
        return dest;
    }
}

class Vertex {
    private String name;
    private List<Edge> adjEdges; // Adjacent edges

    public Vertex(String name) {
        this.name = name;
        this.adjEdges = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public List<Edge> getAdjEdges() {
        return adjEdges;
    }

    public void addEdge(Edge adjacentEdge) {
        adjEdges.add(adjacentEdge);
    }
}

