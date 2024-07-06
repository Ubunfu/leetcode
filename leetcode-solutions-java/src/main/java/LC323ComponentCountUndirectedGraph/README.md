# 323. Number of Connected Components in an Undirected Graph

Given an undirected graph, your task is to find the number of connected components in the graph.
Definition:

    Undirected Graph: A graph in which edges have no direction. The edges indicate a two-way relationship.
    Connected Component: A subset of the graph where there is a path between any two vertices in the subset, and 
    which is connected to no additional vertices in the supergraph.

Input:
1. An integer number of nodes (n) in the graph
2. A two-dimensional array of edges, where each edge is a tuple of the two nodes connected by the edge. 

Output:

    The number of connected components in the graph.

Example:

Input:

```java
int n = 5;
int[][] edges = {{0,1}, {1,2}, {3, 4}};
```

Graph Representation:

```
0 - 1 - 2
3 - 4
```

Output:

```
2
```
