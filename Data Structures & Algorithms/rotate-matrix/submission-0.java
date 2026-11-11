class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // Step 1: Reverse the matrix vertically
        for (int i = 0; i < n / 2; i++) {
            int[] temp = matrix[i];

            matrix[i] = matrix[n - 1 - i];

            matrix[n - 1 - i] = temp;
        }

        // Step 2: Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];

                matrix[i][j] = matrix[j][i];

                matrix[j][i] = temp;
            }
        }
    }
}
