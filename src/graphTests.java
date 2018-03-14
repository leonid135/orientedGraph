import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class graphTests {

    Graph graph;

    @Test
    public void createEmpty() {
        graph = new Graph();
        assertEquals("[]\n[]", graph.toString());
    }
        @Test
        public void addVertex() {
            graph = new Graph();
            graph.addVertex("A");
            assertEquals("[A]\n[]", graph.toString());
    }

    @Test
    public void addEdge() {
        graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addEdge(10, "A", "B");
        assertEquals("[A, B]\n[A -> 10 -> B]", graph.toString());

    }

    @Test
    public void addEdge2() {
        Edge e1 = new Edge(10, "A", "B");
        graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addEdge(e1);
        assertEquals("[A, B]\n[A -> 10 -> B]", graph.toString());



    }

    @Test
    public void removeVertex() {
        graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addEdge(10, "A", "B");
        graph.removeVertex("C");
        assertEquals("[A, B]\n[A -> 10 -> B]", graph.toString());
    }

    @Test
    public void removeEdge() {
        graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addEdge(10, "A", "B");
        graph.addEdge(10, "A", "C");
        graph.removeEdge("A", "C");
        assertEquals("[A, B, C]\n[A -> 10 -> B]", graph.toString());

    }

    @Test
    public void renameVertex() {
        graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addEdge(10, "A", "B");
        graph.renameVertex("B","L");
        assertEquals("[A, L]\n[A -> 10 -> L]", graph.toString());

    }
    @Test
    public void changeEdgeWeight(){
        graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addEdge(10, "A", "B");
        graph.changeEdgeWeight("A","B",13);
        assertEquals("[A, B]\n[A -> 13 -> B]", graph.toString());

    }

    @Test
    public void outputEdges(){
        graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addEdge(10, "A", "B");
        graph.addEdge(30, "A", "C");
        graph.outputEdges("A");
        assertEquals("[A, B, C]\n[A -> 10 -> B, A -> 30 -> C]", graph.toString());

    }
    @Test
    public void inputEdges(){
        graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addEdge(10, "B", "A");
        graph.addEdge(30, "C", "A");
        graph.inputEdges("A");
        assertEquals("[A, B, C]\n[B -> 10 -> A, C -> 30 -> A]", graph.toString());
    }
}

