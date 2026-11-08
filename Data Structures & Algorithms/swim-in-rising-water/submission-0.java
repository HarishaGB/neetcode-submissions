class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;

        // Minimum possible maximum elevation to reach each cell
        int[][] dist = new int[n][n];

        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // Min-Heap: {maximum elevation, row, col}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        // Four directions: up, down, left, right
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // Starting cell
        dist[0][0] = grid[0][0];

        pq.offer(new int[] {grid[0][0], 0, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();

            int time = current[0];
            int row = current[1];
            int col = current[2];

            // Ignore outdated entries
            if (time > dist[row][col]) {
                continue;
            }

            // Destination reached
            if (row == n - 1 && col == n - 1) {
                return time;
            }

            // Explore four directions
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                // Check grid boundaries
                if (newRow < 0 || newRow >= n || newCol < 0 || newCol >= n) {
                    continue;
                }

                // Maximum elevation along the new path
                int newTime = Math.max(time, grid[newRow][newCol]);

                // Update if we found a better path
                if (newTime < dist[newRow][newCol]) {
                    dist[newRow][newCol] = newTime;

                    pq.offer(new int[] {newTime, newRow, newCol});
                }
            }
        }

        return -1;
    }
}
