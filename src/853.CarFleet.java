class Solution {
    public int carFleet(int target, int[] positions, int[] speeds) {
        int carCount = positions.length;
        Integer[] indices = new Integer[carCount];

        for (int i = 0; i < carCount; ++i) {
            indices[i] = i;
        }

        Arrays.sort(indices, (a, b) -> positions[b] - positions[a]);

        int fleetCount = 0;
        double previousTime = 0;

        for (int index : indices) {
            double timeToReach = 1.0 * (target - positions[index]) / speeds[index];
            if (timeToReach > previousTime) {
                fleetCount++;
                previousTime = timeToReach;
            }
        }

        return fleetCount;
    }
}
