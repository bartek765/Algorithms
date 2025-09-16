class Solution {
    // f stores the computed results to avoid repetitive calculations (memoization)
    private int[][][] memo;
    // boxes is the array representing the input boxes
    private int[] boxes;

    public int removeBoxes(int[] boxes) {
        this.boxes = boxes;
        int n = boxes.length;
        memo = new int[n][n][n]; // Initialised with default value 0
        return dfs(0, n - 1, 0); // Start the depth-first search from the whole range
    }

    /**
     * Depth-first search function to find the maximum points possible.
     *
     * @param start - the starting index of the range of boxes considered
     * @param end - the ending index of the range of boxes considered
     * @param consecutive - the number of boxes of the same color consecutive to boxes[end]
     * @return the maximum points achievable for the subproblem
     */
    private int dfs(int start, int end, int consecutive) {
        if (start > end) {
            return 0; // Base case: no boxes left to remove
        }

        // Optimization: Group all boxes of the same color as boxes[end].
        while (start < end && boxes[end] == boxes[end - 1]) {
            --end;
            ++consecutive;
        }

        // Check for memoized result to avoid recalculating
        if (memo[start][end][consecutive] > 0) {
            return memo[start][end][consecutive];
        }

        // Calculate score for removing all boxes of the same color as boxes[end]
        int maxPoints = dfs(start, end - 1, 0) + (consecutive + 1) * (consecutive + 1);

        // Try to increase the score by finding a box with the same color earlier in the array
        for (int i = start; i < end; ++i) {
            if (boxes[i] == boxes[end]) {
                int points = 
                    dfs(i + 1, end - 1, 0) +  // Points after removing boxes between i and end
                    dfs(start, i, consecutive + 1); // Points from the current segment including i
                maxPoints = Math.max(maxPoints, points);
            }
        }

        // Store the maximum points in the memo array for future reference
        memo[start][end][consecutive] = maxPoints;
        return maxPoints;
    }
}
