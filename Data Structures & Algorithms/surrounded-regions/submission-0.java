class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        // 1. Process top and bottom rows
        for (int c = 0; c < cols; c++) {
            // Top row
            if (board[0][c] == 'O') {
                dfs(board, 0, c);
            }

            // Bottom row
            if (board[rows - 1][c] == 'O') {
                dfs(board, rows - 1, c);
            }
        }

        // 2. Process left and right columns
        for (int r = 0; r < rows; r++) {
            // Left column
            if (board[r][0] == 'O') {
                dfs(board, r, 0);
            }

            // Right column
            if (board[r][cols - 1] == 'O') {
                dfs(board, r, cols - 1);
            }
        }

        // 3. Capture surrounded regions
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == 'O') {
                    // Surrounded O → capture
                    board[r][c] = 'X';

                } else if (board[r][c] == '#') {
                    // Safe O → restore
                    board[r][c] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int r, int c) {
        // Boundary check
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length) {
            return;
        }

        // Stop if not O
        if (board[r][c] != 'O') {
            return;
        }

        // Mark as safe
        board[r][c] = '#';

        // Explore four directions
        dfs(board, r - 1, c); // up
        dfs(board, r + 1, c); // down
        dfs(board, r, c - 1); // left
        dfs(board, r, c + 1); // right
    }
}
