class Solution {
    public long[] resultArray(int[] nums, int k) {
        var n = nums.length;

        var dp = new long[n][k];
        dp[0][nums[0] % k] = 1;

        for(int i = 1; i < n; i++) {
            var rem = nums[i] % k;
            dp[i][rem] += 1;
            for (int j = 0; j < k; j++) {
                for(int t = 0; t < k; t++) {
                    if ((t * rem) % k == j) {
                        dp[i][j] += dp[i-1][t];
                    }
                }
            }
        }

        var res = new long[k];
        for(int i = 0; i < k; i++) {
            for(int j = 0; j < n; j++) {
                res[i] += dp[j][i];
            }
        }

        return res;
    }
}