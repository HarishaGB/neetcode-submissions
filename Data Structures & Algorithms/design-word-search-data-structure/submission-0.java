class WordDictionary {
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    private final TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
         TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';

            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }

            current = current.children[index];
        }

        current.isEnd = true;
    }

    public boolean search(String word) {
         return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, TrieNode node) {

        // All characters have been matched
        if (index == word.length()) {
            return node.isEnd;
        }

        char ch = word.charAt(index);

        // Dot can match any existing child
        if (ch == '.') {
            for (TrieNode child : node.children) {
                if (child != null && dfs(word, index + 1, child)) {
                    return true;
                }
            }

            return false;
        }

        // Normal character: follow only the matching child
        int childIndex = ch - 'a';
        TrieNode child = node.children[childIndex];

        if (child == null) {
            return false;
        }

        return dfs(word, index + 1, child);
    }
}
