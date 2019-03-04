package huiswerk.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Graph {
    public static final double INFINITY = Double.MAX_VALUE;

    public static void main(String[] args){
        Node node = new Node("1");
        Node node2 = new Node("2");
        Edge edge = new Edge(node, 2);
        Edge edge2 = new Edge(node2, 4);

    }
}

class Node {
    public String name; // Vertex name
    public List<Edge> adj; // Adjacent vertices
    public double dist; // Cost
    public Node prev; // Previous vertex on shortest path
    public int scratch;// Extra variable used in algorithm

    public Node( String nm ) {
        name = nm; adj = new LinkedList<Edge>( ); reset( ); }

    public void reset( ){
        dist = Graph.INFINITY; prev = null; scratch = 0;
    }

}

class Edge {
    public Node dest;
    public double cost;

    public Edge(Node dest, double cost){
        this.dest = dest;
        this.cost = cost;
    }
}