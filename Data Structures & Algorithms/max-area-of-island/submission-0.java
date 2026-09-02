class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                // Found a new island
                if (grid[row][col] == 1) {
                    int area = dfs(grid, row, col);

                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, int row, int col) {
        // Outside grid or water
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length
            || grid[row][col] == 0) {
            return 0;
        }

        // Mark as visited
        grid[row][col] = 0;

        // Count current cell + all connected cells
        return 1 + dfs(grid, row - 1, col) // up
            + dfs(grid, row + 1, col) // down
            + dfs(grid, row, col - 1) // left
            + dfs(grid, row, col + 1); // right
    }
}
