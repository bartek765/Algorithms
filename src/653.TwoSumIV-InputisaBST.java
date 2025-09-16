class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {} // Default constructor
    TreeNode(int val) { this.val = val; } // Constructor with node value
    TreeNode(int val, TreeNode left, TreeNode right) { // Constructor with node value and children
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    // A HashSet to keep track of the values we've visited
    private Set<Integer> visited = new HashSet<>();
    private int targetSum;

    // Public method to find if the tree has two elements such that their sum equals k
    public boolean findTarget(TreeNode root, int k) {
        this.targetSum = k;
        return dfs(root);
    }

    // Helper method that uses depth-first search to find if the property is satisfied
    private boolean dfs(TreeNode node) {
        if (node == null) {
            return false; // Base case: if the node is null, return false
        }
        if (visited.contains(targetSum - node.val)) {
            // If the complementary value is in 'visited', we found two numbers that add up to 'k'
            return true;
        }
        visited.add(node.val); // Add current node's value to the set
        // Recurse on left and right subtrees; return true if any subtree returns true
        return dfs(node.left) || dfs(node.right);
    }
}
