class Solution {
    public boolean validTree(int n, int[][] edges) {
        // A tree with n nodes must have exactly n - 1 edges
        if (edges.length != n - 1) {
            return false;
        }

        // Build adjacency list
        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];

            graph[a].add(b);
            graph[b].add(a);
        }

        boolean[] visited = new boolean[n];

        // Start DFS from node 0
        if (!dfs(0, -1, graph, visited)) {
            return false;
        }

        // Every node must be visited
        for (boolean nodeVisited : visited) {
            if (!nodeVisited) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int node, int parent, List<Integer>[] graph, boolean[] visited) {
        // Already visited → cycle
        if (visited[node]) {
            return false;
        }

        visited[node] = true;

        for (int neighbor : graph[node]) {
            // Ignore the edge we came from
            if (neighbor == parent) {
                continue;
            }

            if (!dfs(neighbor, node, graph, visited)) {
                return false;
            }
        }

        return true;
    }
}
