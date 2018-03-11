import java.util.LinkedList;

public class Graph {
    private LinkedList<String> vertices;
    private LinkedList<Edge> edges;

    public Graph() {
        vertices = new LinkedList<>();
        edges = new LinkedList<>();
    }

    public LinkedList<String> getVertices() {
        return vertices;
    }

    public LinkedList<Edge> getEdges() {
        return edges;
    }

    public void addVertex(String name) {
        if(containsVertex(name)) return;
        vertices.add(name);
    }

    public void addEdge(int weight, String start, String end) {
        if (containsEdge(start, end)) return;
        edges.add(new Edge(weight, start, end));
        if (!containsVertex(start))
            addVertex(start);
        if (!containsVertex(end))
            addVertex(end);
    }

    public void addEdge(Edge edge) {
        if (containsEdge(edge.getStart(), edge.getEnd())) return;
        edges.add(edge);
        if (!containsVertex(edge.getStart()))
            addVertex(edge.getStart());
        if (!containsVertex(edge.getEnd()))
            addVertex(edge.getEnd());
    }

    public boolean containsVertex(String other) {
        for (String vertex: vertices) {
            if(vertex == other) {
                return true;
            }
        }
        return false;
    }

    public boolean containsEdge(String start, String end) {
        for (Edge edge: edges) {
            if(edge.getStart() == start &&
                    edge.getEnd() == end)
                return true;
        }
        return false;
    }

    public void removeVertex(String name) {
        if (!containsVertex(name)) return;
        for (String vertex: vertices) {
            removeEdge(name, vertex);
            removeEdge(vertex, name);
        }
        for (String vertex: vertices) {
            if (vertex == name) {
                vertices.remove(vertex);
                break;
            }
        }
    }

    public void removeEdge(String start, String end) {
        if (!containsEdge(start, end)) return;
        for(Edge edge: edges) {
            if (edge.getStart() == start &&
                    edge.getEnd() == end)
            {
                edges.remove(edge);
                return;
            }
        }
    }

    public void renameVertex(String oldName, String newName) {
        if(!containsVertex(oldName)) return;
        if(containsVertex(newName)) return;
        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i) == oldName)
            {
                vertices.set(i, newName);
            }
        }
        for (Edge edge: edges) {
            if (edge.getStart() == oldName)
                edge.setStart(newName);
            if (edge.getEnd() == oldName)
                edge.setEnd(newName);
        }
    }

    public void changeEdgeWeight(String start, String end, int newWeight) {
        if(!containsEdge(start, end)) return;
        for (Edge edge: edges) {
            if(edge.getStart() == start &&
                    edge.getEnd() == end)
                edge.setWeight(newWeight);
        }
    }

    public LinkedList<Edge> outputEdges(String start) {
        LinkedList<Edge> result = new LinkedList<>();
        if(!containsVertex(start)) return result;
        for(Edge edge: edges) {
            if (edge.getStart() == start)
                result.add(edge);
        }
        return result;
    }

    public LinkedList<Edge> inputEdges(String end) {
        LinkedList<Edge> result = new LinkedList<>();
        if(!containsVertex(end)) return result;
        for(Edge edge: edges) {
            if (edge.getEnd() == end)
                result.add(edge);
        }
        return result;
    }
   @Override
    public String toString() {
        return vertices.toString() + "\n" + edges.toString();
    }
}
