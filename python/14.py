class Solution:
    def longestCommonPrefix(self, strs: list[str]) -> str:
        pref = 0
        res = []
        while True:
            for s in strs:
                if pref >= len(s):
                    return "".join(res)
                if s[pref] != strs[0][pref]:
                    return "".join(res)
            res.append(strs[0][pref])
            pref += 1

        return "".join(res)

