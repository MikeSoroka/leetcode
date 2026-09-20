class Solution:
    def minArraySum(self, nums: List[int], k: int, op1: int, op2: int) -> int:
        INF = float('inf')
        dp = [[INF] * (op2 + 1) for _ in range(op1 + 1)]
        dp[0][0] = 0

        for x in nums:
            h = (x + 1) // 2
            ndp = [[INF] * (op2 + 1) for _ in range(op1 + 1)]
            for a in range(op1 + 1):
                for b in range(op2 + 1):
                    cur = dp[a][b]
                    if cur == INF:
                        continue
                    ndp[a][b] = min(ndp[a][b], cur + x)
                    if a < op1:
                        ndp[a + 1][b] = min(ndp[a + 1][b], cur + h)
                    if b < op2 and x >= k:
                        ndp[a][b + 1] = min(ndp[a][b + 1], cur + x - k)
                    if a < op1 and b < op2:
                        best = INF
                        if h >= k:
                            best = min(best, h - k)
                        if x >= k:
                            best = min(best, (x - k + 1) // 2)
                        if best < INF:
                            ndp[a + 1][b + 1] = min(ndp[a + 1][b + 1], cur + best)
            dp = ndp

        return min(min(row) for row in dp)