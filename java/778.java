class Solution {
    public int swimInWater(int[][] grid) {
        int[][] DIRECTIONS = new int[][] {new int[] {-1, 0}, new int[] {1, 0}, new int[] {0, -1}, new int[] {0, 1}};

        int n = grid.length;
        var pq = new PriorityQueue<int[][]>(Comparator.comparingInt(a -> a[0][0]));
        pq.add(new int[][]{new int[]{grid[0][0]}, new int[]{0, 0}});
        var dists = new int[n][n];
        Arrays.stream(dists).forEach(row -> Arrays.fill(row, -1));

        while (!pq.isEmpty()) {
            var curr = pq.poll();
            int dist = curr[0][0], row = curr[1][0], col = curr[1][1];
            if (dists[row][col] != -1) continue;
            dists[row][col] = dist;

            for (var d: DIRECTIONS) {
                if (0 <= d[0] + row && d[0] + row < n && 0 <= d[1] + col && d[1] + col < n && dists[d[0] + row][d[1] + col] == -1){
                    pq.add(new int[][]{new int[]{Math.max(grid[d[0] + row][d[1] + col], dist)}, new int[]{d[0] + row, d[1] + col}});
                }
            }
        }

        return dists[n - 1][n - 1];
    }
}