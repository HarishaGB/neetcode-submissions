class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        // 1. Put all treasure cells into the queue
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 0) {
                    queue.offer(new int[] {r, c});
                }
            }
        }

        // Directions: up, down, left, right
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // 2. BFS
        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int r = current[0];
            int c = current[1];

            // Check four neighbors
            for (int[] direction : directions) {
                int nr = r + direction[0];
                int nc = c + direction[1];

                // Check boundaries
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                    continue;
                }

                // Only process unvisited land
                if (grid[nr][nc] == Integer.MAX_VALUE) {
                    grid[nr][nc] = grid[r][c] + 1;

                    queue.offer(new int[] {nr, nc});
                }
            }
        }
    }
}
