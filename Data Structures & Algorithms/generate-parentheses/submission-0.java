class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder current, int open, int close, int n) {
        // Base case: we have built a complete string
        if (current.length() == 2 * n) {
            result.add(current.toString());
            return;
        }

        // Choice 1: Add an opening bracket
        if (open < n) {
            current.append('(');

            backtrack(result, current, open + 1, close, n);

            // Backtrack: remove the last character
            current.deleteCharAt(current.length() - 1);
        }

        // Choice 2: Add a closing bracket
        if (close < open) {
            current.append(')');

            backtrack(result, current, open, close + 1, n);

            // Backtrack: remove the last character
            current.deleteCharAt(current.length() - 1);
        }
    }
}
