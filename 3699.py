class Solution:
    def zigZagArrays(self, n: int, l: int, r: int) -> int:
        R = r - l + 1 # range
        dp = [[1] * R, [1] * R] # dec; inc
        for _ in range(n - 1):
            suminc = sum(dp[1])
            dec = []
            for i in range(R - 1, -1, -1):
                suminc -= dp[1][i]
                dec.append(suminc % (10**9 + 7))
            dec = dec[::-1]

            sumdec = sum(dp[0])
            inc = []
            for i in range(R):
                sumdec -= dp[0][i]
                inc.append(sumdec % (10**9 + 7))

            dp = [dec, inc]

        return (sum(dp[0]) % (10**9 + 7) + sum(dp[1])% (10**9 + 7)) % (10**9 + 7)



