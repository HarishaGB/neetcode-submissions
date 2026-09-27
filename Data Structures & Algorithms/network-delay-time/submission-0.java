class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
         // Create adjacency list
        List<int[]>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<int[]>();
        }

        // Build graph
        for (int[] time : times) {

            int source = time[0];
            int destination = time[1];
            int weight = time[2];

            graph[source].add(new int[]{destination, weight});
        }

        // Distance from source k to every node
        int[] dist = new int[n + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        // Source has distance 0
        dist[k] = 0;

        // Min-heap
        // int[]{node, distance}
        PriorityQueue<int[]> pq =
                new PriorityQueue<int[]>(new Comparator<int[]>() {
                    public int compare(int[] a, int[] b) {
                        return a[1] - b[1];
                    }
                });

        pq.offer(new int[]{k, 0});

        while (!pq.isEmpty()) {

            int[] current = pq.poll();

            int node = current[0];
            int currentDistance = current[1];

            // Ignore outdated heap entry
            if (currentDistance > dist[node]) {
                continue;
            }

            // Explore neighbors
            for (int[] neighbor : graph[node]) {

                int nextNode = neighbor[0];
                int weight = neighbor[1];

                int newDistance = currentDistance + weight;

                // Found a shorter path
                if (newDistance < dist[nextNode]) {

                    dist[nextNode] = newDistance;

                    pq.offer(new int[]{
                        nextNode,
                        newDistance
                    });
                }
            }
        }

        // Find the maximum shortest distance
        int answer = 0;

        for (int i = 1; i <= n; i++) {

            // Some node cannot be reached
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }

            answer = Math.max(answer, dist[i]);
        }

        return answer;
    }
}
