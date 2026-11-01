class Solution:
    def rotate(self, matrix: list[list[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        n = len(matrix)
        for i in range(n // 2):
            ilen = n - 2 * i
            for k in range(1, ilen):
                matrix[i][i + k], matrix[i + k][n - 1 - i], matrix[n - 1 - i][n - 1 - i - k], matrix[n - 1 - i - k][i] = \
                    matrix[n - 1 - i - k][i], matrix[i][i + k], matrix[i + k][n - 1 - i], matrix[n - 1 - i][
                        n - 1 - i - k]
