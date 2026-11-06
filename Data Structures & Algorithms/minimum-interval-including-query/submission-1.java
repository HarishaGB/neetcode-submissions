class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
         int n = intervals.length;
        int m = queries.length;

        // Sort intervals by starting point
        Arrays.sort(intervals, (a, b) ->
            Integer.compare(a[0], b[0])
        );

        // Store queries with their original indexes
        int[][] sortedQueries = new int[m][2];

        for (int i = 0; i < m; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }

        // Sort queries in ascending order
        Arrays.sort(sortedQueries, (a, b) ->
            Integer.compare(a[0], b[0])
        );

        // Min Heap: [interval length, interval end]
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        int[] result = new int[m];

        int i = 0;

        // Process queries in sorted order
        for (int[] query : sortedQueries) {

            int q = query[0];
            int originalIndex = query[1];

            // Add all intervals starting before or at query
            while (i < n && intervals[i][0] <= q) {

                int start = intervals[i][0];
                int end = intervals[i][1];

                int length = end - start + 1;

                minHeap.offer(new int[]{length, end});

                i++;
            }

            // Remove intervals that have already ended
            while (!minHeap.isEmpty() &&
                   minHeap.peek()[1] < q) {

                minHeap.poll();
            }

            // Get the smallest valid interval
            if (!minHeap.isEmpty()) {
                result[originalIndex] = minHeap.peek()[0];
            } else {
                result[originalIndex] = -1;
            }
        }

        return result;
    }
}
