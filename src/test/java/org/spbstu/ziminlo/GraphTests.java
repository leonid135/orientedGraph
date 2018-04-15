package org.spbstu.ziminlo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.spbstu.ziminlo.task1.Graph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GraphTests {

    Graph graph;

    @BeforeEach
    void inEeach() {
        graph = new Graph();
    }

    public void createGraph() {
        graph.addEdge(10, "A", "B");
        graph.addEdge(30, "A", "C");
    }

    @Test
    public void createEmpty() {
        assertEquals("[]\n[]", graph.toString());
    }

    @Test
    public void addVertex() {
        graph.addVertex("A");
        assertEquals("[A]\n[]", graph.toString());
    }

    @Test
    public void addVertexFalse() {
        graph.addVertex("A");
        assertFalse(graph.addVertex("A"));
    }

    @Test
    public void addEdge() {
        createGraph();
        assertEquals("[A, B, C]\n[A -> 10 -> B, A -> 30 -> C]", graph.toString());

    }

    @Test
    public void addEdgeFalse() {
        graph.addEdge(10, "A", "B");
        assertFalse(graph.addEdge(10, "A", "B"));
    }

    @Test
    public void containsVertex() {
        createGraph();
        assertTrue(graph.containsVertex("A"));
    }

    @Test
    public void containsEdge() {
        createGraph();
        assertTrue(graph.containsEdge("A", "B"));
    }

    @Test
    public void removeVertex() {
        createGraph();
        graph.removeVertex("C");
        assertEquals("[A, B]\n[A -> 10 -> B]", graph.toString());
    }

    @Test
    public void removeVertexNotContains() {
        createGraph();
        assertFalse(graph.removeVertex("l"));
    }

    @Test
    public void removeEdge() {
        createGraph();
        graph.removeEdge("A", "C");
        assertEquals("[A, B, C]\n[A -> 10 -> B]", graph.toString());

    }

    @Test
    public void removeEdgeNotContains() {
        createGraph();
        assertFalse(graph.removeEdge("s", "k"));

    }

    @Test
    public void renameVertex() {
        createGraph();
        graph.renameVertex("B", "L");
        assertEquals("[A, L, C]\n[A -> 10 -> L, A -> 30 -> C]", graph.toString());

    }

    @Test
    public void renameVertexNotContainsOld() {
        createGraph();
        graph.renameVertex("B", "L");
        assertFalse(graph.renameVertex("s", "L"));

    }

    @Test
    public void renameVertexContainsNew() {
        createGraph();
        assertFalse(graph.renameVertex("B", "A"));

    }

    @Test
    public void changeEdgeWeight() {
        createGraph();
        graph.changeEdgeWeight("A", "B", 13);
        assertEquals("[A, B, C]\n[A -> 13 -> B, A -> 30 -> C]", graph.toString());

    }

    @Test
    public void changeEdgeWeightNotContains() {
        createGraph();
        assertFalse(graph.changeEdgeWeight("d", "Be", 13));

    }

    @Test
    public void outputEdges() {
        createGraph();
        assertEquals("[A -> 10 -> B, A -> 30 -> C]", graph.outputEdges("A").toString());

    }

    @Test
    public void inputEdges() {
        createGraph();
        assertEquals("[]", graph.inputEdges("A").toString());
    }

}

