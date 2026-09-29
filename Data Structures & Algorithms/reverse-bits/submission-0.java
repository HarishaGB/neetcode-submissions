class Solution {
    public int reverseBits(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {

            // Get the i-th bit from n
            int bit = (n >> i) & 1;

            // Put that bit at position 31 - i
            result = result | (bit << (31 - i));
        }

        return result;
    }
}
