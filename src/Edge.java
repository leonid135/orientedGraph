import sun.security.provider.certpath.Vertex;

public class Edge {
    private int weight;
    private String start;
    private String end;

    public Edge (int weight, String start, String end) {
        this.weight = weight;
        this.start = start;
        this.end = end;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return start + " -> " + weight + " -> " + end;
    }
}
