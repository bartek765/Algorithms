class Solution {
    // DIRECTIONS array used to explore in four direct neighboring positions (up, right, down, left)
    private static final int[] DIRECTIONS = {-1, 0, 1, 0, -1};
    private List<Integer> wallCount = new ArrayList<>();
    private List<List<Integer>> infectedAreas = new ArrayList<>();
    private List<Set<Integer>> areaBoundaries = new ArrayList<>();
    private int[][] isInfected;
    private boolean[][] visited;
    private int rowCount;
    private int colCount;

    public int containVirus(int[][] isInfected) {
        this.isInfected = isInfected;
        this.rowCount = isInfected.length;
        this.colCount = isInfected[0].length;
        this.visited = new boolean[rowCount][colCount];
        int wallsRequired = 0;

        while (true) {
            // Resetting visited for the new iteration
            for (boolean[] row : visited) {
                Arrays.fill(row, false);
            }
            wallCount.clear();
            infectedAreas.clear();
            areaBoundaries.clear();

            // Iterate over each cell in the grid
            for (int i = 0; i < rowCount; ++i) {
                for (int j = 0; j < colCount; ++j) {
                    // for each unvisited infected cell start a new exploration
                    if (isInfected[i][j] == 1 && !visited[i][j]) {
                        wallCount.add(0);
                        infectedAreas.add(new ArrayList<>());
                        areaBoundaries.add(new HashSet<>());
                        deepFirstSearch(i, j);
                    }
                }
            }

            // If no areas are infected, break the loop as no further action is required
            if (infectedAreas.isEmpty()) {
                break;
            }

            // Choose the most threatening area (one that affects most uninfected cells)
            int mostThreatIndex = getMaxBoundaryIndex();
            // Add the wall count for the most threatening area to the answer
            wallsRequired += wallCount.get(mostThreatIndex);

            // Process each infected area
            for (int index = 0; index < infectedAreas.size(); ++index) {
                if (index == mostThreatIndex) {
                    // For the most threatening area, add walls (mark as -1)
                    for (int infectedCell : infectedAreas.get(index)) {
                        int row = infectedCell / colCount;
                        int col = infectedCell % colCount;
                        isInfected[row][col] = -1;
                    }
                } else {
                    // Spread the virus from the other areas
                    for (int infectedCell : infectedAreas.get(index)) {
                        int row = infectedCell / colCount;
                        int col = infectedCell % colCount;
                        for (int k = 0; k < 4; ++k) {
                            int newRow = row + DIRECTIONS[k];
                            int newCol = col + DIRECTIONS[k + 1];
                            if (isValidPosition(newRow, newCol) && isInfected[newRow][newCol] == 0) {
                                isInfected[newRow][newCol] = 1;
                            }
                        }
                    }
                }
            }
        }
        return wallsRequired;
    }

    // Utility method to get the index of the area which is spreading the virus most
    private int getMaxBoundaryIndex() {
        int index = 0;
        int maxBoundarySize = areaBoundaries.get(0).size();
        for (int i = 1; i < areaBoundaries.size(); ++i) {
            int boundarySize = areaBoundaries.get(i).size();
            if (maxBoundarySize < boundarySize) {
                maxBoundarySize = boundarySize;
                index = i;
            }
        }
        return index;
    }

    // Deep first search to explore and mark all cells in an infected area
    private void deepFirstSearch(int row, int col) {
        visited[row][col] = true;
        int currentAreaIndex = infectedAreas.size() - 1;
        infectedAreas.get(currentAreaIndex).add(row * colCount + col);

        for (int k = 0; k < 4; ++k) {
            int newRow = row + DIRECTIONS[k];
            int newCol = col + DIRECTIONS[k + 1];
            if (isValidPosition(newRow, newCol)) {
                if (isInfected[newRow][newCol] == 1 && !visited[newRow][newCol]) {
                    deepFirstSearch(newRow, newCol);
                } else if (isInfected[newRow][newCol] == 0) {
                    // If the neighboring cell is uninfected, count it as a potential wall and add to the boundary
                    wallCount.set(currentAreaIndex, wallCount.get(currentAreaIndex) + 1);
                    areaBoundaries.get(currentAreaIndex).add(newRow * colCount + newCol);
                }
            }
        }
    }

    // Utility method to check if a given position is within the boundaries of the grid
    private boolean isValidPosition(int row, int col) {
        return row >= 0 && row < rowCount && col >= 0 && col < colCount;
    }
}
