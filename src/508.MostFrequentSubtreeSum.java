class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    // A map to keep track of the sum occurrences.
    private Map<Integer, Integer> sumFrequency;
  
    // A variable to keep track of the maximum frequency of the sum.
    private int maxFrequency;

    // Method to find the tree sums that appear most frequently.
    public int[] findFrequentTreeSum(TreeNode root) {
        sumFrequency = new HashMap<>();
        maxFrequency = Integer.MIN_VALUE;
      
        // Recursively find all subtree sums.
        calculateSubtreeSum(root);
      
        // Store the sums that have the highest frequency.
        List<Integer> frequentSums = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : sumFrequency.entrySet()) {
            if (entry.getValue() == maxFrequency) {
                frequentSums.add(entry.getKey());
            }
        }
      
        // Convert the result to an array.
        int[] result = new int[frequentSums.size()];
        for (int i = 0; i < frequentSums.size(); i++) {
            result[i] = frequentSums.get(i);
        }
      
        return result;
    }

    // Helper method to perform a depth-first search and calculate subtree sums.
    private int calculateSubtreeSum(TreeNode node) {
        // If the node is null, return sum as 0.
        if (node == null) {
            return 0;
        }
      
        // Calculate the sum including the current node and its left and right subtrees.
        int sum = node.val + calculateSubtreeSum(node.left) + calculateSubtreeSum(node.right);
      
        // Update the frequency of the sum in the map.
        sumFrequency.put(sum, sumFrequency.getOrDefault(sum, 0) + 1);
      
        // Update the maximum frequency if necessary.
        maxFrequency = Math.max(maxFrequency, sumFrequency.get(sum));
      
        // Return the sum of the subtree rooted at the current node.
        return sum;
    }
}
