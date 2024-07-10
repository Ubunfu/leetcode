package LC323ComponentCountUndirectedGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Counts the number of discrete connected components in an undirected acyclic graph
 */
public class SolutionDFS implements Solution {
    @Override
    public int countComponents(int n, int[][] edges) {
        // Build an adjacency list - this is more memory efficient than a matrix
        Map<Integer, List<Integer>> adjacencyList = buildAdjacencyList(edges);
        System.out.println("Adjacency List: " + adjacencyList);

        // Init a list of visited nodes
        List<Integer> visitedNodes = new ArrayList<>();

        // Init a Set of unvisited nodes
        Set<Integer> unvisitedNodes = adjacencyList.keySet();

        // Init a count of connected components
        // The quantity of isolated (i.e. "neighborless") nodes can be calculated by subtracting
        // the number of nodes discovered while building the adjacency list from the total number
        // of nodes provided as input.  Start counting from there before running DFS to be sure
        // they're accounted for.
        int connectedComponents = n - unvisitedNodes.size();

        // Count connected components by running DFS continuously until we run out of unvisited
        // nodes
        while (!unvisitedNodes.isEmpty()) {
            System.out.println("Starting up DFS...");
            // Start up DFS on a random unvisited node
            dfs(
                    unvisitedNodes.stream().findFirst().get(),
                    visitedNodes,
                    adjacencyList);
            // Remove all visited nodes from the list of unvisited nodes
            visitedNodes.forEach(unvisitedNodes::remove);

            // Record discovery of one new connected component
            connectedComponents++;

            System.out.println("DFS done.  Found connected component #" + connectedComponents);
        }

        // When all nodes have been visited, the number of connected components is known
        return connectedComponents;
    }

    /**
     * Recursive implementation of Depth-First-Search graph traversal.
     *
     * @param startNode
     */
    private void dfs(
            Integer startNode,
            List<Integer> visitedNodes,
            Map<Integer, List<Integer>> adjacencyList) {
        if (visitedNodes.contains(startNode)) {
            System.out.println("Node " + startNode + " has already been visited. Skipping it.");
            return;
        }
        System.out.println("Visiting node " + startNode);
        visitedNodes.add(startNode);
        for (Integer neighbor : adjacencyList.get(startNode)) {
            System.out.println("Searching neighbors of node: " + startNode + ". On neighbor:  " + neighbor);
            dfs(neighbor, visitedNodes, adjacencyList);
        }
    }

    /**
     * Build an adjacency list for the graph, representing all nodes that each node is directly
     * connected to.  The use of a Map (instead of pre-initialized List for example) ensures that
     * the algorithm is robust to graphs with non-sequential node IDs. For example a graph with
     * nodes 1, 3, 5, would work.
     *
     * @param edges
     * @return
     */
    private Map<Integer, List<Integer>> buildAdjacencyList(int[][] edges) {
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        for (int[] edge : edges) {
            int leftVertex = edge[0];
            int rightVertex = edge[1];

            // Add the right node to the left node's neighbors
            List<Integer> adjacentNodes = adjacencyList.getOrDefault(leftVertex, new ArrayList<>());
            adjacentNodes.add(rightVertex);
            adjacencyList.put(leftVertex, adjacentNodes);

            // Add the left node to the right node's neighbors
            adjacentNodes = adjacencyList.getOrDefault(rightVertex, new ArrayList<>());
            adjacentNodes.add(leftVertex);
            adjacencyList.put(rightVertex, adjacentNodes);
        }

        return adjacencyList;
    }
}
