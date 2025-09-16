class Solution {
    public int[] shortestToChar(String s, char targetChar) {
        // Get the length of the string to create and fill the output array
        int strLength = s.length();
        int[] shortestDistances = new int[strLength];

        // The variable 'inf' represents an effective infinity for our purposes
        final int inf = 1 << 30; // 2^30 is much greater than the maximum possible string length
        Arrays.fill(shortestDistances, inf); // Fill the array with 'infinite' distance initially

        // First pass: move from left to right,
        // updating the closest target character seen so far
        for (int i = 0, closestLeft = -inf; i < strLength; ++i) {
            // Update the position of the closest target character if found
            if (s.charAt(i) == targetChar) {
                closestLeft = i;
            }
            // Update the shortest distance for position i
            shortestDistances[i] = i - closestLeft;
        }

        // Second pass: move from right to left,
        // updating the closest target character seen so far
        for (int i = strLength - 1, closestRight = inf; i >= 0; --i) {
            // Update the position of the closest target character if found
            if (s.charAt(i) == targetChar) {
                closestRight = i;
            }
            // Update the shortest distance for position i only if it's smaller than the current value
            shortestDistances[i] = Math.min(shortestDistances[i], closestRight - i);
        }

        // Return the array of shortest distances to the target character
        return shortestDistances;
    }
}
