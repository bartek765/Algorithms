class Solution {
    // Main function to calculate maximum number by combining two arrays with length k
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        int leftBound = Math.max(0, k - n), rightBound = Math.min(k, m);
        int[] result = new int[k];

        // Iterate from the leftBound to the rightBound to find all possible combinations
        for (int i = leftBound; i <= rightBound; ++i) {
            int[] subsequence1 = getMaxSubsequence(nums1, i);
            int[] subsequence2 = getMaxSubsequence(nums2, k - i);
            int[] mergedArray = merge(subsequence1, subsequence2);

            // Check if the current merged array is greater than the result we have
            if (compare(mergedArray, result, 0, 0)) {
                result = mergedArray;
            }
        }
        return result;
    }

    // Helper function to get the maximum subsequence of length k from nums array
    private int[] getMaxSubsequence(int[] nums, int k) {
        int n = nums.length;
        int[] stack = new int[k];
        int top = -1;
        int remaining = n - k;
        for (int num : nums) {
            // If the current element nums is greater than the last element of stack
            // and we have more remaining elements to dispose, pop from stack
            while (top >= 0 && stack[top] < num && remaining > 0) {
                --top;
                --remaining;
            }
            // Push the current element nums to stack if it's not full
            if (top + 1 < k) {
                stack[++top] = num;
            } else {
                --remaining;
            }
        }
        return stack;
    }

    // Merge the two subsequences to a single array in lexicographically maximum order
    private int[] merge(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[] result = new int[m + n];
        int i = 0, j = 0;

        // Merge the two arrays by selecting the larger current head element every time
        for (int k = 0; k < m + n; ++k) {
            if (compare(nums1, nums2, i, j)) {
                result[k] = nums1[i++];
            } else {
                result[k] = nums2[j++];
            }
        }
        return result;
    }

    // Compare two arrays from the given indices to find which array's number is greater
    private boolean compare(int[] nums1, int[] nums2, int i, int j) {
        int m = nums1.length, n = nums2.length;
        // If we have reached the end of nums1, return false
        if (i >= m)
            return false;
        // If we have reached the end of nums2, return true
        if (j >= n)
            return true;
        // Compare the values at the current indices
        if (nums1[i] > nums2[j])
            return true;
        if (nums1[i] < nums2[j])
            return false;
        // If values are the same, recursively compare the next indices
        return compare(nums1, nums2, i + 1, j + 1);
    }
}
