class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        char[][] board = new char[n][n];

        // Initially, every cell is empty
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                board[r][c] = '.';
            }
        }

        boolean[] cols = new boolean[n];

        // Diagonal indices range from 0 to 2*n - 2
        boolean[] diag1 = new boolean[2 * n - 1]; // row - col + n - 1
        boolean[] diag2 = new boolean[2 * n - 1]; // row + col

        backtrack(0, n, board, cols, diag1, diag2, result);

        return result;
    }

    private void backtrack(int row, int n, char[][] board, boolean[] cols, boolean[] diag1,
        boolean[] diag2, List<List<String>> result) {
        // Base case: all n queens have been placed
        if (row == n) {
            List<String> solution = new ArrayList<>();

            for (char[] boardRow : board) {
                solution.add(new String(boardRow));
            }

            result.add(solution);
            return;
        }

        // Try every column in this row
        for (int col = 0; col < n; col++) {
            int d1 = row - col + n - 1;
            int d2 = row + col;

            // Skip positions attacked by existing queens
            if (cols[col] || diag1[d1] || diag2[d2]) {
                continue;
            }

            // Choose: place the queen
            board[row][col] = 'Q';
            cols[col] = true;
            diag1[d1] = true;
            diag2[d2] = true;

            // Explore: move to the next row
            backtrack(row + 1, n, board, cols, diag1, diag2, result);

            // Undo: remove the queen
            board[row][col] = '.';
            cols[col] = false;
            diag1[d1] = false;
            diag2[d2] = false;
        }
    }
}
