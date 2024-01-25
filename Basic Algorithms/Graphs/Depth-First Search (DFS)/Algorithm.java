import java.util.*;

public class Algorithm {
    private int vertices;
    private LinkedList<Integer> adjacencyList[];

    public Algorithm(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int vertex, int neighbor) {
        adjacencyList[vertex].add(neighbor);
    }

    public void DFS(int startVertex) {
        boolean visited[] = new boolean[vertices];
        DFSUtil(startVertex, visited);
    }

    private void DFSUtil(int vertex, boolean visited[]) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int neighbor : adjacencyList[vertex]) {
            if (!visited[neighbor]) {
                DFSUtil(neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        Algorithm graph = new Algorithm(7);


    }
}
