package soln

func CountCompleteComponents(n int, edges [][]int) int {
	adjacencyMap := buildAdjacencyMap(edges)
	visitedNodes := map[int]bool{}
	connectedComponents := 0
	for k, _ := range adjacencyMap {
		if visitedNodes[k] {
			continue
		}
		dfs(k, adjacencyMap, visitedNodes)
		connectedComponents++
	}

	// check for nodes without edges
	islandNodes := n - len(visitedNodes)
	connectedComponents += islandNodes

	return connectedComponents
}

func dfs(node int, adjacencyMap map[int][]int, visitedNodes map[int]bool) {
	if visitedNodes[node] {
		return
	}
	visitedNodes[node] = true
	for _, v := range adjacencyMap[node] {
		dfs(v, adjacencyMap, visitedNodes)
	}
}

// iterates through the edges list to build an adjacency map
func buildAdjacencyMap(edges [][]int) map[int][]int {
	adjacencyMap := map[int][]int{}

	for _, v := range edges {
		leftNode := v[0]
		rightNode := v[1]

		// make right node a neighbor of the left node
		leftNodeNeighbors, ok := adjacencyMap[leftNode]
		if !ok {
			adjacencyMap[leftNode] = []int{}
		}
		adjacencyMap[leftNode] = append(leftNodeNeighbors, rightNode)

		// make left node a neighbor of the right node
		rightNodeNeighbors, ok := adjacencyMap[rightNode]
		if !ok {
			adjacencyMap[rightNode] = []int{}
		}
		adjacencyMap[rightNode] = append(rightNodeNeighbors, leftNode)
	}
	return adjacencyMap
}
