class Solution {
    public int[] countBits(int n) {
        //Using  In-Built Function
         int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            res[i] = Integer.bitCount(i);
        }
        return res;
    }
}
