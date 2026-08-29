class Solution {
    public int findDuplicate(int[] nums) {
        // Phase 1: Find intersection point inside the cycle
        int slow = 0;
        int fast = 0;

        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];

            if (slow == fast) {
                break;
            }
        }

        // Phase 2: Find the entrance of the cycle
        int slow2 = 0;

        while (slow != slow2) {
            slow = nums[slow];
            slow2 = nums[slow2];
        }

        return slow;
    }
}
