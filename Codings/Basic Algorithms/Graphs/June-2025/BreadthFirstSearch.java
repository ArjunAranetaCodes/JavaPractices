import java.util.*;

/**
 * Breadth-First Search (BFS) Algorithm Implementation
 * 
 * BFS is a graph traversal algorithm that explores all vertices at the current depth
 * before moving on to vertices at the next depth level. It's useful for:
 * - Finding shortest path in unweighted graphs
 * - Level-order traversal
 * - Web crawling
 * - GPS navigation systems
 * - Social network connections
 */
public class BreadthFirstSearch {
    
    private int vertices;
    private LinkedList<Integer>[] adjacencyList;
    
    @SuppressWarnings("unchecked")
    public BreadthFirstSearch(int vertices) {
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
     * Basic BFS traversal starting from a given vertex
     * Time Complexity: O(V + E) where V is vertices and E is edges
     * Space Complexity: O(V) for the queue
     */
    public void bfs(int startVertex) {
        // Array to track visited vertices
        boolean[] visited = new boolean[vertices];
        
        // Queue for BFS
        Queue<Integer> queue = new LinkedList<>();
        
        // Mark start vertex as visited and enqueue it
        visited[startVertex] = true;
        queue.add(startVertex);
        
        System.out.println("BFS Traversal starting from vertex " + startVertex + ":");
        
        while (!queue.isEmpty()) {
            // Dequeue a vertex and print it
            int currentVertex = queue.poll();
            System.out.print(currentVertex + " ");
            
            // Get all adjacent vertices
            for (int adjacent : adjacencyList[currentVertex]) {
                if (!visited[adjacent]) {
                    visited[adjacent] = true;
                    queue.add(adjacent);
                }
            }
        }
        System.out.println();
    }
    
    /**
     * BFS with level tracking
     * Returns the level of each vertex from the start vertex
     */
    public Map<Integer, Integer> bfsWithLevels(int startVertex) {
        boolean[] visited = new boolean[vertices];
        Map<Integer, Integer> levels = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        
        visited[startVertex] = true;
        levels.put(startVertex, 0);
        queue.add(startVertex);
        
        System.out.println("BFS with Levels starting from vertex " + startVertex + ":");
        
        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            int currentLevel = levels.get(currentVertex);
            
            System.out.println("Vertex " + currentVertex + " at level " + currentLevel);
            
            for (int adjacent : adjacencyList[currentVertex]) {
                if (!visited[adjacent]) {
                    visited[adjacent] = true;
                    levels.put(adjacent, currentLevel + 1);
                    queue.add(adjacent);
                }
            }
        }
        
        return levels;
    }
    
    /**
     * Find shortest path from start to target using BFS
     * Returns the path as a list of vertices
     */
    public List<Integer> findShortestPath(int startVertex, int targetVertex) {
        boolean[] visited = new boolean[vertices];
        int[] parent = new int[vertices];
        Arrays.fill(parent, -1);
        
        Queue<Integer> queue = new LinkedList<>();
        visited[startVertex] = true;
        queue.add(startVertex);
        
        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            
            if (currentVertex == targetVertex) {
                // Reconstruct path
                return reconstructPath(parent, startVertex, targetVertex);
            }
            
            for (int adjacent : adjacencyList[currentVertex]) {
                if (!visited[adjacent]) {
                    visited[adjacent] = true;
                    parent[adjacent] = currentVertex;
                    queue.add(adjacent);
                }
            }
        }
        
        // No path found
        return new ArrayList<>();
    }
    
    /**
     * Reconstruct path from parent array
     */
    private List<Integer> reconstructPath(int[] parent, int start, int target) {
        List<Integer> path = new ArrayList<>();
        int current = target;
        
        while (current != -1) {
            path.add(0, current);
            current = parent[current];
        }
        
        return path;
    }
    
    /**
     * Check if graph is bipartite using BFS
     * A graph is bipartite if it can be colored with 2 colors
     */
    public boolean isBipartite() {
        int[] color = new int[vertices];
        Arrays.fill(color, -1);
        
        for (int start = 0; start < vertices; start++) {
            if (color[start] == -1) {
                if (!isBipartiteUtil(start, color)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean isBipartiteUtil(int start, int[] color) {
        Queue<Integer> queue = new LinkedList<>();
        color[start] = 0;
        queue.add(start);
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            for (int adjacent : adjacencyList[current]) {
                if (color[adjacent] == -1) {
                    color[adjacent] = 1 - color[current];
                    queue.add(adjacent);
                } else if (color[adjacent] == color[current]) {
                    return false;
                }
            }
        }
        return true;
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
        BreadthFirstSearch graph = new BreadthFirstSearch(6);
        
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
        
        // Basic BFS
        graph.bfs(0);
        System.out.println();
        
        // BFS with levels
        Map<Integer, Integer> levels = graph.bfsWithLevels(0);
        System.out.println();
        
        // Find shortest path
        List<Integer> shortestPath = graph.findShortestPath(0, 5);
        System.out.println("Shortest path from 0 to 5: " + shortestPath);
        System.out.println("Path length: " + (shortestPath.size() - 1));
        System.out.println();
        
        // Check if bipartite
        System.out.println("Is the graph bipartite? " + graph.isBipartite());
    }
} 