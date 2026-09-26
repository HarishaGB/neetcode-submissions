class Solution {
    int[] parent;
    int[] size;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        parent = new int[n + 1];
        size = new int[n + 1];

        // Initially, every node is its own parent.
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        // Process every edge
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];

            // If they are already connected,
            // this edge creates a cycle.
            if (!union(a, b)) {
                return edge;
            }
        }

        return new int[0];
    }

    // Find the root/representative of a node
    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    // Connect two components
    private boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        // Already in the same component
        if (rootA == rootB) {
            return false;
        }

        // Union by size
        if (size[rootA] < size[rootB]) {
            int temp = rootA;
            rootA = rootB;
            rootB = temp;
        }

        parent[rootB] = rootA;
        size[rootA] += size[rootB];

        return true;
    }
}
