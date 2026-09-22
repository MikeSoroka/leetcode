from collections import Counter


class Solution:
    def lexSmallestAfterDeletion(self, s: str) -> str:
        cs = Counter(s)
        stack = []
        for ch in s:
            while stack and ch < stack[-1]:
                if cs[stack[-1]] > 1:
                    cs[stack[-1]] -= 1
                    stack.pop()
                else:
                    break

            stack.append(ch)

        while cs[stack[-1]] > 1:
            cs[stack[-1]] -= 1
            stack.pop()

        return ''.join(stack)