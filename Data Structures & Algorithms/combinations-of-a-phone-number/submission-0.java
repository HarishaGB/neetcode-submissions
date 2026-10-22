class Solution {
    private static final String[] keypad = {
        "", // 0
        "", // 1
        "abc", // 2
        "def", // 3
        "ghi", // 4
        "jkl", // 5
        "mno", // 6
        "pqrs", // 7
        "tuv", // 8
        "wxyz" // 9
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits == null || digits.isEmpty()) {
            return result;
        }

        backtrack(digits, 0, new StringBuilder(), result);

        return result;
    }

    private void backtrack(String digits, int index, StringBuilder current, List<String> result) {
        // Base case: all digits have been processed
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // Get letters for the current digit
        String letters = keypad[digits.charAt(index) - '0'];

        // Try every letter for this digit
        for (int i = 0; i < letters.length(); i++) {
            // Choose
            current.append(letters.charAt(i));

            // Explore the next digit
            backtrack(digits, index + 1, current, result);

            // Undo the choice
            current.deleteCharAt(current.length() - 1);
        }
    }
}
