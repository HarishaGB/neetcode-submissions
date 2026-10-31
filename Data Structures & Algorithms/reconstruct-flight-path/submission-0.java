class Solution {
    List<String> result = new ArrayList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        // Step 1: Build adjacency list
        Map<String, PriorityQueue<String>> graph = new HashMap<>();

        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);

            graph.putIfAbsent(from, new PriorityQueue<>());

            graph.get(from).offer(to);
        }

        // Step 2: Start DFS from JFK
        dfs("JFK", graph);

        // Step 3: Reverse the result
        Collections.reverse(result);

        return result;
    }

    private void dfs(String airport, Map<String, PriorityQueue<String>> graph) {
        // Visit all outgoing flights
        PriorityQueue<String> destinations = graph.get(airport);

        while (destinations != null && !destinations.isEmpty()) {
            // Get lexicographically smallest destination
            String next = destinations.poll();

            // Recursively visit destination
            dfs(next, graph);
        }

        // Add airport AFTER using all outgoing tickets
        result.add(airport);
    }
}
