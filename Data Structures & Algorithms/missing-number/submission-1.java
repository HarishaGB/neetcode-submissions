class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;

        int result = n;

        for (int i = 0; i < n; i++) {
            result = result ^ i;
            result = result ^ nums[i];
        }

        return result;
    }
}
