class Solution:
    def convert(self, s: str, numRows: int) -> str:
        if numRows == 1:
            return s

        def to_res(matrix):
            res_strs = []
            for arr in matrix:
                res_strs.append(''.join(arr))
            return ''.join(res_strs)

        rows = [[] for i in range(numRows)]
        curRow = numRows - 1
        i = 0
        while i < len(s):
            if curRow == numRows - 1:
                for j in range(numRows):
                    if i + j >= len(s):
                        return to_res(rows)
                    rows[j].append(s[i + j])
                i += j
            elif curRow == 0:
                for j in range(numRows):
                    if i + j >= len(s):
                        return to_res(rows)
                    rows[j].append(s[i + j])
                i += j
                curRow = numRows - 1
            else:
                rows[curRow].append(s[i])
                # else:
                #     rows[curRow].append(s[i])

            i += 1
            curRow -= 1

        print(rows)
        return to_res(rows)

# "PAYPALISHIRING"
# [['P', 'I', 'R'],
#  ['A', 'L', 'H', 'I'],
#  ['Y', 'A', 'S', 'N'],
#  ['P', 'I', 'G']]

# [['P', 'I', 'R'],
#  ['A', 'L', 'S', 'I'],
#  ['Y', 'A', 'H', 'N'],
#  ['P', 'I', 'G']]
