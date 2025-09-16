class Solution {

    /**
     * Finds the kth smallest number in a multiplication table of size m x n.
     *
     * @param m The number of rows in the multiplication table.
     * @param n The number of columns in the multiplication table.
     * @param k The kth smallest number to find.
     * @return The value of the kth smallest number in the multiplication table.
     */
    public int findKthNumber(int m, int n, int k) {
        // Initialize the range of possible values for the kth number.
        int left = 1; // The smallest number in the multiplication table.
        int right = m * n; // The largest number in the multiplication table.

        // Perform a binary search to find the kth number.
        while (left < right) {
            // Midpoint of the current search range.
            int mid = left + (right - left) / 2;

            // Counter for the number of elements less than or equal to mid.
            int count = 0;

            // Iterate through each row to count numbers less than or equal to mid.
            for (int i = 1; i <= m; i++) {
                // In row i, since the numbers are i, 2i, 3i, ..., ni,
                // the count of numbers <= mid is min(mid / i, n).
                count += Math.min(mid / i, n);
            }

            // Check if the count of numbers <= mid is at least k.
            if (count >= k) {
                // If there are at least k numbers <= mid, the kth number is
                // in the left half of the search range.
                right = mid;
            } else {
                // If there are fewer than k numbers <= mid, the kth number is
                // in the right half of the search range.
                left = mid + 1;
            }
        }

        // The left pointer converges to the kth smallest number.
        return left;
    }
}
