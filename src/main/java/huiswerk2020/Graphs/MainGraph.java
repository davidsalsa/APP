package huiswerk2020.Graphs;

public class MainGraph {

    public static void main(String[] args){
        Graph graph = new Graph();

        Vertex v1 = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v3 = new Vertex("v3");
        Vertex v4 = new Vertex("v4");
        Vertex v5 = new Vertex("v5");

        graph.addEdge(v1.name, v2.name, 2);
        graph.addEdge(v2.name, v3.name, 1);
        graph.addEdge(v2.name, v4.name, 3);
        graph.addEdge(v3.name, v4.name, 1);

        graph.addEdge(v5.name, v5.name, 0);

        System.out.println("Connected: " + graph.isConnected());

        graph.addEdge(v4.name, v5.name, 4);

        System.out.println("Connected: " + graph.isConnected());

        graph.printPath(v5.name);

        graph.dijkstra(v1.name);
        graph.printPath(v5.name);
    }
}
