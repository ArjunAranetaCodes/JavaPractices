import java.util.*;

/**
 * Depth-First Search (DFS) Algorithm Implementation
 * 
 * DFS is a graph traversal algorithm that explores as far as possible along each branch
 * before backtracking. It's useful for:
 * - Exploring all possible paths
 * - Topological sorting
 * - Cycle detection
 * - Connected components
 * - Maze solving
 * - Game tree exploration
 */
public class DepthFirstSearch {
    
    private int vertices;
    private LinkedList<Integer>[] adjacencyList;
    
    @SuppressWarnings("unchecked")
    public DepthFirstSearch(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }
    
    /**
     * Add an edge to the graph
     */
    public void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);
        // For undirected graph, uncomment the next line
        // adjacencyList[destination].add(source);
    }
    
    /**
     * Recursive DFS traversal
     * Time Complexity: O(V + E) where V is vertices and E is edges
     * Space Complexity: O(V) for the recursion stack
     */
    public void dfsRecursive(int startVertex) {
        boolean[] visited = new boolean[vertices];
        System.out.println("DFS Recursive Traversal starting from vertex " + startVertex + ":");
        dfsRecursiveUtil(startVertex, visited);
        System.out.println();
    }
    
    private void dfsRecursiveUtil(int vertex, boolean[] visited) {
        // Mark current vertex as visited and print it
        visited[vertex] = true;
        System.out.print(vertex + " ");
        
        // Recur for all adjacent vertices
        for (int adjacent : adjacencyList[vertex]) {
            if (!visited[adjacent]) {
                dfsRecursiveUtil(adjacent, visited);
            }
        }
    }
    
    /**
     * Iterative DFS using Stack
     * Useful when dealing with very deep graphs to avoid stack overflow
     */
    public void dfsIterative(int startVertex) {
        boolean[] visited = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();
        
        System.out.println("DFS Iterative Traversal starting from vertex " + startVertex + ":");
        
        // Push start vertex to stack
        stack.push(startVertex);
        
        while (!stack.isEmpty()) {
            // Pop a vertex from stack
            int currentVertex = stack.pop();
            
            // If not visited, mark as visited and print
            if (!visited[currentVertex]) {
                visited[currentVertex] = true;
                System.out.print(currentVertex + " ");
                
                // Push all adjacent vertices to stack
                // Note: We push in reverse order to maintain DFS order
                for (int i = adjacencyList[currentVertex].size() - 1; i >= 0; i--) {
                    int adjacent = adjacencyList[currentVertex].get(i);
                    if (!visited[adjacent]) {
                        stack.push(adjacent);
                    }
                }
            }
        }
        System.out.println();
    }
    
    /**
     * DFS for all vertices (handles disconnected graphs)
     */
    public void dfsAllVertices() {
        boolean[] visited = new boolean[vertices];
        System.out.println("DFS for all vertices (handles disconnected components):");
        
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                System.out.print("Component starting from " + i + ": ");
                dfsRecursiveUtil(i, visited);
                System.out.println();
            }
        }
    }
    
    /**
     * Find connected components using DFS
     */
    public List<List<Integer>> findConnectedComponents() {
        boolean[] visited = new boolean[vertices];
        List<List<Integer>> components = new ArrayList<>();
        
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                dfsComponentUtil(i, visited, component);
                components.add(component);
            }
        }
        
        return components;
    }
    
    private void dfsComponentUtil(int vertex, boolean[] visited, List<Integer> component) {
        visited[vertex] = true;
        component.add(vertex);
        
        for (int adjacent : adjacencyList[vertex]) {
            if (!visited[adjacent]) {
                dfsComponentUtil(adjacent, visited, component);
            }
        }
    }
    
    /**
     * Detect cycle in directed graph using DFS
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
    
    private boolean hasCycleUtil(int vertex, boolean[] visited, boolean[] recStack) {
        visited[vertex] = true;
        recStack[vertex] = true;
        
        for (int adjacent : adjacencyList[vertex]) {
            if (!visited[adjacent]) {
                if (hasCycleUtil(adjacent, visited, recStack)) {
                    return true;
                }
            } else if (recStack[adjacent]) {
                return true; // Back edge found
            }
        }
        
        recStack[vertex] = false;
        return false;
    }
    
    /**
     * Topological Sort using DFS
     * Only works for Directed Acyclic Graphs (DAGs)
     */
    public List<Integer> topologicalSort() {
        if (hasCycle()) {
            System.out.println("Graph has cycle, topological sort not possible!");
            return new ArrayList<>();
        }
        
        boolean[] visited = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }
        }
        
        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        
        return result;
    }
    
    private void topologicalSortUtil(int vertex, boolean[] visited, Stack<Integer> stack) {
        visited[vertex] = true;
        
        for (int adjacent : adjacencyList[vertex]) {
            if (!visited[adjacent]) {
                topologicalSortUtil(adjacent, visited, stack);
            }
        }
        
        stack.push(vertex);
    }
    
    /**
     * Find path from source to destination using DFS
     */
    public List<Integer> findPath(int source, int destination) {
        boolean[] visited = new boolean[vertices];
        List<Integer> path = new ArrayList<>();
        
        if (findPathUtil(source, destination, visited, path)) {
            return path;
        }
        
        return new ArrayList<>(); // No path found
    }
    
    private boolean findPathUtil(int current, int destination, boolean[] visited, List<Integer> path) {
        visited[current] = true;
        path.add(current);
        
        if (current == destination) {
            return true;
        }
        
        for (int adjacent : adjacencyList[current]) {
            if (!visited[adjacent]) {
                if (findPathUtil(adjacent, destination, visited, path)) {
                    return true;
                }
            }
        }
        
        // Backtrack
        path.remove(path.size() - 1);
        return false;
    }
    
    /**
     * Count number of paths between two vertices
     */
    public int countPaths(int source, int destination) {
        boolean[] visited = new boolean[vertices];
        return countPathsUtil(source, destination, visited);
    }
    
    private int countPathsUtil(int current, int destination, boolean[] visited) {
        if (current == destination) {
            return 1;
        }
        
        visited[current] = true;
        int count = 0;
        
        for (int adjacent : adjacencyList[current]) {
            if (!visited[adjacent]) {
                count += countPathsUtil(adjacent, destination, visited);
            }
        }
        
        visited[current] = false; // Backtrack
        return count;
    }
    
    /**
     * Print the adjacency list representation of the graph
     */
    public void printGraph() {
        System.out.println("Graph Representation (Adjacency List):");
        for (int i = 0; i < vertices; i++) {
            System.out.print("Vertex " + i + " -> ");
            for (int adjacent : adjacencyList[i]) {
                System.out.print(adjacent + " ");
            }
            System.out.println();
        }
    }
    
    // Main method for testing
    public static void main(String[] args) {
        // Create a graph with 6 vertices
        DepthFirstSearch graph = new DepthFirstSearch(6);
        
        // Add edges
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);
        
        // Print graph
        graph.printGraph();
        System.out.println();
        
        // Recursive DFS
        graph.dfsRecursive(0);
        
        // Iterative DFS
        graph.dfsIterative(0);
        
        // DFS for all vertices
        graph.dfsAllVertices();
        System.out.println();
        
        // Find connected components
        List<List<Integer>> components = graph.findConnectedComponents();
        System.out.println("Connected Components:");
        for (int i = 0; i < components.size(); i++) {
            System.out.println("Component " + (i + 1) + ": " + components.get(i));
        }
        System.out.println();
        
        // Check for cycles
        System.out.println("Graph has cycle: " + graph.hasCycle());
        System.out.println();
        
        // Find path
        List<Integer> path = graph.findPath(0, 5);
        System.out.println("Path from 0 to 5: " + path);
        System.out.println();
        
        // Count paths
        int pathCount = graph.countPaths(0, 5);
        System.out.println("Number of paths from 0 to 5: " + pathCount);
        System.out.println();
        
        // Test topological sort with a DAG
        DepthFirstSearch dag = new DepthFirstSearch(6);
        dag.addEdge(5, 2);
        dag.addEdge(5, 0);
        dag.addEdge(4, 0);
        dag.addEdge(4, 1);
        dag.addEdge(2, 3);
        dag.addEdge(3, 1);
        
        System.out.println("Topological Sort for DAG:");
        List<Integer> topoSort = dag.topologicalSort();
        System.out.println("Topological Order: " + topoSort);
    }
} 