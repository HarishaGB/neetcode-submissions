class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        int fresh = 0;

        // Find all rotten fruits and count fresh fruits
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    fresh++;
                }
            }
        }

        int minutes = 0;

        int[][] directions = {
            {-1, 0},  // up
            {1, 0},   // down
            {0, -1},  // left
            {0, 1}    // right
        };

        // BFS
        while (!queue.isEmpty() && fresh > 0) {

            int size = queue.size();

            // Process all rotten fruits from the current minute
            for (int i = 0; i < size; i++) {

                int[] current = queue.poll();

                int r = current[0];
                int c = current[1];

                for (int[] direction : directions) {

                    int nr = r + direction[0];
                    int nc = c + direction[1];

                    // Check boundaries
                    if (nr < 0 || nr >= rows ||
                        nc < 0 || nc >= cols) {
                        continue;
                    }

                    // Only fresh fruits can become rotten
                    if (grid[nr][nc] != 1) {
                        continue;
                    }

                    // Make it rotten
                    grid[nr][nc] = 2;

                    // One less fresh fruit
                    fresh--;

                    // Add newly rotten fruit to queue
                    queue.offer(new int[]{nr, nc});
                }
            }

            // One minute has passed
            minutes++;
        }

        // If fresh fruits remain, they cannot be reached
        if (fresh > 0) {
            return -1;
        }

        return minutes;
    }
}
