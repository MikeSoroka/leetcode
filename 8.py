class Solution:
    def myAtoi(self, s: str) -> int:
        isStarted = False
        isSigned = False
        mult = 1
        res = 0
        for c in s:
            if c != " ":
                isStarted = True
            if isStarted and not isSigned:
                isSigned = True
                if c == "-":
                    mult = -1
                    continue
            if isStarted and isSigned:
                if c in "0123456789":
                    res *= 10
                    res += int(c)

                    if mult < 0:
                        res %= (2 ** 31 + 1)
                    else:
                        res %= 2 ** 31

        return res * mult


