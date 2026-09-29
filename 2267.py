class Solution:
    def hasValidPath(self, grid: list[list[str]]) -> bool:
        nr = len(grid)
        nc = len(grid[0])
        def get_neighbors(point):
            row, col = point
            for dr, dc in ((1, 0), (0, 1)):
                if 0 <= row + dr < nr and 0 <= col + dc < nc:
                    yield row + dr, col + dc

        memo = {}
        def dfs(curr, balance):
            if (curr, balance) in memo:
                return memo[(curr, balance)]
            memo[(curr, balance)] = False
            r, c = curr
            if grid[r][c] == "(":
               balance += 1
            elif not balance:
                return False
            else:
                balance -= 1

            if balance > nr + nc - r - c:
                return False

            if r == nr - 1 and c == nc - 1 and not balance:
                return True
            for n in get_neighbors(curr):
                if dfs(n, balance):
                    return True
            return False



        if grid[0][0] == ")" or grid[nr - 1][nc - 1] == "(" or (nr + nc - 1) % 2:
            return False
        return dfs((0, 0), 0)