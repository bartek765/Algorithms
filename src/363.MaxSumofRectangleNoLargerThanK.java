class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        final int infinity = Integer.MAX_VALUE;
        int maxSum = -infinity;
        // Iterating over the starting row for submatrix
        for (int startRow = 0; startRow < rows; ++startRow) {
            int[] columnSums = new int[cols];
            // Extending the submatrix to each possible end row
            for (int endRow = startRow; endRow < rows; ++endRow) {
                // Summing up each column element of the current submatrix
                for (int col = 0; col < cols; ++col) {
                    columnSums[col] += matrix[endRow][col];
                }
                int currentSum = 0;
                TreeSet<Integer> set = new TreeSet<>();
                // Adding a base to consider subarrays starting from the first element
                set.add(0);
                // Traversing the cumulative column sums to find the submatrix with the sum closest to k
                for (int sum : columnSums) {
                    currentSum += sum;
                    // Checking if there is a prefix sum that, if removed, leaves a sum close to k
                    Integer minSum = set.ceiling(currentSum - k);
                    if (minSum != null) {
                        maxSum = Math.max(maxSum, currentSum - minSum);
                    }
                    set.add(currentSum);
                }
            }
        }
        return maxSum;
    }
}
