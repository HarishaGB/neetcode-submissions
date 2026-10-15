class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
         List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        backtrack(0, nums, target, current, result);

        return result;
    }

    private void backtrack(
            int index,
            int[] nums,
            int remaining,
            List<Integer> current,
            List<List<Integer>> result) {

        // Base case: target reached
        if (remaining == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        // No more numbers to consider
        if (index == nums.length) {
            return;
        }

        // Choice 1: Include nums[index], if it fits
        if (nums[index] <= remaining) {
            current.add(nums[index]);

            // Stay at the same index because reuse is allowed
            backtrack(index, nums, remaining - nums[index],
                      current, result);

            // Undo the choice
            current.remove(current.size() - 1);
        }

        // Choice 2: Skip nums[index]
        backtrack(index + 1, nums, remaining,
                  current, result);
    }
}
