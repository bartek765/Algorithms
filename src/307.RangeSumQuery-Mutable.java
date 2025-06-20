class BinaryIndexedTree {
    private int size; // size of array that Binary Indexed Tree maintains
    private int[] tree; // internal representation of Binary Indexed Tree

    // Constructor initializes the tree with the given size
    public BinaryIndexedTree(int size) {
        this.size = size;
        this.tree = new int[size + 1]; // +1 because indexing starts from 1
    }

    // Updates the tree with the provided value `delta` at index `x`
    public void update(int x, int delta) {
        while (x <= size) {
            tree[x] += delta; // update current index
            x += lowbit(x); // move to the next index to update
        }
    }

    // Query the sum of the array up to index `x`
    public int query(int x) {
        int sum = 0;
        while (x > 0) {
            sum += tree[x]; // add current index value to sum
            x -= lowbit(x); // move to previous index to continue the sum
        }
        return sum;
    }

    // Helper method to calculate lowest one bit (rightmost) of `x`
    private static int lowbit(int x) {
        return x & -x; // isolates the lowest one bit
    }
}

// Class to support range sum queries and updates
class NumArray {
    private BinaryIndexedTree binaryIndexedTree;

    // Constructor builds a Binary Indexed Tree using provided input array
    public NumArray(int[] nums) {
        binaryIndexedTree = new BinaryIndexedTree(nums.length);
        for (int i = 0; i < nums.length; ++i) {
            binaryIndexedTree.update(i + 1, nums[i]); // populate Binary Indexed Tree with initial values
        }
    }

    // Updates the value at the given index with the new value `val`
    public void update(int index, int val) {
        int currentValue = sumRange(index, index); // get current value at the index
        binaryIndexedTree.update(index + 1, val - currentValue); // apply the difference
    }

    // Computes the sum of the elements within the range [left, right]
    public int sumRange(int left, int right) {
        // Get the prefix sum up to 'right' and subtract the sum up to 'left'
        // to obtain the sum of range [left, right]
        return binaryIndexedTree.query(right + 1) - binaryIndexedTree.query(left);
    }
}
