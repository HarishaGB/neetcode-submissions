class Solution {
    public boolean hasDuplicate(int[] nums) {
          //using streams
       return Arrays.stream(nums).distinct().count() < nums.length;
    }
}