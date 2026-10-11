class Solution {
    public boolean checkValidString(String s) {
        int low = 0;
        int high = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                low++;
                high++;
            } else if (ch == ')') {
                low--;
                high--;
            } else { // ch == '*'
                low--;
                high++;
            }

            // Even the most favorable interpretation fails
            if (high < 0) {
                return false;
            }

            // We cannot have fewer than zero open parentheses
            low = Math.max(low, 0);
        }

        // Zero unmatched opening parentheses must be possible
        return low == 0;
    }
}
