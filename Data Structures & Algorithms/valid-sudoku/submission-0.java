class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows = new HashSet[9];

        // 9 sets for columns
        Set<Character>[] cols = new HashSet[9];

        // 9 sets for 3x3 boxes
        Set<Character>[] boxes = new HashSet[9];

        // Create HashSets
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        // Visit every cell
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char num = board[row][col];

                // Ignore empty cell
                if (num == '.') {
                    continue;
                }

                // Find which 3x3 box this cell belongs to
                int boxIndex = (row / 3) * 3 + (col / 3);

                // Check duplicate
                if (rows[row].contains(num) || cols[col].contains(num)
                    || boxes[boxIndex].contains(num)) {
                    return false;
                }

                // Add number
                rows[row].add(num);
                cols[col].add(num);
                boxes[boxIndex].add(num);
            }
        }

        return true;
    }
}
