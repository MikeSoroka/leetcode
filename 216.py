class Solution:
    def combinationSum3(self, k: int, n: int) -> list[list[int]]:
        path = []
        res = []

        def backtrack(minv, target, remaining):
            if target == 0 and remaining == 0:
                res.append(path[:])
                return

            if minv > target or remaining == 0 or minv == 10:
                return

            backtrack(minv + 1, target, remaining)
            path.append(minv)
            backtrack(minv + 1, target - minv, remaining - 1)
            path.pop()

        backtrack(1, n, k)
        return res
