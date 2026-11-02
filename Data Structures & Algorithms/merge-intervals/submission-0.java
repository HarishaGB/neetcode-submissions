class Solution {
    public int[][] merge(int[][] intervals) {
        // Step 1: Sort by starting value
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 2: Create result list
        List<int[]> result = new ArrayList<>();

        // Step 3: Traverse all intervals
        for (int[] current : intervals) {
            // If result is empty OR no overlap
            if (result.isEmpty() || current[0] > result.get(result.size() - 1)[1]) {
                result.add(new int[] {current[0], current[1]});

            } else {
                // Merge overlapping intervals
                int[] previous = result.get(result.size() - 1);

                previous[1] = Math.max(previous[1], current[1]);
            }
        }

        // Step 4: Convert List to 2D array
        return result.toArray(new int[result.size()][]);
    }
}
