class Solution {
    public int getSum(int a, int b) {
         while (b != 0) {

            // Calculate carry
            int carry = (a & b) << 1;

            // Calculate sum without carry
            a = a ^ b;

            // Move carry to b
            b = carry;
        }

        return a;
    }
}
