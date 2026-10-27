class Solution {
    public int countIslands(int[][] grid, int k) {
        var offArr = new int[][]{{1, 0}, {0, 1},{-1, 0}, {0, -1}};

        var rows = grid.length;
        var cols = grid[0].length;

        var visited = new boolean[rows][cols];
        var res = 0;

        for(int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (visited[row][col] || (grid[row][col] == 0)) continue;

                var curSum = 0;
                var q = new ArrayDeque<int[]>();
                q.add(new int[]{row, col});
                while (!q.isEmpty()) {
                    var cur = q.remove();
                    int curR = cur[0], curC = cur[1];

                    if (visited[curR][curC]) continue;
                    visited[curR][curC] = true;
                    curSum = (curSum + grid[curR][curC]) % k;
                    for(var off: offArr) {
                        var dr = off[0];
                        var dc = off[1];

                        if (0 <= dr + curR && dr + curR < rows && 0 <= dc + curC && dc + curC < cols && grid[curR + dr][curC + dc] != 0) {
                            q.add(new int[]{curR + dr, curC + dc});
                        }
                    }
                }

                if (curSum % k == 0) res++;
            }

        }

        return res;
    }
}