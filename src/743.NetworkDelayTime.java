class Solution {

    private static final int MAX_NODES = 110;
    private static final int INFINITY = 0x3f3f3f3f;

    public int networkDelayTime(int[][] times, int n, int k) {

        int[][] graph = new int[MAX_NODES][MAX_NODES];
        for (int i = 0; i < MAX_NODES; ++i) {
            Arrays.fill(graph[i], INFINITY);
        }

        for (int[] edge : times) {
            graph[edge[0]][edge[1]] = edge[2];
        }

        int[] distances = new int[MAX_NODES];
        Arrays.fill(distances, INFINITY);

        distances[k] = 0;

        boolean[] visited = new boolean[MAX_NODES];

        for (int i = 0; i < n; ++i) {
            int currentNode = -1;

            for (int j = 1; j <= n; ++j) {
                if (!visited[j] && (currentNode == -1 || distances[currentNode] > distances[j])) {
                    currentNode = j;
                }
            }

            visited[currentNode] = true;

            for (int j = 1; j <= n; ++j) {
                distances[j] = Math.min(distances[j], distances[currentNode] + graph[currentNode][j]);
            }
        }

        int answer = 0;
        for (int i = 1; i <= n; ++i) {
            answer = Math.max(answer, distances[i]);
        }

        return answer == INFINITY ? -1 : answer;
    }
}
