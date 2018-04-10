package main.java.org.spbstu.ziminlo;

import java.util.LinkedList;

public class Graph {
    private LinkedList<String> vertices;
    private LinkedList<Edge> edges;


    public Graph() {
        vertices = new LinkedList<>();
        edges = new LinkedList<>();
    }

    /**
     * @return copy of vertices
     */
    public LinkedList<String> getVertices() {
        return new LinkedList<>(vertices);
    }

    /**
     * @return copy of edges
     */
    public LinkedList<Edge> getEdges() {
        return new LinkedList<>(edges);
    }

    /**
     * add a vertex if it not contains
     *
     * @param name of added vertex
     * @return true if not contains this vertex
     */
    public boolean addVertex(String name) {
        if (containsVertex(name)) return false;
        vertices.add(name);
        return true;
    }

    /**
     * adds an edge if it not contains
     *
     * @param weight length of the edge
     * @param start  initial vertex
     * @param end    ultimate vertex
     * @return true if not contains strat , end
     */
    public boolean addEdge(int weight, String start, String end) {
        if (containsEdge(start, end)) return false;
        edges.add(new Edge(weight, start, end));
        if (!containsVertex(start))
            addVertex(start);
        if (!containsVertex(end))
            addVertex(end);
        return true;
    }

    /**
     * @param other field name
     * @return true if contains it
     */

    public boolean containsVertex(String other) {
        for (String vertex : vertices) {
            if (vertex.equals(other)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param start initial vertex
     * @param end   ultimate vertex
     * @return true if contains it
     */
    public boolean containsEdge(String start, String end) {
        for (Edge edge : edges) {
            if (edge.getStart().equals(start) &&
                    edge.getEnd().equals(end))
                return true;
        }
        return false;
    }

    /**
     * remove a vertex if it contains
     *
     * @param name name of vertex
     * @return true if contains it
     */
    public boolean removeVertex(String name) {
        if (!containsVertex(name)) return false;
        for (String vertex : vertices) {
            removeEdge(name, vertex);
            removeEdge(vertex, name);
        }
        for (String vertex : vertices) {
            if (vertex.equals(name)) {
                vertices.remove(vertex);
                break;
            }
        }
        return true;
    }

    /**
     * remove an edge if it contains
     *
     * @param start initial vertex
     * @param end   ultimate vertex
     * @return true if contains it
     */
    public boolean removeEdge(String start, String end) {
        if (!containsEdge(start, end)) return false;
        for (Edge edge : edges) {
            if (edge.getStart().equals(start) &&
                    edge.getEnd().equals(end)) {
                edges.remove(edge);
            }
        }
        return true;
    }

    /**
     * rename vertex if not contains new name and contains old name
     *
     * @param oldName name of vertex
     * @param newName new name of vertex
     * @return true if not contains new name and contains old name
     */
    public boolean renameVertex(String oldName, String newName) {
        if (!containsVertex(oldName)) return false;
        if (containsVertex(newName)) return false;
        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i).equals(oldName)) {
                vertices.set(i, newName);
            }
        }
        for (Edge edge : edges) {
            if (edge.getStart().equals(oldName))
                edge.setStart(newName);
            if (edge.getEnd().equals(oldName))
                edge.setEnd(newName);
        }
        return true;
    }

    /**
     * change edge weight if contains it
     *
     * @param newWeight new length of the edge
     * @param start     initial vertex
     * @param end       ultimate vertex
     * @return true if contains it
     */
    public boolean changeEdgeWeight(String start, String end, int newWeight) {
        if (!containsEdge(start, end)) return false;
        for (Edge edge : edges) {
            if (edge.getStart().equals(start) &&
                    edge.getEnd().equals(end))
                edge.setWeight(newWeight);
        }
        return true;
    }

    /**
     * displays all output edges if contains start vertex
     *
     * @param start initial vertex
     * @return all output edges of a vertex if contains vertex
     */
    public LinkedList<Edge> outputEdges(String start) {
        LinkedList<Edge> result = new LinkedList<>();
        if (!containsVertex(start)) return result;
        for (Edge edge : edges) {
            if (edge.getStart().equals(start))
                result.add(edge);
        }
        return result;
    }

    /**
     * displays all input edges if contains end vertex
     *
     * @param end ultimate vertex
     * @return all input edges of a vertex if contains vertex
     */
    public LinkedList<Edge> inputEdges(String end) {
        LinkedList<Edge> result = new LinkedList<>();
        if (!containsVertex(end)) return result;
        for (Edge edge : edges) {
            if (edge.getEnd().equals(end))
                result.add(edge);
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this.getClass().equals(o.getClass())) {
            Graph other = (Graph) o;
            return vertices.equals(other.vertices) && edges.equals(other.edges);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = vertices != null ? vertices.hashCode() : 0;
        result = 31 * result + (edges != null ? edges.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return vertices.toString() + "\n" + edges.toString();
    }

}
