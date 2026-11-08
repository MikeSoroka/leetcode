class Solution:
    def generate(self, numRows: int) -> list[list[int]]:
        res = []
        for row in range(numRows):
            if row == 0:
                newRow = [1]
            else:
                last = res[-1]
                newRow = [1]
                for i in range(1, len(last)):
                    newRow.append(last[i] + last[i - 1])
                newRow.append(1)

            res.append(newRow)

        return res