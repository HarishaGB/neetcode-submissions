class Solution {
    public int lastStoneWeight(int[] stones) {
        // Max Heap: largest element comes first
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Add all stones to the heap
        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        // Smash the two heaviest stones
        while (maxHeap.size() > 1) {
            int first = maxHeap.poll();
            int second = maxHeap.poll();

            // If weights differ, add the remaining weight
            if (first != second) {
                maxHeap.offer(first - second);
            }
        }

        // Return the last stone, or 0 if none remain
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}
