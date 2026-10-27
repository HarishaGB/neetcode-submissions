class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Min Heap: smallest element is at the top
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            // Add the current element
            minHeap.offer(num);

            // Keep only the k largest elements
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // The smallest of the k largest elements is kth largest
        return minHeap.peek();
    }
}
