# Dijkstra's Shortest Path Algorithm Tutorial

## Overview

Dijkstra's algorithm is a classic algorithm for finding the shortest path from a source vertex to all other vertices in a weighted graph with non-negative edge weights. It is widely used in navigation, network routing, and many real-world applications.

## Key Concepts

### 1. How Dijkstra's Algorithm Works
- **Greedy Approach**: Always selects the vertex with the smallest known distance
- **Priority Queue**: Efficiently retrieves the next vertex to process
- **Relaxation**: Updates the shortest distance to each neighbor if a shorter path is found

### 2. Algorithm Steps
1. Set the distance to the source as 0 and all others as infinity
2. Add the source to a priority queue
3. While the queue is not empty:
   - Remove the vertex with the smallest distance
   - For each neighbor, update its distance if a shorter path is found
   - Add updated neighbors to the queue
4. Repeat until all vertices are processed

## Implementation Details

### Data Structures Used
- **Adjacency List**: `List<List<Edge>>` for graph representation
- **Priority Queue**: For efficient minimum distance retrieval
- **Distance Array**: `int[]` for shortest distances
- **Parent Array**: `int[]` for path reconstruction

### Time and Space Complexity
- **Time Complexity**: O((V + E) log V) with a priority queue
- **Space Complexity**: O(V + E) for graph and queue

## Key Methods

### 1. Dijkstra's Algorithm (Optimized)
```java
public int[] dijkstra(int source)
```
- Finds shortest distances from source to all vertices
- Uses a priority queue for efficiency

### 2. Dijkstra's Algorithm with Path Reconstruction
```java
public Map<String, Object> dijkstraWithPath(int source)
```
- Returns both distances and parent array for reconstructing paths

### 3. Get Shortest Path
```java
public List<Integer> getShortestPath(int source, int target, int[] parent)
```
- Reconstructs the shortest path from source to target

### 4. Dijkstra's Algorithm (Simple)
```java
public int[] dijkstraSimple(int source)
```
- Uses a simple array, O(V^2) time, for dense graphs

### 5. Print Shortest Distances and Paths
```java
public void printShortestDistances(int source)
public void printAllShortestPaths(int source)
```
- Prints distances and paths from source to all vertices

## Applications

- **GPS Navigation**: Finding shortest driving routes
- **Network Routing**: Determining optimal data paths
- **Game AI**: Pathfinding for characters
- **Social Networks**: Finding degrees of separation
- **Logistics**: Planning delivery routes

## Example Usage

```java
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

// Print shortest distances
graph.printShortestDistances(0);

// Print all shortest paths
graph.printAllShortestPaths(0);
```

## Sample Output

```
Graph Representation (Adjacency List with Weights):
Vertex 0 -> (1, 4) (2, 2) 
Vertex 1 -> (2, 1) (3, 5) 
Vertex 2 -> (3, 8) (4, 10) 
Vertex 3 -> (4, 2) (5, 6) 
Vertex 4 -> (5, 3) 
Vertex 5 -> 

Shortest distances from vertex 0:
Vertex 0: 0
Vertex 1: 3
Vertex 2: 2
Vertex 3: 8
Vertex 4: 10
Vertex 5: 13

All shortest paths from vertex 0:
Vertex 0: 0 (distance: 0)
Vertex 1: [0, 2, 1] (distance: 3)
Vertex 2: [0, 2] (distance: 2)
Vertex 3: [0, 2, 1, 3] (distance: 8)
Vertex 4: [0, 2, 1, 3, 4] (distance: 10)
Vertex 5: [0, 2, 1, 3, 4, 5] (distance: 13)
```

## Advantages and Disadvantages

### Advantages
- ✅ Guarantees shortest path in graphs with non-negative weights
- ✅ Efficient with priority queue
- ✅ Works for both sparse and dense graphs (with different implementations)

### Disadvantages
- ❌ Does not work with negative edge weights
- ❌ More complex than BFS/DFS
- ❌ Slower than BFS for unweighted graphs

## Practice Problems

1. **Network Delay Time**: Find time for all nodes to receive a signal
2. **Cheapest Flights Within K Stops**: Find cheapest route with constraints
3. **Path With Minimum Effort**: Find path minimizing maximum edge weight
4. **The Maze II**: Find shortest path in a rolling ball maze
5. **Reachable Nodes In Subdivided Graph**: Advanced pathfinding

## Tips and Tricks

1. **Priority Queue**: Always use for efficiency
2. **Edge Cases**: Check for negative weights (use Bellman-Ford if needed)
3. **Path Reconstruction**: Use parent array to reconstruct paths
4. **Dense Graphs**: Use simple array version for small, dense graphs
5. **Disconnected Graphs**: Handle unreachable nodes (distance = infinity)

## Related Algorithms

- **Bellman-Ford**: Handles negative weights
- **A* Search**: Informed search for pathfinding
- **Floyd-Warshall**: All-pairs shortest paths
- **Breadth-First Search (BFS)**: For unweighted graphs

## Conclusion

Dijkstra's algorithm is a powerful and efficient method for finding shortest paths in weighted graphs. It is essential for many real-world applications and is a must-know for interviews and algorithmic problem solving. The provided implementation covers both optimized and simple versions, as well as path reconstruction for practical use. 