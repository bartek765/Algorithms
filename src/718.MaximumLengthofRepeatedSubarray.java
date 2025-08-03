class Solution {
  
    // Method findLength returns the length of the longest common subarray between two arrays.
    public int findLength(int[] nums1, int[] nums2) {
        // m and n store the lengths of the two input arrays nums1 and nums2 respectively.
        int m = nums1.length;
        int n = nums2.length;
      
        // Create a 2D array 'dp' to store the lengths of common subarrays.
        int[][] dp = new int[m + 1][n + 1];
      
        // Variable 'maxLen' keeps track of the maximum length of common subarrays found so far.
        int maxLen = 0;
      
        // Iterate over the elements of nums1 and nums2.
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                // Check if elements from both arrays match.
                if (nums1[i - 1] == nums2[j - 1]) {
                  
                    // If they match, increment the value from the previous diagonal element by 1.
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                  
                    // Update 'maxLen' if the current length of the common subarray is greater.
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
                // If elements do not match, the length of common subarray is 0 (by default in Java).
            }
        }
      
        // Return the maximum length of common subarray found.
        return maxLen;
    }
}
