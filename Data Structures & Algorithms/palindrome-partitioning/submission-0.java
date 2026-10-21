class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> current = new ArrayList<>();

        backtrack(s, 0, current, result);

        return result;
    }

    private void backtrack(String s, int start, List<String> current, List<List<String>> result) {
        // Base case: the entire string has been partitioned
        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Try every possible ending position
        for (int end = start; end < s.length(); end++) {
            // Only choose palindromic substrings
            if (isPalindrome(s, start, end)) {
                String substring = s.substring(start, end + 1);
                current.add(substring);

                // Explore the remaining string
                backtrack(s, end + 1, current, result);

                // Backtrack: remove the last chosen substring
                current.remove(current.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
