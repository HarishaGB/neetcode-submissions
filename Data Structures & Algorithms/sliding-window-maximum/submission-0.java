class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];

        Deque<Integer> deque = new ArrayDeque<>();

        int left = 0;
        int right = 0;
        int resultIndex = 0;

        while (right < n) {
            // Remove smaller elements from the back
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[right]) {
                deque.pollLast();
            }

            // Add right pointer
            deque.offerLast(right);

            // Window size
            if (right - left + 1 == k) {
                // Front contains maximum
                result[resultIndex++] = nums[deque.peekFirst()];

                // If left element is at deque front, remove it
                if (!deque.isEmpty() && deque.peekFirst() == left) {
                    deque.pollFirst();
                }

                // Move left pointer
                left++;
            }

            // Move right pointer
            right++;
        }

        return result;
    }
}
