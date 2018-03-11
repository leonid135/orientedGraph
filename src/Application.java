public class Application {
    public static void main(String[] args) {
        Edge e1 = new Edge(1, "A", "B");
        Edge e2 = new Edge(2, "A", "C");
        Edge e3 = new Edge(3, "A", "D");
        Edge e4 = new Edge(4, "B", "A");
        Edge e5 = new Edge(5, "C", "D");
        Graph g1 = new Graph();
        g1.addEdge(e1);
        g1.addEdge(e2);
        g1.addEdge(e3);
        g1.addEdge(e4);
        g1.addEdge(e5);
        System.out.println("Source graph : " + g1);
        g1.removeVertex("C");
        System.out.println("___________________________________________________");
        System.out.println("Remove \"C\" : " + g1);
        System.out.println("___________________________________________________");
        System.out.println("Input to \"A\" : " + g1.inputEdges("A"));
        System.out.println("___________________________________________________");
        System.out.println("Output from \"A\" : " + g1.outputEdges("A"));
        System.out.println("___________________________________________________");
        g1.changeEdgeWeight("A", "D", 10);
        g1.renameVertex("A", "E");
        System.out.println(g1);
    }
}
