from collections import Counter

class Solution:
    def reorganizeString(self, s: str) -> str:
        res = []
        cc = Counter(s)
        last = ''

        while cc:
            best = ''
            maxOcc = -1
            for char in cc:
                if char == last:
                    continue

                if cc[char] > maxOcc:
                    best = char
                    maxOcc = cc[char]

            if maxOcc == -1:
                return ""

            cc[best] -= 1
            if cc[best] == 0:
                cc.pop(best)

            res.append(best)
            last = best

        return ''.join(res)



