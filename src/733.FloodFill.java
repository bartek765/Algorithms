class Solution {
 
    // Direction vectors representing the 4 connected pixels (up, right, down, left).
    private int[] directions = {-1, 0, 1, 0, -1};
    // The image we need to modify.
    private int[][] image;
    // The new color to apply to the flood fill.
    private int newColor;
    // The original color to be replaced.
    private int originalColor;

    // Method to begin flood fill operation
    public int[][] floodFill(int[][] image, int startRow, int startColumn, int color) {
        // Initialize the image, new color, and original color based on the input.
        this.image = image;
        this.newColor = color;
        this.originalColor = image[startRow][startColumn];
      
        // Call the recursive dfs method starting from the pixel at (sr, sc)
        dfs(startRow, startColumn);
        // Return the modified image after the flood fill operation.
        return image;
    }

    // Depth-first search (DFS) method to apply new color to connected components.
    private void dfs(int row, int column) {
        // Boundary check: if the pixel is out of bounds or isn't the original color or is already the new color, return.
        if (row < 0 || row >= image.length || column < 0 || column >= image[0].length || 
            image[row][column] != originalColor || image[row][column] == newColor) {
            return;
        }
      
        // Change the color of the current pixel to the new color.
        image[row][column] = newColor;
      
        // Iterate through each of the 4 connected neighbors.
        for (int k = 0; k < 4; ++k) {
            // Recursively call dfs for the current neighbor.
            dfs(row + directions[k], column + directions[k + 1]);
        }
    }
}
