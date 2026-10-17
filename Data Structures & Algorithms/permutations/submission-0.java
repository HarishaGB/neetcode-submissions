class Solution {
    public List<List<Integer>> permute(int[] nums) {
         List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        backtrack(nums, current, used, result);

        return result;
    }

    private void backtrack(
            int[] nums,
            List<Integer> current,
            boolean[] used,
            List<List<Integer>> result) {

        // Base case: permutation is complete
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Try every available element
        for (int i = 0; i < nums.length; i++) {

            // Skip elements already used
            if (used[i]) {
                continue;
            }

            // Choose the element
            current.add(nums[i]);
            used[i] = true;

            // Explore the next position
            backtrack(nums, current, used, result);

            // Backtrack: undo the choice
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}
