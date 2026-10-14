class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        backtrack(0, nums, current, result);

        return result;
    }

    private void backtrack(
            int index,
            int[] nums,
            List<Integer> current,
            List<List<Integer>> result) {

        // Base case: all elements have been processed
        if (index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Choice 1: Include nums[index]
        current.add(nums[index]);
        backtrack(index + 1, nums, current, result);

        // Backtrack: remove the last added element
        current.remove(current.size() - 1);

        // Choice 2: Exclude nums[index]
        backtrack(index + 1, nums, current, result);
    }
}
