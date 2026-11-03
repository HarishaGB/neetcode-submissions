class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // Step 1: Sort by starting time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 2: Initialize variables
        int count = 0;
        int prevEnd = intervals[0][1];

        // Step 3: Traverse from second interval
        for (int i = 1; i < intervals.length; i++) {
            // Check if current interval overlaps
            if (intervals[i][0] < prevEnd) {
                // Remove the interval that ends later
                count++;

                // Keep the interval that ends earlier
                prevEnd = Math.min(prevEnd, intervals[i][1]);

            } else {
                // No overlap, keep current interval
                prevEnd = intervals[i][1];
            }
        }

        return count;
    }
}
