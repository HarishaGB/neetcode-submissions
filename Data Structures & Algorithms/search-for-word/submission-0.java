class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (dfs(board, word, r, c, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int index) {
        // Base case: all characters matched
        if (index == word.length()) {
            return true;
        }

        // Check boundaries
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length) {
            return false;
        }

        // Character mismatch or already visited
        if (board[r][c] != word.charAt(index)) {
            return false;
        }

        // Mark the current cell as visited
        char original = board[r][c];
        board[r][c] = '#';

        // Explore up, down, left, and right
        boolean found = dfs(board, word, r - 1, c, index + 1)
            || dfs(board, word, r + 1, c, index + 1) || dfs(board, word, r, c - 1, index + 1)
            || dfs(board, word, r, c + 1, index + 1);

        // Backtrack: restore the original character
        board[r][c] = original;

        return found;
    }
}
