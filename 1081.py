class Solution:
    def smallestSubsequence(self, s: str) -> str:
        cs = Counter(s)
        stack = []
        picked = set()
        for ch in s:
            if ch in picked:
                cs[ch] -= 1
                continue
            while stack and ch <= stack[-1]:
                if cs[stack[-1]] > 1:
                    cs[stack[-1]] -= 1
                    picked.remove(stack[-1])
                    stack.pop()
                else:
                    break

            stack.append(ch)
            picked.add(ch)

        while cs[stack[-1]] > 1:
            cs[stack[-1]] -= 1
            stack.pop()

        return ''.join(stack)