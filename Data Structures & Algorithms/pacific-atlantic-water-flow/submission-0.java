class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
         int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        // Pacific: top row
        for (int c = 0; c < cols; c++) {
            dfs(heights, pacific, 0, c);
        }

        // Pacific: left column
        for (int r = 0; r < rows; r++) {
            dfs(heights, pacific, r, 0);
        }

        // Atlantic: bottom row
        for (int c = 0; c < cols; c++) {
            dfs(heights, atlantic, rows - 1, c);
        }

        // Atlantic: right column
        for (int r = 0; r < rows; r++) {
            dfs(heights, atlantic, r, cols - 1);
        }

        List<List<Integer>> result = new ArrayList<>();

        // Find cells reachable from both oceans
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    private void dfs(
            int[][] heights,
            boolean[][] ocean,
            int r,
            int c) {

        // Already visited
        if (ocean[r][c]) {
            return;
        }

        ocean[r][c] = true;

        int[][] directions = {
            {-1, 0},  // up
            {1, 0},   // down
            {0, -1},  // left
            {0, 1}    // right
        };

        for (int[] direction : directions) {

            int nr = r + direction[0];
            int nc = c + direction[1];

            // Check boundaries
            if (nr < 0 || nr >= heights.length ||
                nc < 0 || nc >= heights[0].length) {
                continue;
            }

            // Reverse flow:
            // We can move from current cell to a
            // neighbor that is HIGHER or EQUAL.
            if (heights[nr][nc] < heights[r][c]) {
                continue;
            }

            dfs(heights, ocean, nr, nc);
        }
    }
}
