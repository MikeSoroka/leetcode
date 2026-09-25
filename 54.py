class Solution:
    def spiralOrder(self, matrix: list[list[int]]) -> list[int]:
        nrow = len(matrix)
        ncol = len(matrix[0])

        direction = -1
        row = 0
        col = 0
        offset = 0
        nvisited = 0
        res = []

        while nvisited < nrow * ncol:
            if nrow == 2 * offset + 1:
                for c in range(offset, ncol - offset):
                    res.append(matrix[offset][c])

                return res
            elif ncol == 2 * offset + 1:
                for r in range(offset, nrow - offset):
                    res.append(matrix[r][offset])

                return res

            nvisited += 1
            res.append(matrix[row][col])

            if row == offset and col == offset:
                direction = 1
            elif row == offset and col == ncol - 1 - offset:
                direction = 2
            elif row == nrow - 1 - offset and col == ncol - 1 - offset:
                direction = 3
            elif row == nrow - 1 - offset and col == offset:
                direction = 4
            elif row == offset + 1 and col == offset:
                offset += 1
                direction = 1

            if direction == 1:
                col += 1
            elif direction == 2:
                row += 1
            elif direction == 3:
                col -= 1
            else:
                row -= 1

        return res


