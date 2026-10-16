class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        Arrays.sort(candidates);

        backtrack(0, target, candidates, current, result);

        return result;
    }

    private void backtrack(int start, int remaining, int[] candidates, List<Integer> current,
        List<List<Integer>> result) {
        // Target reached: save this combination
        if (remaining == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // Skip duplicates at the same recursion level
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // Because the array is sorted, later values
            // will also be too large
            if (candidates[i] > remaining) {
                break;
            }

            // Choose the current element
            current.add(candidates[i]);

            // i + 1 ensures each array element is used once
            backtrack(i + 1, remaining - candidates[i], candidates, current, result);

            // Undo the choice
            current.remove(current.size() - 1);
        }
    }
}
