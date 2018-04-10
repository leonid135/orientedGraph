package main.java.org.spbstu.ziminlo;


public class Edge {
    private int weight;
    private String start;
    private String end;

    public Edge(int weight, String start, String end) {
        this.weight = weight;
        this.start = start;
        this.end = end;
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
    public boolean equals(Object o) {
        if (this.getClass().equals(o.getClass())) {
            Edge other = (Edge) o;
            return weight == other.weight && start.equals(other.start) && end.equals(other.end);
        }
        return false;
    }

    @Override
    public String toString() {
        return start + " -> " + weight + " -> " + end;
    }


}
