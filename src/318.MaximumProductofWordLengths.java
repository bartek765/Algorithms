class Solution {
    public int maxProduct(String[] words) {
        // Get the length of the words array
        int length = words.length;
        // Create an array to store the bitmask representation of each word
        int[] bitMasks = new int[length];
      
        // Convert each word into a bitmask representation and store it in the bitMasks array
        for (int i = 0; i < length; ++i) {
            for (char c : words[i].toCharArray()) {
                // Set the bit corresponding to the character 'c'
                bitMasks[i] |= (1 << (c - 'a'));
            }
        }
      
        // Initialize the maximum product to 0
        int maxProduct = 0;
      
        // Compare each pair of words to find the pair with the maximum product of lengths
        // where the words do not share any common characters
        for (int i = 0; i < length - 1; ++i) {
            for (int j = i + 1; j < length; ++j) {
                // Check if the two words share any common characters using the '&' bitwise operator
                if ((bitMasks[i] & bitMasks[j]) == 0) {
                    // Calculate the product of the lengths of the two words
                    int product = words[i].length() * words[j].length();
                    // Update maxProduct with the maximum value between the existing maxProduct and the current product
                    maxProduct = Math.max(maxProduct, product);
                }
            }
        }
      
        // Return the maximum product found
        return maxProduct;
    }
}
