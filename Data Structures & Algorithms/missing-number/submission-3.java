class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;

        int result = 0;

        // XOR all numbers from 0 to n
        for (int i = 0; i <= n; i++) {
            result = result ^ i;
        }

        // XOR all numbers in the array
        for (int num : nums) {
            result = result ^ num;
        }

        return result;
    }
}
