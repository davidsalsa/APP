package huiswerk2020.Graphs;

import java.util.LinkedList;
import java.util.List;

public class Vertex {
    public String name;
    public List<Edge> adj;
    public double dist;
    public Vertex prev;
    public int scratch;

    public Vertex(String name){
        this.name = name;
        adj = new LinkedList<>();
    }

    public void reset( )
    {
        dist = Graph.INFINITY; prev = null; scratch = 0;
    }

}
