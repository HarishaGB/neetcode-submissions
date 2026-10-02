class Solution {
    public int reverse(int x) {
          int res = 0;

        while (x != 0) {

            // Get the last digit
            int digit = x % 10;

            // Check for positive overflow
            if (res > Integer.MAX_VALUE / 10 ||
                (res == Integer.MAX_VALUE / 10 &&
                 digit > Integer.MAX_VALUE % 10)) {
                return 0;
            }

            // Check for negative overflow
            if (res < Integer.MIN_VALUE / 10 ||
                (res == Integer.MIN_VALUE / 10 &&
                 digit < Integer.MIN_VALUE % 10)) {
                return 0;
            }

            // Add digit to reversed number
            res = res * 10 + digit;

            // Remove last digit from x
            x = x / 10;
        }

        return res;
    }
}
