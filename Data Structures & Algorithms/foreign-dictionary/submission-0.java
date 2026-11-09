class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> adj = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        // Step 1: Add all unique characters
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                adj.putIfAbsent(ch, new HashSet<>());
                indegree.putIfAbsent(ch, 0);
            }
        }

        // Step 2: Build graph by comparing adjacent words
        for (int i = 0; i < words.length - 1; i++) {
            String first = words[i];
            String second = words[i + 1];

            int minLength = Math.min(first.length(), second.length());

            int j = 0;

            while (j < minLength && first.charAt(j) == second.charAt(j)) {
                j++;
            }

            // Invalid prefix case: "abc" comes before "ab"
            if (j == minLength) {
                if (first.length() > second.length()) {
                    return "";
                }
                continue;
            }

            char from = first.charAt(j);
            char to = second.charAt(j);

            // Avoid duplicate edges
            if (adj.get(from).add(to)) {
                indegree.put(to, indegree.get(to) + 1);
            }
        }

        // Step 3: Add all zero-indegree characters to queue
        Queue<Character> queue = new LinkedList<>();

        for (char ch : indegree.keySet()) {
            if (indegree.get(ch) == 0) {
                queue.offer(ch);
            }
        }

        // Step 4: Perform BFS
        StringBuilder result = new StringBuilder();

        while (!queue.isEmpty()) {
            char current = queue.poll();
            result.append(current);

            for (char neighbor : adj.get(current)) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);

                if (indegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // Step 5: Check for cycle
        if (result.length() != indegree.size()) {
            return "";
        }

        return result.toString();
    }
}
