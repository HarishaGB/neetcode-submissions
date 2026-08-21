class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Always binary search on the smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int left = 0;
        int right = m;

        int half = (m + n + 1) / 2;

        while (left <= right) {
            // Number of elements taken from nums1
            int partitionA = left + (right - left) / 2;

            // Remaining elements must come from nums2
            int partitionB = half - partitionA;

            // Boundary values for nums1
            int leftA = (partitionA == 0) ? Integer.MIN_VALUE : nums1[partitionA - 1];

            int rightA = (partitionA == m) ? Integer.MAX_VALUE : nums1[partitionA];

            // Boundary values for nums2
            int leftB = (partitionB == 0) ? Integer.MIN_VALUE : nums2[partitionB - 1];

            int rightB = (partitionB == n) ? Integer.MAX_VALUE : nums2[partitionB];

            // Correct partition
            if (leftA <= rightB && leftB <= rightA) {
                // Odd number of elements
                if ((m + n) % 2 == 1) {
                    return Math.max(leftA, leftB);
                }

                // Even number of elements
                return (Math.max(leftA, leftB) + Math.min(rightA, rightB)) / 2.0;
            }

            // We took too many elements from nums1
            else if (leftA > rightB) {
                right = partitionA - 1;
            }

            // We took too few elements from nums1
            else {
                left = partitionA + 1;
            }
        }

        return 0.0;
    }
}
