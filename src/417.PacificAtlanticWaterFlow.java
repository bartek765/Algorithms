class Solution {
    private int[][] heightsMatrix;
    private int height;
    private int width;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // dimensions of the input matrix
        height = heights.length;
        width = heights[0].length;
        this.heightsMatrix = heights;

        // queues for BFS from Pacific and Atlantic oceans
        Deque<int[]> pacificQueue = new LinkedList<>();
        Deque<int[]> atlanticQueue = new LinkedList<>();

        // visited sets for Pacific and Atlantic oceans
        Set<Integer> visitedPacific = new HashSet<>();
        Set<Integer> visitedAtlantic = new HashSet<>();

        // start from the edges of the matrix for both the oceans
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                if (i == 0 || j == 0) {  // Pacific Ocean's edge
                    visitedPacific.add(i * width + j);
                    pacificQueue.offer(new int[]{i, j});
                }
                if (i == height - 1 || j == width - 1) {  // Atlantic Ocean's edge
                    visitedAtlantic.add(i * width + j);
                    atlanticQueue.offer(new int[]{i, j});
                }
            }
        }

        // perform a BFS for each ocean to find all cells reachable from each ocean
        bfs(pacificQueue, visitedPacific);
        bfs(atlanticQueue, visitedAtlantic);

        // results list for cells that can reach both oceans
        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                int cellIndex = i * width + j;
                // if a cell is reachable from both Pacific and Atlantic, add it to results
                if (visitedPacific.contains(cellIndex) && visitedAtlantic.contains(cellIndex)) {
                    results.add(Arrays.asList(i, j));
                }
            }
        }

        return results;
    }

    private void bfs(Deque<int[]> queue, Set<Integer> visited) {
        int[] directions = {-1, 0, 1, 0, -1};  // representational array for traversing neighbors

        while (!queue.isEmpty()) {
            // explore all the current level's nodes
            for (int k = queue.size(); k > 0; --k) {
                int[] cell = queue.poll();
                // traverse all 4 directions (up, right, down, left)
                for (int i = 0; i < 4; ++i) {
                    int newRow = cell[0] + directions[i];
                    int newCol = cell[1] + directions[i + 1];
                    // check for valid coordinates and if the cell is not already visited
                    if (newRow >= 0 && newRow < height && newCol >= 0 && newCol < width 
                        && !visited.contains(newRow * width + newCol)
                        && heightsMatrix[newRow][newCol] >= heightsMatrix[cell[0]][cell[1]]) {
                            // if criteria are met, add the cell to visited and queue for further BFS
                            visited.add(newRow * width + newCol);
                            queue.offer(new int[]{newRow, newCol});
                    }
                }
            }
        }
    }
}
