import java.util.*;

/**
 * Kruskal's Minimum Spanning Tree (MST) Algorithm Implementation
 *
 * Kruskal's algorithm finds the minimum spanning tree in a weighted undirected graph.
 * It is useful for:
 * - Network design
 * - Clustering
 * - Circuit design
 * - Road/railway construction
 */
public class KruskalMST {
    static class Edge implements Comparable<Edge> {
        int source, destination, weight;
        Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    private int vertices;
    private List<Edge> edges;

    public KruskalMST(int vertices) {
        this.vertices = vertices;
        this.edges = new ArrayList<>();
    }

    /**
     * Add an undirected weighted edge
     */
    public void addEdge(int source, int destination, int weight) {
        edges.add(new Edge(source, destination, weight));
    }

    /**
     * Find the MST using Kruskal's algorithm
     */
    public List<Edge> findMST() {
        Collections.sort(edges);
        int[] parent = new int[vertices];
        for (int i = 0; i < vertices; i++) parent[i] = i;
        List<Edge> mst = new ArrayList<>();
        int count = 0;
        for (Edge edge : edges) {
            int root1 = find(parent, edge.source);
            int root2 = find(parent, edge.destination);
            if (root1 != root2) {
                mst.add(edge);
                parent[root1] = root2;
                count++;
                if (count == vertices - 1) break;
            }
        }
        return mst;
    }

    private int find(int[] parent, int i) {
        if (parent[i] != i) parent[i] = find(parent, parent[i]);
        return parent[i];
    }

    // Main method for testing
    public static void main(String[] args) {
        KruskalMST graph = new KruskalMST(6);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 4);
        graph.addEdge(1, 2, 2);
        graph.addEdge(1, 0, 4);
        graph.addEdge(2, 0, 4);
        graph.addEdge(2, 1, 2);
        graph.addEdge(2, 3, 3);
        graph.addEdge(2, 5, 2);
        graph.addEdge(2, 4, 4);
        graph.addEdge(3, 2, 3);
        graph.addEdge(3, 4, 3);
        graph.addEdge(4, 2, 4);
        graph.addEdge(4, 3, 3);
        graph.addEdge(5, 2, 2);
        graph.addEdge(5, 4, 3);

        List<Edge> mst = graph.findMST();
        int totalWeight = 0;
        System.out.println("Edges in MST:");
        for (Edge edge : mst) {
            System.out.println(edge.source + " - " + edge.destination + " : " + edge.weight);
            totalWeight += edge.weight;
        }
        System.out.println("Total weight of MST: " + totalWeight);
    }
} 