package huiswerk.graphsAndPaths;

import java.nio.file.Path;
import java.util.*;

public class Graph {
    private HashMap<String, Node> vertexMap = new HashMap<>();

    public void addNode(String nodeName) {
        if (vertexMap.get(nodeName) != null) {
            throw new Error("There is already a Node with that name!");
        }

        vertexMap.put(nodeName, new Node(nodeName));
    }

    public static final double INFINITY = Double.MAX_VALUE;

    public void addEdgeBetweenNodes(String nodeName, String adjNodeName, double edgeCost) {
        if (vertexMap.get(nodeName) == null || vertexMap.get(adjNodeName) == null) {
            throw new Error("Cannot add an edge between the nodes because one of the nodes does not exist.");
        }

        Node nodeA = vertexMap.get(nodeName);
        Node nodeB = vertexMap.get(adjNodeName);
        Edge edge = new Edge(nodeB, edgeCost);
        nodeA.addEdge(edge);
    }

    public String toString() {
        StringBuilder arrayToString = new StringBuilder();

        for (Map.Entry<String, Node> entry : vertexMap.entrySet()) {
            Node node = entry.getValue();
            for (Edge edge : node.getAdjEdges()) {
                arrayToString.append(String.format("[%s] --{%s]--> [%s]", node.getName(),
                        edge.getCost(), edge.getDest().getName())).append(System.getProperty("line.separator"));
            }
        }

        return arrayToString.toString();
    }

    public void dijkstra(String startName){
        PriorityQueue<Path> pq = new PriorityQueue<>();
        Node start = vertexMap.get(startName);
        if( start == null )
            throw new NoSuchElementException( "Start vertex not found" );


    }

    public static void main(String[] args) {
        Graph graph = new Graph();


        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addNode("E");
        graph.addNode("F");

        graph.addEdgeBetweenNodes("A", "B", 2);
        graph.addEdgeBetweenNodes("B", "F", 15);
        graph.addEdgeBetweenNodes("B", "C", 4);
        graph.addEdgeBetweenNodes("B", "D", 2);
        graph.addEdgeBetweenNodes("D", "C", 3);
        graph.addEdgeBetweenNodes("C", "E", 4);
        graph.addEdgeBetweenNodes("E", "F", 3);
        graph.addEdgeBetweenNodes("F", "D", 4);
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
    public Node dest; // Second vertex in edge
    public double cost;

    public Edge(Node dest, double cost) {
        this.dest = dest;
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    public Node getDest() {
        return dest;
    }
}

class Node {
    private String name;
    private List<Edge> adjEdges; // Adjacent edges

    public Node(String name) {
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

