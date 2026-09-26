class Solution {
    private int[] parent;
    private int[] size;
    public int countComponents(int n, int[][] edges) {
        parent = new int[n];
        size = new int[n];

        // Initially every node is its own component.
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        int components = n;

        // Process every edge
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];

            // If successfully connected,
            // two components became one.
            if (union(a, b)) {
                components--;
            }
        }

        return components;
    }

    // Find the root of a node
    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    // Try to connect two components
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

        // Attach smaller component to larger component
        parent[rootB] = rootA;

        size[rootA] += size[rootB];

        return true;
    }
}
