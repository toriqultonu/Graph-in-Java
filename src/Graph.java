import java.util.ArrayList;

public class Graph {

    private ArrayList<Vertex> vertices;
    private boolean isWeighted;
    private boolean isDirected;

    public Graph(boolean isWeighted, boolean isDirected) {
        this.vertices = new ArrayList<>();
        this.isWeighted = isWeighted;
        this.isDirected = isDirected;
    }

    public Vertex addVertex(String data) {
        Vertex v = new Vertex(data);
        vertices.add(v);
        return v;
    }

    public void addEdge(Vertex start, Vertex end, Integer weight) {
        if (!this.isWeighted) {
            weight = null;
        }
       start.addEdge(end, weight);

        if (!this.isDirected) {
            end.addEdge(start, weight);
        }
    }

    public void removeEdge(Vertex start, Vertex end) {
        start.removeEdge(end);
        if (!this.isDirected) {
            end.removeEdge(start);
        }
    }

    public void removeVertex(Vertex vertex) {
        this.vertices.remove(vertex);
    }

    public ArrayList<Vertex> getVertices() {
        return vertices;
    }

    public boolean isWeighted() {
        return isWeighted;
    }

    public boolean isDirected() {
        return isDirected;
    }

    public Vertex getVertexByValue(String value){
        for (Vertex vertex : vertices) {
            if (vertex.getData().equals(value)) {
                return vertex;
            }
        }
        return null;
    }

    public void print() {
        for (Vertex vertex : vertices) {
            vertex.print(isWeighted);
        }
    }

    public static void main(String[] args) {

        Graph busNetwork = new Graph(true, false);

        Vertex A = busNetwork.addVertex("A");
        Vertex B = busNetwork.addVertex("B");

        busNetwork.addEdge(A, B, 1000);
        busNetwork.print();
    }
}
