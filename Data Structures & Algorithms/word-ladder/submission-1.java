class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // If endWord is not present, transformation is impossible
        if (!wordList.contains(endWord)) {
            return 0;
        }

        // Pattern -> list of words
        Map<String, List<String>> patternMap = new HashMap<>();

        int wordLength = beginWord.length();

        // Build pattern map
        for (String word : wordList) {
            for (int i = 0; i < wordLength; i++) {
                String pattern = word.substring(0, i) + "*" + word.substring(i + 1);

                patternMap.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
            }
        }

        // BFS
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String current = queue.poll();

                // Reached destination
                if (current.equals(endWord)) {
                    return level;
                }

                // Generate patterns
                for (int j = 0; j < wordLength; j++) {
                    String pattern = current.substring(0, j) + "*" + current.substring(j + 1);

                    // Find all words connected to this pattern
                    for (String neighbor :
                        patternMap.getOrDefault(pattern, Collections.emptyList())) {
                        if (!visited.contains(neighbor)) {
                            visited.add(neighbor);
                            queue.offer(neighbor);
                        }
                    }
                }
            }

            level++;
        }

        return 0;
    }
}
