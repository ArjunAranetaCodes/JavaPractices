# Kruskal's Minimum Spanning Tree (MST) Algorithm Tutorial

## Overview

Kruskal's algorithm finds the minimum spanning tree (MST) in a weighted undirected graph. The MST is a subset of edges that connects all vertices with the minimum total edge weight and no cycles.

## Key Concepts

### 1. When to Use Kruskal's Algorithm
- **Network Design**: Laying cables, pipelines, or roads
- **Clustering**: Grouping data points
- **Circuit Design**: Connecting components with minimum wire
- **Approximation Algorithms**: For NP-hard problems

### 2. Algorithm Steps
1. Sort all edges by weight
2. Initialize each vertex as its own set (union-find)
3. For each edge in sorted order:
   - If the edge connects two different sets, add it to the MST
   - Union the sets
   - Stop when MST has (V-1) edges

## Implementation Details

### Data Structures Used
- **Edge List**: Stores all edges
- **Union-Find**: For cycle detection and set management
- **Parent Array**: For union-find

### Time and Space Complexity
- **Time Complexity**: O(E log E) (for sorting edges)
- **Space Complexity**: O(V + E)

## Key Methods

### 1. Add Edge
```java
public void addEdge(int source, int destination, int weight)
```
- Adds an undirected weighted edge

### 2. Find MST
```java
public List<Edge> findMST()
```
- Returns the list of edges in the MST
- Uses union-find for cycle detection

## Applications

- **Network Design**: Connecting computers, cities, or routers
- **Clustering**: Grouping similar data points
- **Circuit Design**: Connecting components efficiently
- **Road/Railway Construction**: Minimizing construction cost

## Example Usage

```java
KruskalMST graph = new KruskalMST(6);
graph.addEdge(0, 1, 4);
graph.addEdge(0, 2, 4);
graph.addEdge(1, 2, 2);
graph.addEdge(2, 3, 3);
graph.addEdge(2, 5, 2);
graph.addEdge(2, 4, 4);
graph.addEdge(3, 4, 3);
graph.addEdge(5, 4, 3);

List<KruskalMST.Edge> mst = graph.findMST();
```

## Sample Output

```
Edges in MST:
1 - 2 : 2
2 - 5 : 2
2 - 3 : 3
3 - 4 : 3
0 - 1 : 4
Total weight of MST: 14
```

## Advantages and Disadvantages

### Advantages
- ✅ Simple and intuitive
- ✅ Works well for sparse graphs
- ✅ Easy to implement with edge list

### Disadvantages
- ❌ Not efficient for dense graphs (use Prim's for adjacency matrix)
- ❌ Requires sorting all edges

## Practice Problems

1. **Minimum Cost to Connect All Points**
2. **Optimize Water Distribution in a Village**
3. **Connecting Cities With Minimum Cost**
4. **Network Connection**

## Tips and Tricks

1. **Union-Find**: Use path compression for efficiency
2. **Edge Sorting**: Use built-in sort for edge list
3. **Cycle Detection**: Only add edges connecting different sets
4. **Stop Early**: MST has exactly (V-1) edges

## Related Algorithms

- **Prim's Algorithm**: Another MST algorithm (better for dense graphs)
- **Boruvka's Algorithm**: Parallel MST algorithm
- **Union-Find**: Disjoint set data structure

## Conclusion

Kruskal's algorithm is a fundamental algorithm for finding minimum spanning trees. It is widely used in network design, clustering, and many optimization problems. Understanding Kruskal's and its union-find structure is essential for interviews and real-world applications. 