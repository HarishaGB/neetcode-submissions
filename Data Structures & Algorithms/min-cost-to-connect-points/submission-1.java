class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        // Minimum cost required to connect each point
        int[] minDist = new int[n];

        // Whether a point is already connected
        boolean[] visited = new boolean[n];

        // Initially, all distances are infinity
        Arrays.fill(minDist, Integer.MAX_VALUE);

        // Start from point 0
        minDist[0] = 0;

        long totalCost = 0;

        // We need to connect all n points
        for (int i = 0; i < n; i++) {
            int current = -1;

            // Find the unvisited point with minimum cost
            for (int j = 0; j < n; j++) {
                if (!visited[j] && (current == -1 || minDist[j] < minDist[current])) {
                    current = j;
                }
            }

            // Connect this point
            visited[current] = true;

            totalCost += minDist[current];

            // Update distances of remaining points
            for (int j = 0; j < n; j++) {
                if (!visited[j]) {
                    int distance = Math.abs(points[current][0] - points[j][0])
                        + Math.abs(points[current][1] - points[j][1]);

                    minDist[j] = Math.min(minDist[j], distance);
                }
            }
        }

        return (int) totalCost;
    }
}
