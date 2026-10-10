class Solution {
    public int minSessions(int[] tasks, int sessionTime) {
        var n = tasks.length;
        var dp = new int[1 << n][sessionTime];
        var INF = Integer.MAX_VALUE / 2;
        for(var row: dp) Arrays.fill(row, INF);
        dp[0][0] = 0;

        for(var mask = 0; mask < (1 << n); mask++) {
            for (var task = 0; task < n; task++) {
                if (((mask >> task) & 1) == 1) continue;
                for(var timeLeft = 0; timeLeft < sessionTime; timeLeft++) {
                    if (timeLeft >= tasks[task]) dp[mask | (1 << task)][timeLeft - tasks[task]] = Math.min(dp[mask | (1 << task)][timeLeft - tasks[task]], dp[mask][timeLeft]);
                    else dp[mask | (1 << task)][sessionTime - tasks[task]] = Math.min(dp[mask | (1 << task)][sessionTime - tasks[task]], 1 + dp[mask][timeLeft]);
                }
            }
        }

        return Arrays.stream(dp[dp.length - 1]).min().getAsInt();
    }
}