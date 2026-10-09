class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean xFound = false;
        boolean yFound = false;
        boolean zFound = false;

        for (int[] triplet : triplets) {

            // Ignore triplets that exceed the target
            if (triplet[0] > target[0] ||
                triplet[1] > target[1] ||
                triplet[2] > target[2]) {
                continue;
            }

            // This triplet can safely be used

            if (triplet[0] == target[0]) {
                xFound = true;
            }

            if (triplet[1] == target[1]) {
                yFound = true;
            }

            if (triplet[2] == target[2]) {
                zFound = true;
            }
        }

        return xFound && yFound && zFound;
    }
}
