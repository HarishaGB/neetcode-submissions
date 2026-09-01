class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int count = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                // Found a new island
                if (grid[row][col] == '1') {
                    count++;

                    // Visit the complete island
                    dfs(grid, row, col);
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int row, int col) {
        // Boundary check
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length
            || grid[row][col] == '0') {
            return;
        }

        // Mark as visited
        grid[row][col] = '0';

        // Explore all 4 directions
        dfs(grid, row - 1, col); // up
        dfs(grid, row + 1, col); // down
        dfs(grid, row, col - 1); // left
        dfs(grid, row, col + 1); // right
    }
}
