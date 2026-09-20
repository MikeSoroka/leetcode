class Solution:
    def numTilings(self, n: int) -> int:
        dp = [0] * (n + 1)
        dp[0] = 1
        dp[1] = 1
        if n > 1:
            dp[2] = 2
        for i in range(3, n + 1):
            for j in range(3, i + 1, 2):
                dp[i] += 2 * dp[i - j]
                dp[i] %= 10 ** 9 + 7
            for j in range(4, i + 1, 2):
                dp[i] += 2 * dp[i - j]
                dp[i] %= 10 ** 9 + 7
            dp[i] += dp[i - 1]
            dp[i] %= 10 ** 9 + 7
            dp[i] += dp[i - 2]
            dp[i] %= 10 ** 9 + 7

        return dp[n]