# Topological Sort Algorithm Tutorial

## Overview

Topological sort is an ordering of vertices in a Directed Acyclic Graph (DAG) such that for every directed edge u → v, vertex u comes before v in the ordering. It is essential for scheduling tasks, resolving dependencies, and more.

## Key Concepts

### 1. When to Use Topological Sort
- **Task Scheduling**: Order tasks with dependencies
- **Build Systems**: Compile order for source files
- **Course Prerequisites**: Order to take courses
- **Dependency Resolution**: Package managers, project builds

### 2. Algorithm Approaches
- **Kahn's Algorithm (BFS-based)**: Uses in-degree and queue
- **DFS-based**: Uses recursion and stack

## Implementation Details

### Data Structures Used
- **Adjacency List**: `List<List<Integer>>` for graph representation
- **Queue**: For Kahn's algorithm
- **Stack**: For DFS-based approach
- **In-degree Array**: For Kahn's algorithm

### Time and Space Complexity
- **Time Complexity**: O(V + E)
- **Space Complexity**: O(V + E)

## Key Methods

### 1. Kahn's Algorithm (BFS-based)
```java
public List<Integer> kahnTopologicalSort()
```
- Uses in-degree and queue
- Detects cycles (if not all vertices are processed)

### 2. DFS-based Topological Sort
```java
public List<Integer> dfsTopologicalSort()
```
- Uses recursion and stack
- Pushes vertices to stack after visiting all descendants

### 3. Cycle Detection
```java
public boolean hasCycle()
```
- Checks for cycles in the graph
- Topological sort is only possible if the graph is acyclic

## Applications

- **Task Scheduling**: Project management, build systems
- **Course Scheduling**: University course prerequisites
- **Dependency Resolution**: Package managers (npm, pip)
- **Instruction Scheduling**: Compilers

## Example Usage

```java
TopologicalSort graph = new TopologicalSort(6);
graph.addEdge(5, 2);
graph.addEdge(5, 0);
graph.addEdge(4, 0);
graph.addEdge(4, 1);
graph.addEdge(2, 3);
graph.addEdge(3, 1);

System.out.println(graph.kahnTopologicalSort());
System.out.println(graph.dfsTopologicalSort());
System.out.println(graph.hasCycle());
```

## Sample Output

```
Kahn's Algorithm Topological Sort:
[4, 5, 2, 0, 3, 1]
DFS-based Topological Sort:
[4, 5, 2, 3, 1, 0]
Graph has cycle: false
```

## Advantages and Disadvantages

### Advantages
- ✅ Efficient for DAGs
- ✅ Detects cycles
- ✅ Multiple valid orderings possible

### Disadvantages
- ❌ Only works for DAGs
- ❌ Not unique (multiple valid orders)

## Practice Problems

1. **Course Schedule II**: Find order to finish courses
2. **Alien Dictionary**: Find order of characters
3. **Build Order**: Find build order for projects
4. **Task Scheduling**: Order tasks with dependencies

## Tips and Tricks

1. **Cycle Detection**: Always check for cycles before sorting
2. **Multiple Orders**: There may be more than one valid order
3. **Use Cases**: Use for any dependency resolution problem

## Related Algorithms

- **DFS**: Used for DFS-based topological sort
- **Kahn's Algorithm**: BFS-based approach
- **Strongly Connected Components**: For cycle detection

## Conclusion

Topological sort is a fundamental algorithm for ordering tasks with dependencies. It is widely used in scheduling, build systems, and dependency resolution. Understanding both Kahn's and DFS-based approaches is essential for interviews and real-world applications. 