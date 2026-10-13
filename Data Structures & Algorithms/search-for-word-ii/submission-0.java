class Solution {
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null;
    }

    private final TrieNode root = new TrieNode();
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();

        // Step 1: Insert all words into the Trie
        for (String word : words) {
            insert(word);
        }

        // Step 2: Start DFS from every cell
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, result);
            }
        }

        return result;
    }

    private void insert(String word) {
        TrieNode current = root;

        for (char ch : word.toCharArray()) {
            int index = ch - 'a';

            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }

            current = current.children[index];
        }

        current.word = word;
    }

    private void dfs(char[][] board, int row, int col, TrieNode node, List<String> result) {
        // Out of bounds or already visited
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length
            || board[row][col] == '#') {
            return;
        }

        char ch = board[row][col];
        int index = ch - 'a';

        // No matching Trie prefix: prune this path
        TrieNode child = node.children[index];

        if (child == null) {
            return;
        }

        // Found a complete word
        if (child.word != null) {
            result.add(child.word);

            // Prevent duplicate results
            child.word = null;
        }

        // Mark this cell as visited
        board[row][col] = '#';

        // Explore up, down, left and right
        dfs(board, row - 1, col, child, result);
        dfs(board, row + 1, col, child, result);
        dfs(board, row, col - 1, child, result);
        dfs(board, row, col + 1, child, result);

        // Backtrack: restore the original character
        board[row][col] = ch;

        // Remove exhausted Trie branches to speed up future searches
        if (child.word == null && hasNoChildren(child)) {
            node.children[index] = null;
        }
    }

    private boolean hasNoChildren(TrieNode node) {
        for (TrieNode child : node.children) {
            if (child != null) {
                return false;
            }
        }

        return true;
    }
}
