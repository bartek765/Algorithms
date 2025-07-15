class Solution {
    // Recursive method that rearranges a special binary string to create the largest possible string.
    public String makeLargestSpecial(String s) {
        // Base case: If the string is empty, return an empty string.
        if (s.isEmpty()) {
            return "";
        }

        // A list to hold special strings during the processing.
        List<String> specialStrings = new ArrayList<>();
        int count = 0; // Counter to check the number of '1's and '0's.

        // Loop through the string to identify special substrings.
        for (int start = 0, end = 0; end < s.length(); ++end) {
            // Increment counter for '1', decrement for '0'.
            count += s.charAt(end) == '1' ? 1 : -1;

            // When the count is zero, we found a balanced part of the special string.
            if (count == 0) {
                // Recursively process the inside of this special substring 
                // and add "1" at the beginning and "0" at the end.
                String inner = makeLargestSpecial(s.substring(start + 1, end));
                specialStrings.add("1" + inner + "0");

                // Set the start to the next character after the current special substring.
                start = end + 1;
            }
        }

        // Sort the processed special strings in reverse order to make the largest string.
        specialStrings.sort(Comparator.reverseOrder());

        // Join all sorted special substrings into one string and return it.
        return String.join("", specialStrings);
    }
}
