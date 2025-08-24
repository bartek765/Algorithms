class Solution {
    // This method returns an array that contains the number of days you would 
    // have to wait until a warmer temperature for each day represented in 'temperatures'.
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length; // Total number of days
        int[] result = new int[n]; // Initialize the result array with the same length as temperatures
        Deque<Integer> stack = new ArrayDeque<>(); // Use a stack to keep track of indices
      
        // Iterate through each day in temperatures
        for (int currentIndex = 0; currentIndex < n; ++currentIndex) {
            // While the stack is not empty and the current temperature is greater 
            // than the temperature at the top index of the stack
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[currentIndex]) {
                int prevIndex = stack.pop(); // Get the index from the top of the stack
                result[prevIndex] = currentIndex - prevIndex; // Calculate the number of days and update result
            }
            // Push current index onto the stack
            stack.push(currentIndex);
        }
        // At the end, result array contains the answer
        return result;
    }
}
