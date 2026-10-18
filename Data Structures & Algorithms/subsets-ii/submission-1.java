class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        Arrays.sort(nums);

        backtrack(0, nums, current, result);

        return result;
    }

    private void backtrack(
        int start, int[] nums, List<Integer> current, List<List<Integer>> result) {
        // Every current combination is a valid subset
        result.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {
            // Skip duplicates at the same recursion level
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            // Choose the current element
            current.add(nums[i]);

            // Move forward: each array position is considered once
            backtrack(i + 1, nums, current, result);

            // Backtrack: undo the choice
            current.remove(current.size() - 1);
        }
    }
}
