import java.util.*;

/**
 * Dijkstra's Shortest Path Algorithm Implementation
 * 
 * Dijkstra's algorithm finds the shortest path from a source vertex to all other vertices
 * in a weighted graph with non-negative edge weights. It's useful for:
 * - GPS navigation systems
 * - Network routing
 * - Social network analysis
 * - Game AI pathfinding
 * - Transportation planning
 */
public class DijkstraShortestPath {
    
    private int vertices;
    private List<List<Edge>> adjacencyList;
    
    /**
     * Edge class to represent weighted edges
     */
    static class Edge {
        int destination;
        int weight;
        
        Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }
    
    /**
     * Node class for priority queue
     */
    static class Node implements Comparable<Node> {
        int vertex;
        int distance;
        
        Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
        
        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }
    
    public DijkstraShortestPath(int vertices) {
        this.vertices = vertices;
        adjacencyList = new ArrayList<>();
        
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }
    
    /**
     * Add a weighted edge to the graph
     */
    public void addEdge(int source, int destination, int weight) {
        adjacencyList.get(source).add(new Edge(destination, weight));
        // For undirected graph, uncomment the next line
        // adjacencyList.get(destination).add(new Edge(source, weight));
    }
    
    /**
     * Dijkstra's algorithm using Priority Queue (Optimized)
     * Time Complexity: O((V + E) log V) where V = vertices, E = edges
     * Space Complexity: O(V) for distances and priority queue
     */
    public int[] dijkstra(int source) {
        // Array to store shortest distances
        int[] distances = new int[vertices];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0;
        
        // Priority queue to get vertex with minimum distance
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(source, 0));
        
        // Set to track processed vertices
        Set<Integer> processed = new HashSet<>();
        
        while (!pq.isEmpty()) {
            // Get vertex with minimum distance
            Node current = pq.poll();
            int currentVertex = current.vertex;
            
            // Skip if already processed
            if (processed.contains(currentVertex)) {
                continue;
            }
            
            // Mark as processed
            processed.add(currentVertex);
            
            // Relax all adjacent edges
            for (Edge edge : adjacencyList.get(currentVertex)) {
                int adjacentVertex = edge.destination;
                int weight = edge.weight;
                
                // If we found a shorter path
                if (distances[currentVertex] != Integer.MAX_VALUE && 
                    distances[currentVertex] + weight < distances[adjacentVertex]) {
                    
                    distances[adjacentVertex] = distances[currentVertex] + weight;
                    pq.add(new Node(adjacentVertex, distances[adjacentVertex]));
                }
            }
        }
        
        return distances;
    }
    
    /**
     * Dijkstra's algorithm with path reconstruction
     * Returns both distances and parent array for path reconstruction
     */
    public Map<String, Object> dijkstraWithPath(int source) {
        int[] distances = new int[vertices];
        int[] parent = new int[vertices];
        Arrays.fill(distances, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        distances[source] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(source, 0));
        Set<Integer> processed = new HashSet<>();
        
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int currentVertex = current.vertex;
            
            if (processed.contains(currentVertex)) {
                continue;
            }
            
            processed.add(currentVertex);
            
            for (Edge edge : adjacencyList.get(currentVertex)) {
                int adjacentVertex = edge.destination;
                int weight = edge.weight;
                
                if (distances[currentVertex] != Integer.MAX_VALUE && 
                    distances[currentVertex] + weight < distances[adjacentVertex]) {
                    
                    distances[adjacentVertex] = distances[currentVertex] + weight;
                    parent[adjacentVertex] = currentVertex;
                    pq.add(new Node(adjacentVertex, distances[adjacentVertex]));
                }
            }
        }
        
        Map<String, Object> result = new HashMap<>();
        result.put("distances", distances);
        result.put("parent", parent);
        return result;
    }
    
    /**
     * Reconstruct shortest path from source to target
     */
    public List<Integer> getShortestPath(int source, int target, int[] parent) {
        List<Integer> path = new ArrayList<>();
        
        if (parent[target] == -1 && source != target) {
            return path; // No path exists
        }
        
        // Reconstruct path from target to source
        int current = target;
        while (current != -1) {
            path.add(0, current);
            current = parent[current];
        }
        
        return path;
    }
    
    /**
     * Dijkstra's algorithm using simple array (Unoptimized)
     * Time Complexity: O(V^2) - useful for dense graphs
     */
    public int[] dijkstraSimple(int source) {
        int[] distances = new int[vertices];
        boolean[] processed = new boolean[vertices];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0;
        
        for (int count = 0; count < vertices - 1; count++) {
            // Find vertex with minimum distance
            int minVertex = -1;
            int minDistance = Integer.MAX_VALUE;
            
            for (int v = 0; v < vertices; v++) {
                if (!processed[v] && distances[v] < minDistance) {
                    minDistance = distances[v];
                    minVertex = v;
                }
            }
            
            if (minVertex == -1) break;
            
            processed[minVertex] = true;
            
            // Relax adjacent edges
            for (Edge edge : adjacencyList.get(minVertex)) {
                int adjacentVertex = edge.destination;
                int weight = edge.weight;
                
                if (!processed[adjacentVertex] && 
                    distances[minVertex] != Integer.MAX_VALUE && 
                    distances[minVertex] + weight < distances[adjacentVertex]) {
                    
                    distances[adjacentVertex] = distances[minVertex] + weight;
                }
            }
        }
        
        return distances;
    }
    
    /**
     * Find shortest path to a specific target vertex
     */
    public int shortestPathToTarget(int source, int target) {
        int[] distances = dijkstra(source);
        return distances[target] == Integer.MAX_VALUE ? -1 : distances[target];
    }
    
    /**
     * Check if graph has negative weights
     */
    public boolean hasNegativeWeights() {
        for (List<Edge> edges : adjacencyList) {
            for (Edge edge : edges) {
                if (edge.weight < 0) {
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * Print shortest distances from source
     */
    public void printShortestDistances(int source) {
        int[] distances = dijkstra(source);
        System.out.println("Shortest distances from vertex " + source + ":");
        for (int i = 0; i < vertices; i++) {
            if (distances[i] == Integer.MAX_VALUE) {
                System.out.println("Vertex " + i + ": INFINITY");
            } else {
                System.out.println("Vertex " + i + ": " + distances[i]);
            }
        }
    }
    
    /**
     * Print all shortest paths from source
     */
    public void printAllShortestPaths(int source) {
        Map<String, Object> result = dijkstraWithPath(source);
        int[] distances = (int[]) result.get("distances");
        int[] parent = (int[]) result.get("parent");
        
        System.out.println("All shortest paths from vertex " + source + ":");
        for (int i = 0; i < vertices; i++) {
            if (i == source) {
                System.out.println("Vertex " + i + ": " + source + " (distance: 0)");
            } else if (distances[i] == Integer.MAX_VALUE) {
                System.out.println("Vertex " + i + ": No path exists");
            } else {
                List<Integer> path = getShortestPath(source, i, parent);
                System.out.println("Vertex " + i + ": " + path + " (distance: " + distances[i] + ")");
            }
        }
    }
    
    /**
     * Print the adjacency list representation of the graph
     */
    public void printGraph() {
        System.out.println("Graph Representation (Adjacency List with Weights):");
        for (int i = 0; i < vertices; i++) {
            System.out.print("Vertex " + i + " -> ");
            for (Edge edge : adjacencyList.get(i)) {
                System.out.print("(" + edge.destination + ", " + edge.weight + ") ");
            }
            System.out.println();
        }
    }
    
    // Main method for testing
    public static void main(String[] args) {
        // Create a graph with 6 vertices
        DijkstraShortestPath graph = new DijkstraShortestPath(6);
        
        // Add weighted edges
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 2);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 5);
        graph.addEdge(2, 3, 8);
        graph.addEdge(2, 4, 10);
        graph.addEdge(3, 4, 2);
        graph.addEdge(3, 5, 6);
        graph.addEdge(4, 5, 3);
        
        // Print graph
        graph.printGraph();
        System.out.println();
        
        // Check for negative weights
        System.out.println("Graph has negative weights: " + graph.hasNegativeWeights());
        System.out.println();
        
        // Print shortest distances
        graph.printShortestDistances(0);
        System.out.println();
        
        // Print all shortest paths
        graph.printAllShortestPaths(0);
        System.out.println();
        
        // Test specific path
        int shortestDistance = graph.shortestPathToTarget(0, 5);
        System.out.println("Shortest distance from 0 to 5: " + shortestDistance);
        System.out.println();
        
        // Compare optimized vs simple implementation
        int source = 0;
        int[] optimizedDistances = graph.dijkstra(source);
        int[] simpleDistances = graph.dijkstraSimple(source);
        
        System.out.println("Comparing optimized vs simple implementation:");
        for (int i = 0; i < graph.vertices; i++) {
            System.out.println("Vertex " + i + ": Optimized=" + optimizedDistances[i] + 
                             ", Simple=" + simpleDistances[i]);
        }
    }
} 