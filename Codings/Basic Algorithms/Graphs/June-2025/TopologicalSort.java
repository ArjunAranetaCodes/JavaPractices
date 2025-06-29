import java.util.*;

/**
 * Topological Sort Algorithm Implementation
 *
 * Topological sort is an ordering of vertices in a Directed Acyclic Graph (DAG)
 * such that for every directed edge u -> v, vertex u comes before v in the ordering.
 * It's useful for:
 * - Task scheduling
 * - Build systems
 * - Course prerequisite ordering
 * - Dependency resolution
 */
public class TopologicalSort {
    private int vertices;
    private List<List<Integer>> adjacencyList;

    public TopologicalSort(int vertices) {
        this.vertices = vertices;
        adjacencyList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    /**
     * Add a directed edge to the graph
     */
    public void addEdge(int source, int destination) {
        adjacencyList.get(source).add(destination);
    }

    /**
     * Kahn's Algorithm (BFS-based Topological Sort)
     * Time Complexity: O(V + E)
     */
    public List<Integer> kahnTopologicalSort() {
        int[] inDegree = new int[vertices];
        for (int u = 0; u < vertices; u++) {
            for (int v : adjacencyList.get(u)) {
                inDegree[v]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < vertices; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> topoOrder = new ArrayList<>();
        int count = 0;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            topoOrder.add(u);
            for (int v : adjacencyList.get(u)) {
                if (--inDegree[v] == 0) {
                    queue.add(v);
                }
            }
            count++;
        }

        if (count != vertices) {
            System.out.println("Graph has a cycle! Topological sort not possible.");
            return new ArrayList<>();
        }
        return topoOrder;
    }

    /**
     * DFS-based Topological Sort
     */
    public List<Integer> dfsTopologicalSort() {
        boolean[] visited = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                dfsUtil(i, visited, stack);
            }
        }
        List<Integer> topoOrder = new ArrayList<>();
        while (!stack.isEmpty()) {
            topoOrder.add(stack.pop());
        }
        return topoOrder;
    }

    private void dfsUtil(int u, boolean[] visited, Stack<Integer> stack) {
        visited[u] = true;
        for (int v : adjacencyList.get(u)) {
            if (!visited[v]) {
                dfsUtil(v, visited, stack);
            }
        }
        stack.push(u);
    }

    /**
     * Detect cycle in a directed graph
     */
    public boolean hasCycle() {
        boolean[] visited = new boolean[vertices];
        boolean[] recStack = new boolean[vertices];
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                if (hasCycleUtil(i, visited, recStack)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasCycleUtil(int u, boolean[] visited, boolean[] recStack) {
        visited[u] = true;
        recStack[u] = true;
        for (int v : adjacencyList.get(u)) {
            if (!visited[v] && hasCycleUtil(v, visited, recStack)) {
                return true;
            } else if (recStack[v]) {
                return true;
            }
        }
        recStack[u] = false;
        return false;
    }

    // Main method for testing
    public static void main(String[] args) {
        TopologicalSort graph = new TopologicalSort(6);
        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        System.out.println("Kahn's Algorithm Topological Sort:");
        System.out.println(graph.kahnTopologicalSort());

        System.out.println("DFS-based Topological Sort:");
        System.out.println(graph.dfsTopologicalSort());

        System.out.println("Graph has cycle: " + graph.hasCycle());
    }
} 